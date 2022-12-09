package interpreter

import scala.annotation.alpha

object RecursiveLanguage {
  /** Expression tree, also called Abstract Syntax Tree (AST) */
  enum Expr:
    case Constant(value: Int)
    case Name(name: String)
    case BinOp(op: BinOps, arg1: Expr, arg2: Expr)
    case IfNonzero(cond: Expr, caseTrue: Expr, caseFalse: Expr)
    case Call(function: Expr, arg: Expr)
    case Fun(param: String, body: Expr)

    /** The empty list, also known as nil. */
    case Empty

    /** A compound data type composed of a head and a tail. */
    case Cons(head: Expr, tail: Expr)

    /** A pattern matching expression for Empty and Cons. */
    case Match(scrutinee: Expr, caseEmpty: Expr, headName: String, tailName: String, caseCons: Expr)
  import Expr._

  /** Primitive operations that operation on constant values. */
  enum BinOps:
    case Plus, Minus, Times, DividedBy, Modulo, LessEq, Eq
  import BinOps._

  def evalBinOp(op: BinOps)(ex: Expr, ey: Expr): Expr =
    (op, ex, ey) match
      case (Plus,   Constant(x), Constant(y)) => Constant(x + y)
      case (Minus,  Constant(x), Constant(y)) => Constant(x - y)
      case (Times,  Constant(x), Constant(y)) => Constant(x * y)
      case (LessEq, Constant(x), Constant(y)) => Constant(if x <= y then 1 else 0)
      case (Eq, Constant(x), Constant(y)) => Constant(if (x == y) then 1 else 0)
      case (Modulo,    Constant(x), Constant(y)) => if y == 0 then error("Division by zero") else Constant(x % y)
      case (DividedBy, Constant(x), Constant(y)) => if y == 0 then error("Division by zero") else Constant(x / y)
      case _ => error(s"Type error in ${show(BinOp(op, ex, ey))}")

  type DefEnv = Map[String, Expr]

  /** Evaluates a progam e given a set of top level definition defs */
  def eval(e: Expr, defs: DefEnv): Expr =
    e match
      case Constant(c) => e
      case Name(n) =>
        defs.get(n) match
          case None => error(s"Unknown name $n")
          case Some(body) => eval(body, defs)
      case BinOp(op, e1, e2) =>
        evalBinOp(op)(eval(e1, defs), eval(e2, defs))
      case IfNonzero(cond, caseTrue, caseFalse) =>
        if eval(cond, defs) != Constant(0) then eval(caseTrue, defs)
        else eval(caseFalse, defs)
      case Fun(n, body) => e
      case Call(fun, arg) =>
        Logger.log(show(e))
        Logger.indent()
        val eFun = eval(fun, defs)
        val eArg = eval(arg, defs)
        eFun match
          case Fun(n, body) =>
            Logger.unindent()
            Logger.log(s"FUN: ${show(eFun)}  ARG: ${show(eArg)}")
            val bodySub = subst(body, n, eArg)
            Logger.log(s"${show(bodySub)}")
            Logger.indent()
            val res = eval(bodySub, defs)
            Logger.unindent()
            Logger.log(s"+--> ${show(res)}")
            res
          case _ => error(s"Cannot apply non-function ${show(eFun)} in a call")
      // add cases for Empty, Cons and Match
      case Empty => Empty
      case Cons(head, tail) => Cons(eval(head, defs), eval(tail, defs))
      case Match(scrutinee, caseEmpty, headName, tailName, caseCons) => 
        val eScrut = eval(scrutinee, defs)
        eScrut match
          case Expr.Empty => caseEmpty
          case Expr.Cons(head, tail) => eval(subst(subst(caseCons, headName, head), tailName, tail), defs)
          case _ => error(s"Cannot match anything else than lists")
        

