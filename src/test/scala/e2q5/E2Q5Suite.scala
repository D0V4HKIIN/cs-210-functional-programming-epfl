/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e2q5

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q5Suite extends munit.FunSuite {

  import E2Q5._

  def mkTest1(i: Int): ((Int, Int), Int => Int, Int, String) = { 
    if (i == 1) ((1, 10), x => x, 55, "sum of integers")
    else if (i == 2) ((1, 10), x => x*x, 385, "sum of squares of integers")
    else ((1, 10), x => x, 55, "sum of integers")
  }

  def mkTest2(i: Int): (Int, Int, Int, String) = { 
    if (i == 1) (0, 1, 1, "quadratic with c=0")
    else if (i == 2) (5, 10, 25, "quadratic with c=5")
    else if (i == 3) (10, 10, 0, "quadratic with c=10")
    else (0, 1, 1, "quadratic with c=0")
  }

  def mkTest3(i: Int): ((Int, Int), Int, String) = { 
    if (i == 1) ((4, 5), 1, "quad3Integrate for one value")
    else if (i == 2) ((5, 7), 13, "quad3Integrate for 2 values")
    else if (i == 3) ((4, 104), 338350, "quad3Integrate for many values")
    else ((4, 5), 1, "quad3Integrate 0 time")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, arg, out, msg) = mkTest1(i)
      assertEquals(sum(in._1, in._2)(arg), out, msg)
    })

    (1 to 3).foreach((i: Int) => {
      val (in, arg, out, msg) = mkTest2(i)
      assertEquals(quadratic(in)(arg), out, msg)
    })

    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest3(i)
      assertEquals(quad3Integrate(in._1, in._2), out, msg)
    })
  }

  test("sum of integers (10pts)") {
    assertEquals(sum(1, 10)(x => x), 55)
  }

  test("sum of squares of integers (10pts)") {
    assertEquals(sum(1, 10)(x => x*x), 385)
  }

  test("quadratic with c=0 (10pts)") {
    assertEquals(quadratic(0)(1), 1)
  }

  test("quadratic with c=5 (10pts)") {
    assertEquals(quadratic(5)(10), 25)
  }

  test("quadratic with c=10 (10pts)") {
    assertEquals(quadratic(10)(10), 0)
  }

  test("quad3Integrate for one value (10pts)") {
    assertEquals(quad3Integrate(4, 5), 1)
  }

  test("quad3Integrate for two values (10pts)") {
    assertEquals(quad3Integrate(5, 7), 13)
  }

  test("quad3Integrate for many values (10pts)") {
    assertEquals(quad3Integrate(4, 104), 338350)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
