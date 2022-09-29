/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e3q1

object E3Q1SuiteIO:
  sealed abstract class Tests
  case class SimpleStrictInequalityWorks(x: Int, y: Int, exp: Boolean, points: Int) extends Tests
  case class SimpleEqualityWorks(x: Int, y: Int, exp: Boolean, points: Int) extends Tests

  lazy val allTests: Array[Tests] =
    Array(
      SimpleEqualityWorks(34, 34, true, 10),
      SimpleEqualityWorks(57, 78, false, 10),
      SimpleEqualityWorks(46, 32, false, 10),
      SimpleStrictInequalityWorks(12, 12, false, 10),
      SimpleStrictInequalityWorks(456, 457, true, 10),
      SimpleStrictInequalityWorks(67, 56, false, 10)
    )