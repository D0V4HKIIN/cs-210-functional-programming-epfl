/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e1q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q2Suite extends munit.FunSuite {

  import E1Q2._

  def mkTest(i: Int): (List[Int], Int, String) = { 
    if (i == 1) (List(), 0, "sum of an empty list")
    else if (i == 2) (List(1, 2, 3), 6, "sum of a non-empty list 3")
    else if (i == 3) (List(1998, 2018), 4016, "sum of a non-empty list 2")
    else (List(), 0, "sum of an empty list")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(sumList(in), out, msg)
    })
  }

  test("sum of an empty list (10pts)") {
    assertEquals(sumList(List()), 0)
  }

  test("sum of a non-empty list 3 (10pts)") {
    assertEquals(sumList(List(1, 2, 3)), 6)
  }

  test("sum of a non-empty list 2 (10pts)") {
    assertEquals(sumList(List(1998, 2018)), 4016)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
