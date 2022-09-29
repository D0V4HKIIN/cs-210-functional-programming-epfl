/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s14

object S14SuiteIO:
  sealed abstract class Tests
  case class PrimeFactWorksOnSimpleCase(arg: Int, exp: Array[(Int, Int)], points: Int) extends Tests
  case class PrimeFactThrowsException(arg: Int, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      PrimeFactThrowsException(-13, 10),
      PrimeFactThrowsException(-1, 10),
      PrimeFactThrowsException(0, 10),
      PrimeFactThrowsException(1, 10),
      PrimeFactWorksOnSimpleCase(2, Array(2 -> 1), 10),
      PrimeFactWorksOnSimpleCase(3, Array(3 -> 1), 10),
      PrimeFactWorksOnSimpleCase(4, Array(2 -> 2), 10),
      PrimeFactWorksOnSimpleCase(15, Array(3 -> 1, 5 -> 1), 10),
      PrimeFactWorksOnSimpleCase(18, Array(2 -> 1, 3 -> 2), 10),
      PrimeFactWorksOnSimpleCase(19, Array(19 -> 1), 10),
      PrimeFactWorksOnSimpleCase(44, Array(2 -> 2, 11 -> 1), 10),
      PrimeFactWorksOnSimpleCase(46, Array(2 -> 1, 23 -> 1), 10),
      PrimeFactWorksOnSimpleCase(99, Array(3 -> 2, 11 -> 1), 10),
      PrimeFactWorksOnSimpleCase(1000, Array(2 -> 3, 5 -> 3), 10),
      PrimeFactWorksOnSimpleCase(1865470, Array(2 -> 1, 5 -> 1, 101 -> 1, 1847 -> 1), 10),
      PrimeFactWorksOnSimpleCase(1865471, Array(1865471 -> 1), 10)
    )