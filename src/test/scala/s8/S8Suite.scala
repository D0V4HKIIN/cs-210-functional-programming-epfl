/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s8

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S8Suite extends munit.FunSuite {

  import S8._

  def mkTest(i: Int): ((List[Char], Int), List[Char], String) = { 
    if (i == 1) ((List(), 2), List(), "duplicate 2 times an empty list")
    else if (i == 2) ((List('e', 'a', 'y'), 2), List('e', 'e', 'a', 'a', 'y', 'y'), "duplicate 2 times a non-empty list 3")
    else if (i == 3) ((List('e', 'z'), 3), List('e', 'e', 'e', 'z', 'z', 'z'), "duplicate 3 times a non-empty list 2")
    else ((List(), 2), List(), "duplicate 2 times an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(duplicateN(in._1, in._2), out, msg)
    })
  }

  test("duplicate 2 times an empty list (10pts)") {
    assertEquals(duplicateN(List(), 2), List())
  }

  test("duplicate 2 times a non-empty list 3 (10pts)") {
    assertEquals(duplicateN(List('e', 'a', 'y'), 2), List('e', 'e', 'a', 'a', 'y', 'y'))
  }

  test("duplicate 3 times a non-empty list 2 (10pts)") {
    assertEquals(duplicateN(List('e', 'z'), 3), List('e', 'e', 'e', 'z', 'z', 'z'))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}