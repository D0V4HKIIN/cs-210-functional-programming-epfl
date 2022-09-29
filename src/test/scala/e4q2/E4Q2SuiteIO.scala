/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e4q2

object E4Q2SuiteIO:
  
  import E4Q2._

  sealed abstract class Tests
  case class DerivWorksOnCase(expr: Expr, v: String, res: Expr, descr: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      DerivWorksOnCase(Number(42), "x", Number(0), "a constant", 10),
      DerivWorksOnCase(Var("x"), "x", Number(1), "a lonely variable", 10),
      DerivWorksOnCase(Var("y"), "x", Number(0), "a foreign variable", 10),
      DerivWorksOnCase(Sum(Number(12), Number(21)), "x", Sum(Number(0), Number(0)), "a sum of constant", 10),
      DerivWorksOnCase(Prod(Number(12), Number(21)), "x", Sum(Prod(Number(0), Number(21)), Prod(Number(12), Number(0))), "a product of constant", 10),
      DerivWorksOnCase(Sum(Prod(Var("x"), Var("x")), Var("y")), "x", Sum(Sum(Prod(Number(1), Var("x")), Prod(Var("x"), Number(1))), Number(0)), "the example", 10),
      DerivWorksOnCase(
        Sum(Prod(Number(2), Var("y")), Sum(Prod(Var("x"), Prod(Number(3) ,Var("x"))), Number(4))),
        "x",
        Sum(
          Sum(Prod(Number(0), Var("y")), Prod(Number(2), Number(0))),
          Sum(Sum(Prod(Number(1), Prod(Number(3) ,Var("x"))), Prod(Var("x"), Sum(Prod(Number(0), Var("x")), Prod(Number(3), Number(1))))), Number(0))
        ),
        "2*y + 3x² + 4", 10
      )
    )