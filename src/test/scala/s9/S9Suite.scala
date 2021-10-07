/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s9

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S9Suite extends munit.FunSuite {

  import S9._

  def mkTest(i: Int): (List[Char], List[(Int, Char)], String) = { 
    if (i == 1) (List(), List(), "run-length of an empty list")
    else if (i == 2) (List('e', 'e', 'y'), List((2, 'e'), (1, 'y')), "run-length of a non-empty list 3")
    else if (i == 3) (List('e', 'z'), List((1, 'e'), (1, 'z')), "run-length of a non-empty list 2")
    else (List(), List(), "run-length of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(runLength(in), out, msg)
    })
  }

  test("run-length of an empty list (10pts)") {
    assertEquals(runLength(List()), List())
  }

  test("run-length of a non-empty list 3 (10pts)") {
    assertEquals(runLength(List('e', 'e', 'y')), List((2, 'e'), (1, 'y')))
  }

  test("run-length of a non-empty list 3 (10pts)") {
    assertEquals(runLength(List('e', 'z')), List((1, 'e'), (1, 'z')))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}