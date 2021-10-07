/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s10

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S10Suite extends munit.FunSuite {

  import S10._

  def mkTest(i: Int): (List[(Int, Char)], List[Char], String) = { 
    if (i == 1) (List(), List(), "uncompress an empty list")
    else if (i == 2) (List((2, 'e'), (1, 'y')), List('e', 'e', 'y'), "uncompress a non-empty list 3")
    else if (i == 3) (List((1, 'e'), (1, 'z')), List('e', 'z'), "uncompress a non-empty list 2")
    else (List(), List(), "uncompress an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(uncompress(in), out, msg)
    })
  }

  test("uncompress an empty list (10pts)") {
    assertEquals(uncompress(List()), List())
  }

  test("uncompress a non-empty list 3 (10pts)") {
    assertEquals(uncompress(List((2, 'e'), (1, 'y'))), List('e', 'e', 'y'))
  }

  test("uncompress a non-empty list 3 (10pts)") {
    assertEquals(uncompress(List((1, 'e'), (1, 'z'))), List('e', 'z'))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}