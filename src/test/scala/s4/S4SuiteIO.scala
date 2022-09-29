/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s4

object S4SuiteIO:
  sealed abstract class Tests
  case class LengthWorksOnSimpleCase(arg: Array[Int], exp: Int, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      LengthWorksOnSimpleCase(Array[Int](), 0, 10),
      LengthWorksOnSimpleCase(Array(4), 1, 10),
      LengthWorksOnSimpleCase(Array(0, 0), 2, 10),
      LengthWorksOnSimpleCase(Array(3, 7, 5), 3, 10),
      LengthWorksOnSimpleCase(Array(3, 5, 6, 7, 8, 9, 7, 7, 8, 9, 7, 3), 12, 10),
      LengthWorksOnSimpleCase(Array(3, 7, 5, 1, 7, 6, 4, 8, 2, 1, 6, 5, 5, 4, 8, 9, 6), 17, 10)
    )