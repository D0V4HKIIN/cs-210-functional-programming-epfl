/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s11

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S11Suite extends munit.FunSuite {

  import S11._

  def mkTest(i: Int): ((List[Int], Int), List[Int], String) = { 
    if (i == 1) ((List(), 5), List(), "drop every n-th element of an empty list")
    else if (i == 2) ((List(3, 7, 5), 2), List(3, 5), "drop every other element of a non-empty list 3")
    else if (i == 3) ((List(4, 8), 3), List(4, 8), "drop every third element of a non-empty list 2")
    else ((List(), 5), List(), "drop every n-th element of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(drop(in._1, in._2), out, msg)
    })
  }

  test("drop every n-th element of an empty list (10pts)") {
    assertEquals(drop(List(), 5), List())
  }

  test("drop every other element of a non-empty list 3 (10pts)") {
    assertEquals(drop(List(3, 7, 5), 2), List(3, 5))
  }

  test("drop every third element of a non-empty list 2 (10pts)") {
    assertEquals(drop(List(4, 8), 3), List(4, 8))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}