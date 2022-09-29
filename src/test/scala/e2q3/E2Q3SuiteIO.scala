/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e2q3

object E2Q3SuiteIO:
  sealed abstract class Tests
  case class SimpleCaseWorks(f_uncur: (Double, Int) => Boolean, f_cur: Double => Int => Boolean, args: (Double, Int), exp: Boolean, fname: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SimpleCaseWorks((d: Double, i: Int) => true, (d: Double) => (i: Int) => true, (1.0, 57), true, "a constant function", 10),
      SimpleCaseWorks((d: Double, i: Int) => d > i ,(d: Double) => (i: Int) => d > i, (17.5, 17), true, "a comparison function (1)", 10),
      SimpleCaseWorks((d: Double, i: Int) => d > i ,(d: Double) => (i: Int) => d > i, (17.5, 18),  false, "a comparison function (2)", 10),
      SimpleCaseWorks((d: Double, i: Int) => d == 2.0 && i == 1, (d: Double) => (i: Int) => d == 2.0 && i == 1, (2.0, 1), true, "an equality check on both arument", 10),
      SimpleCaseWorks((d: Double, i: Int) => d > 0.0 && d < 1.0, (d: Double) => (i: Int) => d > 0.0 && d < 1.0, (0.5, 1), true, "an interval check function on the Double parameter", 10)
    )