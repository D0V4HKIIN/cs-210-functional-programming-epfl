/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e4q3

object E4Q3 {

  abstract class Expr
  case class Number(x: Int) extends Expr
  case class Var(name: String) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

/**
  *
  * @param expr The expression to be simplified
  * @return The simplified version of `expr`
  */
  def simplify(expr: Expr): Expr = ???

}
