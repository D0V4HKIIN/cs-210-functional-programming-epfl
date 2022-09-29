/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e2q2

object E2Q2SuiteIO:
  
  sealed abstract class Tests
  case class SimpleCaseId(arg: Int, pts: Int) extends Tests
  case class SimpleCaseCompose(f: Int => Int, g: Int => Int, arg: Int, exp: Int, fname: String, pts: Int) extends Tests
  case class SimpleCaseRepeated(f: Int => Int, n: Int, arg: Int, exp: Int, fname: String, pts: Int) extends Tests
  case class ExceptionIsThrownRepeated(f: Int => Int, n: Int, pts: Int) extends Tests

  val allTests: Array[Tests] = 
    Array(
      SimpleCaseId(-42, 10),
      SimpleCaseId(1984, 10),
      SimpleCaseId(0, 10),
      SimpleCaseId(13, 10),

      SimpleCaseCompose(i => i + 2, i => i * 2, 12, 26, "multiplication and then addition", 10),
      SimpleCaseCompose(i => i/3, i => i - 20, 41, 7, "substraction and then division", 10),
      SimpleCaseCompose(i => i % 2, i => i % 7, 8, 1, "modulo 7 and then 2", 10),
      SimpleCaseCompose(i => i % 7, i => i % 2, 8, 0, "modulo 2 and then 7", 10),
      SimpleCaseCompose(i => i + 32, i => i / 2, 18, 41, "division and then addition", 10),

      SimpleCaseRepeated(i => 2 * i, 0, 1111, 1111, "multiplication by 2", 10),
      SimpleCaseRepeated(i => 3 * i, 1, 12, 36, "multiplication by 3", 10),
      SimpleCaseRepeated(i => i + 10, 1000, 101, 10101, "addition by 10", 10),
      SimpleCaseRepeated(i => i / 5, 3, 625, 5, "division by 5",10),
      SimpleCaseRepeated(i => i - 1, 101, 100, -1, "substraction by 1", 10),
      ExceptionIsThrownRepeated(i => i + 1, -3, 10)
    )