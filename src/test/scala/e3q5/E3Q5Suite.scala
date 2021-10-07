/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e3q5

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q5Suite extends munit.FunSuite {

  import E3Q5._

  val leq: (Int, Int) => Boolean = (x, y) => x <= y

  def mkTest(i: Int): (List[Int], List[Int], String) = { 
    if (i == 1) (List(), List(), "sort an empty list")
    else if (i == 2) (List(1), List(1), "sort a single-element list")
    else if (i == 3) (List(2, 5, 4, 6, 7, 1, 3, 9, 8), List(1, 2, 3, 4, 5, 6, 7, 8, 9), "sort a list 1")
    else if (i == 4) (List(20, -55, -4, 16, 87, 111, 7843, -1919, 0), List(-1919, -55, -4, 0, 16, 20, 87, 111, 7843), "sort a list 2")
    else (List(), List(), "sort an empty list")
  }

  test("test everything (10pts)") {
    (1 to 4).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(sortedList(leq, in), out, msg)
    })
  }

  test("sort an empty list (10pts)") {
    assertEquals(sortedList(leq, List()), List())
  }

  test("sort a single-element list (10pts)") {
    assertEquals(sortedList(leq, List(1)), List(1))
  }

  test("sort a list 1 (10pts)") {
    assertEquals(sortedList(leq, List(2, 5, 4, 6, 7, 1, 3, 9, 8)), List(1, 2, 3, 4, 5, 6, 7, 8, 9))
  }

  test("sort a list 2 (10pts)") {
    assertEquals(sortedList(leq, List(20, -55, -4, 16, 87, 111, 7843, -1919, 0)), List(-1919, -55, -4, 0, 16, 20, 87, 111, 7843))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
