/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e4q3

import javax.print.SimpleDoc

object E4Q3SuiteIO:
  
  import E4Q3._

  sealed abstract class Tests
  case class SimplifyWorksOnCase(arg: Expr, res: Expr, descr: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SimplifyWorksOnCase(Sum(Number(11), Number(19)), Number(30), "a sum of scalars", 10),
      SimplifyWorksOnCase(Sum(Number(0), Prod(Var("x"), Var("y"))), Prod(Var("x"), Var("y")), "a sum with a null term", 10),
      SimplifyWorksOnCase(Prod(Number(11), Number(15)), Number(165), "a product of scalars", 10),
      SimplifyWorksOnCase(Prod(Number(0), Prod(Var("x"), Var("y"))), Number(0), "a product with a null term", 10),
      SimplifyWorksOnCase(Prod(Number(1), Prod(Var("x"), Var("y"))), Prod(Var("x"), Var("y")), "a product with 1", 10),
      SimplifyWorksOnCase(Sum(Prod(Var("x"), Var("y")), Prod(Var("x"), Var("y"))), Prod(Number(2), Prod(Var("x"), Var("y"))), "a sum of two same terms", 10),
      SimplifyWorksOnCase(Sum(Sum(Sum(Sum(Var("x"), Number(1)), Number(2)), Number(3)), Number(4)), Sum(Var("x"), Number(10)), "some nested sums", 10),
      SimplifyWorksOnCase(Sum(Number(4), Sum(Sum(Number(2), Sum(Var("x"), Number(1))), Number(3))), Sum(Var("x"), Number(10)), "some nested sums but with mixed sides",15),
      SimplifyWorksOnCase(Prod(Prod(Prod(Prod(Var("x"), Number(2)), Number(3)), Number(4)), Number(5)), Prod(Var("x"), Number(120)), "some nested products", 10),
      SimplifyWorksOnCase(Sum(Sum(Prod(Var("x"), Number(1)), Prod(Number(1), Var("x"))), Number(0)), Prod(Number(2), Var("x")), "the example", 10),
      //SimplifyWorksOnCase(Sum(Prod(Var("x"), Var("y")), Sum(Prod(Var("x"), Var("y")), Prod(Var("x"), Var("y")))), Prod(Number(3), Prod(Var("x"), Var("y"))), "new", 15)
    )
