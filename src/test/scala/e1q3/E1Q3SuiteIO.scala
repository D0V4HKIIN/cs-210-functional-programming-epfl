/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e1q3

object E1Q3SuiteIO:

  sealed abstract class Tests
  case class ExceptionIsThrown(val arg: (Int, Int), val points: Int) extends Tests
  case class SimpleCaseWorks(val arg: (Int, Int), val exp: Int, val points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      ExceptionIsThrown((0, -1), 10),
      SimpleCaseWorks((42, 0), 1, 10),
      SimpleCaseWorks((101, 1), 101, 10),
      SimpleCaseWorks((64, 2), 4096, 10),
      SimpleCaseWorks((666, 3), 295408296, 10),
      SimpleCaseWorks((-64, 2), 4096, 10),
      SimpleCaseWorks((-666, 3), -295408296, 10),
      SimpleCaseWorks((7, 10), 282475249, 10),
      SimpleCaseWorks((3, 13), 1594323, 10),
      SimpleCaseWorks((0, 0), 1, 10)
    )
