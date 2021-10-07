/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e1q4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q4Suite extends munit.FunSuite {

  import E1Q4._

  def mkTest(i: Int): (Int, Int, String) = { 
    if (i == 1) (0, 1, "n = 0")
    else if (i == 2) (1, 1, "n = 1")
    else if (i == 3) (2, 2, "n = 2")
    else if (i == 4) (10, 89, "n = 10")
    else if (i == 5) (22, 28657, "n = 22")
    else if (i == 6) (42, 433494437, "n = 42")
    else (0, 1, "n = 0")
  }

  test("test everything (10pts)") {
    (1 to 6).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(fibonacci(in), out, msg)
    })
  }

  test("n = 0 (10pts)") {
    assertEquals(fibonacci(0), 1)
  }

  test("n = 1 (10pts)") {
    assertEquals(fibonacci(1), 1)
  }

  test("n = 2 (10pts)") {
    assertEquals(fibonacci(2), 2)
  }

  test("n = 10 (10pts)") {
    assertEquals(fibonacci(10), 89)
  }

  test("n = 22 (10pts)") {
    assertEquals(fibonacci(22), 28657)
  }

  test("n = 42 (10pts)") {
    assertEquals(fibonacci(42), 433494437)
  }

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
