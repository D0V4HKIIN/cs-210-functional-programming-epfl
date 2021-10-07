/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e4q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E4Q2Suite extends munit.FunSuite {

  import E4Q2._


  def mkTest(i: Int): ((Expr, String), Expr, String) = { 
    if (i == 1) ((Number(42), "x"), Number(0), "derivative of a scalar")
    else if (i == 2) ((Var("x"), "x"), Number(1), "derivative of a variable 1")
    else if (i == 3) ((Sum(Number(12), Number(21)), "x"), Sum(Number(0), Number(0)), "derivative of a sum 1")
    else if (i == 4) ((Prod(Number(12), Number(21)), "x"), Sum(Prod(Number(0), Number(21)), Prod(Number(12), Number(0))), "derivative of a product 1")
    else if (i == 5) ((Sum(Prod(Var("x"), Var("x")), Var("y")), "x"), Sum(Sum(Prod(Number(1), Var("x")), Prod(Var("x"), Number(1))), Number(0)), "derivative of the example")
    else ((Number(42), "x"), Number(0), "derivative of a scalar")
  }

  test("test everything (10pts)") {
    (1 to 5).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(deriv(in._1, in._2), out, msg)
    })
  }

  test("derivative of a scalar (10pts)") {
    assertEquals(deriv(Number(42), "x"), Number(0))
  }

  test("derivative of a variable 1 (10pts)") {
    assertEquals(deriv(Var("x"), "x"), Number(1))
  }

  test("derivative of a sum 1 (10pts)") {
    assertEquals(deriv(Sum(Number(12), Number(21)), "x"), Sum(Number(0), Number(0)))
  }

  test("derivative of a product 1 (10pts)") {
    assertEquals(deriv(Prod(Number(12), Number(21)), "x"), Sum(Prod(Number(0), Number(21)), Prod(Number(12), Number(0))))
  }

  test("derivative of the example (10pts)") {
    assertEquals(deriv(Sum(Prod(Var("x"), Var("x")), Var("y")), "x"), Sum(Sum(Prod(Number(1), Var("x")), Prod(Var("x"), Number(1))), Number(0)))
  }  


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
