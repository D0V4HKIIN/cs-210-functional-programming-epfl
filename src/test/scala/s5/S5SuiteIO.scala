/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s5

object S5SuiteIO:
  sealed abstract class Tests
  case class EvenSlotsWorksOnSimpleCase(arg: Array[Int], exp: Array[Int], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      EvenSlotsWorksOnSimpleCase(Array[Int](), Array[Int](), 10),
      EvenSlotsWorksOnSimpleCase(Array(4), Array(4), 10),
      EvenSlotsWorksOnSimpleCase(Array(4, 8), Array(4), 10),
      EvenSlotsWorksOnSimpleCase(Array(3, 7, 5), Array(3, 5), 10),
      EvenSlotsWorksOnSimpleCase(Array(3, 7, 5, 1, 7, 6, 4, 8, 2, 1, 6, 5, 5, 4, 8, 9, 6), Array(3, 5, 7, 4, 2, 6, 5, 8, 6), 10)
    )