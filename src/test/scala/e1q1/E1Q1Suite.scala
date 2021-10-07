/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e1q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q1Suite extends munit.FunSuite {

  import E1Q1._

  def mkTest(i: Int): (Int, Int, String) = { 
    if (i == 1) (0, 1, "factorial of 0")
    else if (i == 2) (1, 1, "factorial of 1")
    else if (i == 3) (5, 120, "factorial of 5")
    else if (i == 4) (10, 3628800, "factorial of 10")
    else (0, 1, "factorial of 0")
  }

  test("test everything (10pts)") {
    (1 to 4).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(factorial(in), out, msg)
    })
  }

  test("factorial of 0 (10pts)") {
    assertEquals(factorial(0), 1)
  }

  test("factorial of 1 (10pts)") {
    assertEquals(factorial(1), 1)
  }

  test("factorial of 5 (10pts)") {
    assertEquals(factorial(5), 120)
  }

  test("factorial of 10 (10pts)") {
    assertEquals(factorial(10), 3628800)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
