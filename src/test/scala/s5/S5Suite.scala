/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s5

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S5Suite extends munit.FunSuite {

  import S5._

  def mkTest(i: Int): (List[Int], List[Int], String) = { 
    if (i == 1) (List(), List(), "every other element of an empty list")
    else if (i == 2) (List(3, 7, 5), List(3, 5), "every other element of a non-empty list 3")
    else if (i == 3) (List(4, 8), List(4), "every other element of a non-empty list 2")
    else (List(), List(), "every other element of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(everyOther(in), out, msg)
    })
  }

  test("every other element of an empty list (10pts)") {
    assertEquals(everyOther(List()), List())
  }

  test("every other element of a non-empty list 3 (10pts)") {
    assertEquals(everyOther(List(3, 7, 5)), List(3, 5))
  }

  test("every other element of a non-empty list 2 (10pts)") {
    assertEquals(everyOther(List(4, 8)), List(4))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}