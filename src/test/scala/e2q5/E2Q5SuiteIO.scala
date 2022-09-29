/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e2q5

object E2Q5SuiteIO:
  sealed abstract class Tests
  case class SimpleCaseSumF(f: Int => Int, a: Int, b: Int, exp: Int, fname: String, points: Int) extends Tests
  case class ExceptionOnSumF(f: Int => Int, a: Int, b: Int, points: Int) extends Tests
  case class SimpleCaseQuadratic(c: Int, arg: Int, exp: Int, points: Int) extends Tests
  case class SimpleCaseQuad3Integrate(a: Int, b: Int, exp: Int, points: Int) extends Tests
  case class ExceptionOnQuad3Integrate(a: Int, b: Int, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SimpleCaseSumF(x => x, 1, 1, 1, "identity", 10),
      SimpleCaseSumF(x => x, 1, 10, 55, "identity (2)", 10),
      SimpleCaseSumF(x => x*x, 1, 10, 385, "squares", 10),
      SimpleCaseSumF(x => x % 2, 0, 22, 11, "modulo 2", 10),
      SimpleCaseSumF(x => 4 * x, -3, -1, -24, "factor 4 scale", 10),
      ExceptionOnSumF(x => x, 1, 0, 10),
      
      SimpleCaseQuadratic(0, 0, 0, 10),
      SimpleCaseQuadratic(1, 1, 0, 10),
      SimpleCaseQuadratic(3, 1, 4, 10),
      SimpleCaseQuadratic(-3, 2, 25, 10),
      SimpleCaseQuadratic(5, 10, 25, 10),
      SimpleCaseQuadratic(10, 10, 0, 10),

      SimpleCaseQuad3Integrate(4, 5, 1, 10),
      SimpleCaseQuad3Integrate(5, 7, 13, 10),
      SimpleCaseQuad3Integrate(-5, -2, 149, 10),
      SimpleCaseQuad3Integrate(-2, 2, 54, 10),
      SimpleCaseQuad3Integrate(4, 104, 338350, 10),
      ExceptionOnQuad3Integrate(1, 1, 10),
      ExceptionOnQuad3Integrate(1, 0, 10)
    )
