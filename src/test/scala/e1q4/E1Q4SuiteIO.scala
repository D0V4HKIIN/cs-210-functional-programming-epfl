/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e1q4

object E1Q4SuiteIO:
  
  sealed abstract class Tests
  case class ExceptionIsThrown(arg: Int, points: Int) extends Tests
  case class SimpleCaseWorks(arg: Int, exp: Int, points: Int) extends Tests 

  val allTests: Array[Tests] = 
    Array(
      ExceptionIsThrown(-1, 10),
      SimpleCaseWorks(16, 987, 10),
      SimpleCaseWorks(0, 0, 10),
      SimpleCaseWorks(1, 1, 10),
      SimpleCaseWorks(2, 1,  10),
      SimpleCaseWorks(3, 2,10),
      SimpleCaseWorks(5, 5, 10),
      SimpleCaseWorks(10, 55, 10),
      SimpleCaseWorks(13, 233, 10)
    )