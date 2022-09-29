/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e1q2

object E1Q2SuiteIO:

  sealed abstract class Tests
  
  case class SimpleCaseWorks(val arg: Array[Int], val exp: Int, val points: Int) extends Tests

  val allTest: Array[Tests] = 
    Array(
      SimpleCaseWorks(Array(), 0, 10),
      SimpleCaseWorks(Array(2001), 2001, 10),
      SimpleCaseWorks(Array(1998, 2018), 4016, 10),
      SimpleCaseWorks(Array(1, 2, 3), 6, 10),
      SimpleCaseWorks(Array(1, 2, 3, 4, 5, -1, -5, -4, -3, -2), 0, 10),
      SimpleCaseWorks(Array(4, 3, 4, 4, 5, -4, 3, 4, 5, 5, 1, 0, 13, -10), 37, 10),
      SimpleCaseWorks(Array(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536), 131071, 10)
    )