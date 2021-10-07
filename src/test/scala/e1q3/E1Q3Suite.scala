/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e1q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q3Suite extends munit.FunSuite {

  import E1Q3._

  def mkTest(i: Int): ((Int, Int), Int, String) = { 
    if (i == 1) ((42, 0), 1, "power of 0")
    else if (i == 2) ((101, 1), 101, "power of 1")
    else if (i == 3) ((64, 2), 4096, "power of 2")
    else if (i == 4) ((666, 3), 295408296, "power of 3")
    else if (i == 5) ((7, 10), 282475249, "power of 10")
    else ((42, 0), 1, "power of 0")
  }

  test("test everything (10pts)") {
    (1 to 5).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(fastExp(in._1, in._2), out, msg)
    })
  }

  test("power of 0 (10pts)") {
    assertEquals(fastExp(42, 0), 1)
  }

  test("power of 1 (10pts)") {
    assertEquals(fastExp(101, 1), 101)
  }

  test("power of 2 (10pts)") {
    assertEquals(fastExp(64, 2), 4096)
  }

  test("power of 3 (10pts)") {
    assertEquals(fastExp(666, 3), 295408296)
  }

  test("power of 10 (10pts)") {
    assertEquals(fastExp(7, 10), 282475249)
  }

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
