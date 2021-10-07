/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S1Suite extends munit.FunSuite {

  import S1._

  def mkTest(i: Int): (List[Int], List[List[Int]], String) = { 
    if (i == 1) (List(), List(Nil), "tails of an empty list")
    else if (i == 2) (List(3, 7, 2), List(List(3, 7, 2), List(7, 2), List(2), List()), "tails of a non-empty list 3")
    else (List(), List(), "tails of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(tails(in), out, msg)
    })
  }

  test("tails of an empty list (10pts)") {
    assertEquals(tails(List()), List(List()))
  }

  test("tails of a non-empty list 3 (10pts)") {
    assertEquals(tails(List(3, 7, 2)), List(List(3, 7, 2), List(7, 2), List(2), List()))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
