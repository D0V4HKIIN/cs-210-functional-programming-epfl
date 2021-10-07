/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e4q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E4Q3Suite extends munit.FunSuite {

  import E4Q3._


  def mkTest(i: Int): (Expr, Expr, String) = { 
    if (i == 1) (Sum(Number(11), Number(19)), Number(30), "sum of scalars")
    else if (i == 2) (Sum(Number(0), Prod(Var("x"), Var("y"))), Prod(Var("x"), Var("y")), "sum with a null term")
    else if (i == 3) (Prod(Number(11), Number(15)), Number(165), "product of scalars")
    else if (i == 4) (Prod(Number(0), Prod(Var("x"), Var("y"))), Number(0), "product with a null term")
    else if (i == 5) (Prod(Number(1), Prod(Var("x"), Var("y"))), Prod(Var("x"), Var("y")), "product with 1")
    else (Sum(Number(11), Number(19)), Number(40), "sum of scalars")
  }

  test("test everything (10pts)") {
    (1 to 5).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(simplify(in), out, msg)
    })
  }

  test("sum of scalars (10pts)") {
    assertEquals(simplify(Sum(Number(11), Number(19))), Number(30))
  }

  test("sum with a null term (10pts)") {
    assertEquals(simplify(Sum(Number(0), Prod(Var("x"), Var("y")))), Prod(Var("x"), Var("y")))
  }

  test("product of scalars (10pts)") {
    assertEquals(simplify(Prod(Number(11), Number(15))), Number(165))
  }

  test("product with a null term (10pts)") {
    assertEquals(simplify(Prod(Number(0), Prod(Var("x"), Var("y")))), Number(0))
  }

  test("product with 1 (10pts)") {
    assertEquals(simplify(Prod(Number(1), Prod(Var("x"), Var("y")))), Prod(Var("x"), Var("y")))
  }  


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
