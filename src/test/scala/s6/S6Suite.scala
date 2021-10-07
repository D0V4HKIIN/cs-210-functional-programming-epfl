/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s6

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S6Suite extends munit.FunSuite {

  import S6._

  def mkTest(i: Int): (List[Int], Boolean, String) = { 
    if (i == 1) (List(), true, "sort check of an empty list")
    else if (i == 2) (List(3, 7, 5), false, "sort check of a non-empty list 3")
    else if (i == 3) (List(4, 8), true, "sort check of a non-empty list 2")
    else (List(), true, "sort check of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(sorted(in), out, msg)
    })
  }

  test("sort check of an empty list (10pts)") {
    assertEquals(sorted(List()), true)
  }

  test("sort check of a non-empty list 3 (10pts)") {
    assertEquals(sorted(List(3, 7, 5)), false)
  }

  test("sort check of a non-empty list 2 (10pts)") {
    assertEquals(sorted(List(4, 8)), true)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}