  /** Substitutes Name(n) by r in e. */
  def subst(e: Expr, n: String, r: Expr): Expr =
    e match
      case Constant(c) => e
      case Name(s) => if s == n then r else e
      case BinOp(op, e1, e2) =>
        BinOp(op, subst(e1, n, r), subst(e2, n, r))
      case IfNonzero(cond, trueE, falseE) =>
        IfNonzero(subst(cond, n, r), subst(trueE, n, r), subst(falseE, n, r))
      case Call(f, arg) =>
        Call(subst(f, n, r), subst(arg, n, r))
      case Fun(param, body) =>
        // If n conflicts with param, there cannot be a reference to n in the
        // function body, there is nothing so substite.
        if param == n then e
        else
          val fvs = freeVars(r)
          // If the free variables in r contain param the naive substitution would
          // change the meaning of param to reference to the function parameter.
          if fvs.contains(param) then
            // Perform alpha conversion in body to eliminate the name collision.
            val param1 = differentName(param, fvs)
            val body1 = alphaConvert(body, param, param1)
            Fun(param1, subst(body1, n, r))
          else
            // Otherwise, substitute in the function body anyway.
            Fun(param, subst(body, n, r))
      case Empty => Empty
      case Cons(head, tail) => Cons(subst(head, n, r), subst(tail, n, r))
      case Match(scrutinee, caseEmpty, headName, tailName, caseCons) =>
        if headName == n || tailName == n then
          // If n conflicts with headName or tailName, there cannot be a reference
          // to n in caseCons. Simply substite n by r in scrutinee and caseEmpty.
          Match(subst(scrutinee, n, r) , subst(caseEmpty, n , r), headName, tailName, caseCons)
        else
          val fvs = freeVars(r)
          // If the free variables in r contain headName or tailName, the naive
          // substitution would change their meaning to reference to pattern binds.
          if fvs.contains(headName) || fvs.contains(tailName) then
            // Perform alpha conversion in caseCons to eliminate the name collision.
            val headName1 = differentName(headName, fvs)
            val tailName1 = differentName(tailName, fvs)
            val caseCons1 = alphaConvert(caseCons, headName, headName1)
            val caseCons2 = alphaConvert(caseCons1, tailName, tailName1)
            Match(subst(scrutinee, n, r) , subst(caseEmpty, n, r), headName1, tailName1, subst(caseCons2, n, r))
          else
            // Otherwise, substitute in scrutinee, caseEmpty & caseCons anyway.
            // If the free variables in r contain param the naive substitution would
            // change the meaning of param to reference to the function parameter.
            Match(subst(scrutinee, n, r), subst(caseEmpty, n, r), headName, tailName, subst(caseCons, n, r))

  def differentName(n: String, s: Set[String]): String =
    if s.contains(n) then differentName(n + "'", s)
    else n

  /** Computes the set of free variable in e. */
  def freeVars(e: Expr): Set[String] =
    e match
      case Constant(c) => Set()
      case Name(s) => Set(s)
      case BinOp(op, e1, e2) => freeVars(e1) ++ freeVars(e2)
      case IfNonzero(cond, trueE, falseE) => freeVars(cond) ++ freeVars(trueE) ++ freeVars(falseE)
      case Call(f, arg) => freeVars(f) ++ freeVars(arg)
      case Fun(param, body) => freeVars(body) - param
      // TODO: Add cases for Empty, Cons & Match
      case Empty => Set()
      case Cons(head, tail) => freeVars(head) ++ freeVars(tail)
      case Match(scrut, caseEmpty, headName, tailName, caseCons) => freeVars(scrut) ++ freeVars(caseEmpty) ++ freeVars(caseCons) - headName - tailName

  /** Substitutes Name(n) by Name(m) in e. */
  def alphaConvert(e: Expr, n: String, m: String): Expr =
    e match
      case Constant(c) => e
      case Name(s) => if s == n then Name(m) else e
      case BinOp(op, e1, e2) =>
        BinOp(op, alphaConvert(e1, n, m), alphaConvert(e2, n, m))
      case IfNonzero(cond, trueE, falseE) =>
        IfNonzero(alphaConvert(cond, n, m), alphaConvert(trueE, n, m), alphaConvert(falseE, n, m))
      case Call(f, arg) =>
        Call(alphaConvert(f, n, m), alphaConvert(arg, n, m))
      case Fun(param, body) =>
        // If n conflicts with param, there cannot be references to n in body,
        // as these would reference param instead.
        if param == n then e
        else Fun(param, alphaConvert(body, n, m))
      // TODO: Add cases for Empty, Cons & Match
      case Empty => Empty
      case Cons(head, tail) => Cons(alphaConvert(head, n, m), alphaConvert(tail, n, m))
      case Match(scrut, caseEmtpy, headName, tailName, caseCons) =>
        if headName == n || tailName == n then e
        else Match(alphaConvert(scrut, n, m), alphaConvert(caseEmtpy, n, m), headName, tailName, alphaConvert(caseCons, n, m))


  case class EvalException(msg: String) extends Exception(msg)

  def error(msg: String) = throw EvalException(msg)

  // Printing and displaying

  /** Pretty print an expression as a String. */
  def show(e: Expr): String =
    e match
      case Constant(c) => c.toString
      case Name(n) => n
      case BinOp(op, e1, e2) =>
        val opString = op match
          case Plus      => "+"
          case Minus     => "-"
          case Times     => "*"
          case DividedBy => "/"
          case Modulo    => "%"
          case LessEq    => "<="
          case Eq    => "=="
        s"($opString ${show(e1)} ${show(e2)})"
      case IfNonzero(cond, caseTrue, caseFalse) =>
        s"(if ${show(cond)} then ${show(caseTrue)} else ${show(caseFalse)})"
      case Call(f, arg) => show(f) + "(" + show(arg) + ")"
      case Fun(n, body) => s"($n => ${show(body)})"
      case Empty => "Empty"
      case Cons(head, tail) => s"Cons(${show(head)}, ${show(tail)})"
      case Match(scrutinee, caseEmpty, headName, tailName, caseCons) => s"$scrutinee match { case Empty => $caseEmpty; case $headName :: $tailName => $caseCons}"

