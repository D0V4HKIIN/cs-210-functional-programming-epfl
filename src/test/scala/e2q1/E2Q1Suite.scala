/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e2q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q1Suite extends munit.FunSuite {

  import E2Q1._

  def mkTest(i: Int): ((Int, Double) => Int, (Double, Int), Int, String) = { 
    if (i == 1) ((i, d) => i, (3.5, 1), 1, "identity")
    else if (i == 2) ((i, d) => i * d.intValue, (4.729, 8), 32, "multiplication")
    else if (i == 3) ((i, d) => i / d.intValue, (1, 0), 0, "division")
    else if (i == 4) ((i, d) => if i > d then i else d.intValue, (150.1, 25), 150, "comparison")
    else ((i, d) => i, (3.5, 1), 1, "identity")
  }

  test("test everything (10pts)") {
    (1 to 4).foreach((i: Int) => {
      val (in, args, out, msg) = mkTest(i)
      assertEquals(flip(in)(args._1, args._2), out, msg)
    })
  }

  test("identity (10pts)") {
    assertEquals(flip((i, d) => i)(3.5, 1), 1)
  }

  test("multiplication (10pts)") {
    assertEquals(flip((i, d) => i * d.intValue)(4.729, 8), 32)
  }

  test("division (10pts)") {
    assertEquals(flip((i, d) => i / d.intValue)(1, 0), 0)
  }

  test("comparison (10pts)") {
    assertEquals(flip((i, d) => if i > d then i else d.intValue)(150.1, 25), 150)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
