/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s7

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S7Suite extends munit.FunSuite {

  import S7._

  def mkTest(i: Int): (List[Any], List[Any], String) = { 
    if (i == 1) (List(), List(), "flatten an empty list")
    else if (i == 2) (List(3, 7, 5), List(3, 7, 5), "flatten a non-empty list 3")
    else if (i == 3) (List(List(4), 8), List(4, 8), "flatten a non-empty list 2")
    else (List(), List(), "flatten an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(flatten(in), out, msg)
    })
  }

  test("flatten an empty list (10pts)") {
    assertEquals(flatten(List()), List())
  }

  test("flatten a non-empty list 3 (10pts)") {
    assertEquals(flatten(List(3, 7, 5)), List(3, 7, 5))
  }

  test("flatten a non-empty list 2 (10pts)") {
    assertEquals(flatten(List(List(4), 8)), List(4, 8))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}