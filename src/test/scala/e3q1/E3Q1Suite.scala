/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e3q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q1Suite extends munit.FunSuite {

  import E3Q1._

  def mkTest(i: Int): ((Int, Int), Boolean, String) = { 
    if (i == 1) ((34, 34), true, "eq: test 1")
    else if (i == 2) ((57, 78), false, "eq: test 2")
    else if (i == 3) ((46, 32), false, "eq: test 3")
    else if (i == 4) ((12, 12), false, "less: test 1")
    else if (i == 5) ((456, 457), true, "less: test 2")
    else if (i == 6) ((67, 56), false, "less: test 3")
    else ((34, 34), true, "eq: test 1")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(intEq(in._1, in._2), out, msg)
    })

    (4 to 6).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(intLess(in._1, in._2), out, msg)
    })
  }

  test("eq: test 1 (10pts)") {
    assertEquals(intEq(34, 34), true)
  }

  test("eq: test 2 (10pts)") {
    assertEquals(intEq(57, 78), false)
  }

  test("eq: test 3 (10pts)") {
    assertEquals(intEq(46, 32), false)
  }

  test("less: test 1 (10pts)") {
    assertEquals(intLess(12, 12), false)
  }

  test("less: test 2 (10pts)") {
    assertEquals(intLess(456, 457), true)
  }

  test("less: test 3 (10pts)") {
    assertEquals(intLess(67, 56), false)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
