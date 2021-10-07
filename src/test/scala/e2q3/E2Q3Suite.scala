/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e2q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q3Suite extends munit.FunSuite {

  import E2Q3._

  def mkTest1(i: Int): ((Double, Int) => Boolean, (Double, Int), Boolean, String) = { 
    if (i == 1) ((d: Double, i: Int) => true, (1.0, 57), true, "curry a constant function")
    else if (i == 2) ((d: Double, i: Int) => d > i, (17.5, 17), true, "curry an arbitrary function")
    else ((d: Double, i: Int) => true, (1.0, 57), true, "curry a constant function")
  }

  def mkTest2(i: Int): (Double => Int => Boolean, (Double, Int), Boolean, String) = { 
    if (i == 1) ((d: Double) => (i: Int) => false, (1.0, 57), false, "uncurry a constant function")
    else if (i == 2) ((d: Double) => (i: Int) => d > i, (17.5, 18), false, "uncurry an arbitrary function")
    else ((d: Double) => (i: Int) => true, (1.0, 57), true, "uncurry a constant function")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, args, out, msg) = mkTest1(i)
      assertEquals(curry2(in)(args._1)(args._2), out, msg)
    })

    (1 to 2).foreach((i: Int) => {
      val (in, args, out, msg) = mkTest2(i)
      assertEquals(uncurry2(in)(args._1, args._2), out, msg)
    })
  }

  test("curry a constant function (10pts)") {
    assertEquals(curry2((d: Double, i: Int) => true)(1.0)(57), true)
  }

  test("curry an arbitrary function (10pts)") {
    assertEquals(curry2((d: Double, i: Int) => d > i)(17.5)(17), true)
  }

  test("uncurry a constant function (10pts)") {
    assertEquals(uncurry2((d: Double) => (i: Int) => false)(1.0, 57), false)
  }

  test("uncurry an arbitrary function (10pts)") {
    assertEquals(uncurry2((d: Double) => (i: Int) => d > i)(17.5, 18), false)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
