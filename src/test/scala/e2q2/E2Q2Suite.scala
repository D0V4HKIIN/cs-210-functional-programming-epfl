/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e2q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q2Suite extends munit.FunSuite {

  import E2Q2._

  def mkTest1(i: Int): (Int, Int, String) = { 
    if (i == 1) (-42, -42, "identity for a negative number")
    else if (i == 2) (1984, 1984, "identity for a positive number")
    else (-42, 42, "identity for a negative number")
  }

  def mkTest2(i: Int): ((Int => Int, Int => Int), Int, Int, String) = { 
    if (i == 1) (((i: Int) => i+2, (i: Int) => i*2), 12, 26, "composition of addition and multipliation")
    else if (i == 2) (((i: Int) => i/3, (i: Int) => i-20), 41, 7, "composition of division and substraction")
    else (((i: Int) => i+2, (i: Int) => i*2), 12, 26, "composition of addition and multipliation")
  }

  def mkTest3(i: Int): ((Int => Int, Int), Int, Int, String) = { 
    if (i == 1) (((i: Int) => i*2, 0), 1111, 1111, "repeat 0 time")
    else if (i == 2) (((i: Int) => i*3, 1), 12, 36, "repeat 1 time")
    else if (i == 3) (((i: Int) => i+10, 1000), 101, 10101, "repeat 1000 times")
    else (((i: Int) => i+2, 0), 1111, 1111, "repeat 0 time")
  }

  test("test everything (10pts)") {
    (1 to 2).foreach((i: Int) => {
      val (in, out, msg) = mkTest1(i)
      assertEquals(id(in), out, msg)
    })

    (1 to 2).foreach((i: Int) => {
      val (in, arg, out, msg) = mkTest2(i)
      assertEquals(compose(in._1, in._2)(arg), out, msg)
    })

    (1 to 3).foreach((i: Int) => {
      val (in, arg, out, msg) = mkTest3(i)
      assertEquals(repeated(in._1, in._2)(arg), out, msg)
    })
  }

  test("identity for a negative number (10pts)") {
    assertEquals(id(-42), -42)
  }

  test("identity for a positive number (10pts)") {
    assertEquals(id(1984), 1984)
  }

  test("composition of addition and multipliation (10pts)") {
    assertEquals(compose((i: Int) => i+2, (i: Int) => i*2)(12), 26)
  }

  test("composition of division and substraction (10pts)") {
    assertEquals(compose((i: Int) => i/3, (i: Int) => i-20)(41), 7)
  }

  test("repeat 0 time (10pts)") {
    assertEquals(repeated((i: Int) => i*2, 0)(1111), 1111)
  }

  test("repeat 1 time (10pts)") {
    assertEquals(repeated((i: Int) => i*3, 1)(12), 36)
  }

  test("repeat 1000 times (10pts)") {
    assertEquals(repeated((i: Int) => i+10, 1000)(101), 10101)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