  /** Pretty print top-level definition as a String. */
  def showEnv(env: Map[String, Expr]): String =
    env.map { case (name, body) => s"def $name =\n  ${show(body)}" }.mkString("\n\n") + "\n"

  /** Evaluates an expression with the given top-level definitions with logging enabled. */
  def tracingEval(e: Expr, defs: DefEnv): Expr =
    Logger.on()
    val evaluated = eval(e, defs)
    println(s" ~~> $evaluated\n")
    Logger.off()
    evaluated

  def minus(e1: Expr, e2: Expr)     = BinOp(BinOps.Minus,  e1, e2)
  def plus(e1: Expr, e2: Expr)      = BinOp(BinOps.Plus,   e1, e2)
  def leq(e1: Expr, e2: Expr)       = BinOp(BinOps.LessEq, e1, e2)
  def times(e1: Expr, e2: Expr)     = BinOp(BinOps.Times,  e1, e2)
  def modulo(e1: Expr, e2: Expr)    = BinOp(BinOps.Modulo, e1, e2)
  def dividedBy(e1: Expr, e2: Expr) = BinOp(BinOps.DividedBy, e1, e2)
  // The {Name => N} import syntax renames Name to N in this scope
  import Expr.{Name => N, Constant => C, _}

  /** Examples of top-level definitions (used in tests) */
  val definitions: DefEnv = Map[String, Expr](
    "fact" -> Fun("n",
       IfNonzero(N("n"),
         times(N("n"),
               Call(N("fact"), minus(N("n"), C(1)))),
         C(1))),

    "square" -> Fun("x",
      times(N("x"), N("x"))),

    "twice" -> Fun("f", Fun("x",
      Call(N("f"), Call(N("f"), N("x"))))),

    // TODO Implement map (see recitation session)
    "map" -> Fun("ls", Fun("f", 
      Match(Name("ls"), 
        Empty,
        "x", "xs", 
        Cons(Call(Name("f"), Name("x")), Call(Call(Name("map"), Name("xs")), Name("f")))
      )
    )),

    // TODO Implement gcd (see recitation session)
    "gcd" -> Fun("a", Fun("b",
      IfNonzero(BinOp(Eq, Name("b"), Constant(0)), // Name("b"), 
        Name("a"),
        Call(Call(Name("gcd"), Name("b")), BinOp(Modulo, Name("a"), Name("b"))))
    )),

    // TODO Implement foldLeft (see recitation session)
    "foldLeft" -> Fun("ls", Fun("acc", Fun("f", 
      Match(Name("ls"),
        Name("acc"),
        "x", "xs", 
        Call(Call(Call(Name("foldLeft"),
          Name("xs")),
          Call(Call(Name("f"),
            Name("acc")),
            Name("x"))),
          Name("f"))
      )
    ))),

    // TODO Implement foldRight (analogous to foldLeft, but operate right-to-left)
    "foldRight" -> Fun("ls", Fun("acc", Fun("f", 
      Match(Name("ls"),
        Name("acc"),
        "x", "xs", 
          Call(Call(Name("f"),
            Name("x")),
            Call(Call(Call(Name("foldRight"),
              Name("xs")),
              Name("acc")),
              Name("f"))
          )
      )
    ))),
  )

  def main(args: Array[String]): Unit =
    println(showEnv(definitions))
    tracingEval(Call(N("fact"), C(6)), definitions)
    tracingEval(Call(Call(N("twice"), N("square")), C(3)), definitions)

    // own stuff
    val sum = "sum" -> Fun("a", Fun("b", BinOp(BinOps.Plus, N("a"), N("b"))))
    val div = "div" -> Fun("a", Fun("b", BinOp(BinOps.DividedBy, N("a"), N("b"))))

    val list1 = Cons(C(1), Cons(C(2), Cons(C(3), Empty)))
    val call1 = Call(Call(Call(N("foldLeft"), list1), C(100)), N("sum"))
    tracingEval(call1, definitions + sum)


    val list2 = Cons(C(1000000), Cons(C(20000), Cons(C(3000), Cons(C(400), Cons(C(50), Cons(C(6), Empty))))))
    val call2 = Call(Call(Call(N("foldRight"), list2), C(1)), N("div"))
    tracingEval(call2, definitions + div)
}
