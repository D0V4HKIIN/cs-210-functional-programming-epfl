/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S4Suite extends munit.FunSuite {

  import S4._

  def mkTest(i: Int): (List[Int], Int, String) = { 
    if (i == 1) (List(), 0, "number of elements of an empty list")
    else if (i == 2) (List(3, 7, 5), 3, "number of elements of a non-empty list 3")
    else (List(), 0, "number of elements of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(length(in), out, msg)
    })
  }

  test("number of elements of an empty list (10pts)") {
    assertEquals(length(List()), 0)
  }

  test("number of elements of a non-empty list 3 (10pts)") {
    assertEquals(length(List(3, 7, 5)), 3)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}