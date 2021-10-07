/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S3Suite extends munit.FunSuite {

  import S3._

  def mkTest(i: Int): ((Int, List[Int]), Option[Int], String) = { 
    if (i == 1) ((0, List()), None, "first element of an empty list")
    else if (i == 2) ((1, List(1, 4, 2)), Some(4), "second element of a non-empty list 3")
    else ((0, List()), None, "first element of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(kth(in._1, in._2), out, msg)
    })
  }

  test("first element of an empty list (10pts)") {
    assertEquals(kth(0, List()), None)
  }

  test("second element of a non-empty list 3 (10pts)") {
    assertEquals(kth(1, List(1, 4, 2)), Some(4))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}