/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e1q1

object E1Q1SuiteIO:

  sealed abstract class Tests
  case class ExceptionIsThrown(val arg: Int, val points: Int) extends Tests
  case class SimpleCaseWorks(val arg: Int, val exp: Int, val points: Int) extends Tests

  val allTests: Array[Tests] = 
    Array(
      ExceptionIsThrown(-1, 10), 
      SimpleCaseWorks(0, 1, 10), 
      SimpleCaseWorks(1, 1, 10), 
      SimpleCaseWorks(5, 120, 10),
      SimpleCaseWorks(8, 40320, 10),
      SimpleCaseWorks(10, 3628800, 10),
      SimpleCaseWorks(12, 479001600, 10)
    )
