/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e2q4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q4Suite extends munit.FunSuite {

  import E2Q4._

  def mkTest(i: Int): (Int => Int, Int, Int, String) = { 
    if (i == 1) (i => i, 123456, 123456, "fixed point of the identity function")
    else if (i == 2) (i => i/2, 4, 0, "fixed point of a linear function")
    else if (i == 3) (i => if (i % 10 == 0) i else i + 1, 35, 40, "fixed point of a modulo function")
    else if (i == 4) (i => i/2 + 5, 20, 10, "fixed point of an affine function")
    else (i => i, 123456, 123456, "fixed point of identity function")
  }

  test("test everything (10pts)") {
    (1 to 4).foreach((i: Int) => {
      val (in, arg, out, msg) = mkTest(i)
      assertEquals(fixedPoint(in)(arg), out, msg)
    })
  }

  test("fixed point of the identity function (10pts)") {
    assertEquals(fixedPoint(i => i)(123456), 123456)
  }

  test("fixed point of a linear function (10pts)") {
    assertEquals(fixedPoint(i => i/2)(4), 0)
  }

  test("fixed point of a modulo function (10pts)") {
    assertEquals(fixedPoint(i => if (i % 10 == 0) i else i + 1)(35), 40)
  }

  test("fixed point of an affine function (10pts)") {
    assertEquals(fixedPoint(i => i/2 + 5)(20), 10)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
