/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S2Suite extends munit.FunSuite {

  import S2._

  def mkTest(i: Int): (List[Int], Option[Int], String) = { 
    if (i == 1) (List(), None, "last element of an empty list")
    else if (i == 2) (List(5, 9, 7), Some(7), "last element of a non-empty list 3")
    else (List(), None, "last element of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(last(in), out, msg)
    })
  }

  test("last element of an empty list (10pts)") {
    assertEquals(last(List()), None)
  }

  test("last element of a non-empty list 3 (10pts)") {
    assertEquals(last(List(5, 9, 7)), Some(7))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}