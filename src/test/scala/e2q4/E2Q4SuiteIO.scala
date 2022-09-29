/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e2q4

object E2Q4SuiteIO:
  sealed abstract class Tests
  case class SimpleCaseWorks(f: Int => Int, arg: Int, exp: Int, fname: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SimpleCaseWorks(i => i, 123456, 123456, "an identity function", 10),
      SimpleCaseWorks(i => i/2, 4, 0, "a linear function", 10),
      SimpleCaseWorks(i => if (i % 10 == 0) i else i + 1, 35, 40, "a modulo function", 10),
      SimpleCaseWorks(i => i/2 + 5, 20, 10, "an affine function", 10),
      SimpleCaseWorks(i => 3 / 4 * i + 1, 0, 1, "an affine function (2)", 10),
      SimpleCaseWorks(i => i * i, -1, 1, "square function", 10),
      SimpleCaseWorks(i => if i == 0 then 1 else 7 - 6 / i, 2, 6, "a dividing function", 10),
      SimpleCaseWorks(i => 1 + 1/2 * i * i - 1 / 2 * i, 3/2, 1, "polynomial function", 10)
    )