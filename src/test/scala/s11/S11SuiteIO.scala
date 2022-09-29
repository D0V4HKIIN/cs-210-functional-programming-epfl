/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s11

object S11SuiteIO:
  sealed abstract class Tests
  case class DropWorksOnSimpleCase(ls: Array[Int], n: Int, exp: Array[Int], points: Int) extends Tests
  case class DropThrowsException(ls: Array[Int], n: Int, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      DropThrowsException(Array[Int](), -1, 10),
      DropWorksOnSimpleCase(Array[Int](), 5, Array[Int](), 10),
      DropWorksOnSimpleCase(Array(4, 8), 2, Array(4), 10),
      DropWorksOnSimpleCase(Array(4, 8), 3, Array(4, 8), 10),
      DropWorksOnSimpleCase(Array(4, 8, 7), 3, Array(4, 8), 10),
      DropWorksOnSimpleCase(Array(4, 8, 3), 0, Array(4, 8, 3), 10),
      DropWorksOnSimpleCase(Array(4, 8, 7, 5, 4, 3), 3, Array(4, 8,5, 4), 10),
      DropWorksOnSimpleCase(Array(3, 7, 5), 2, Array(3, 5), 10),
      DropWorksOnSimpleCase(Array(3, 1, 4, 2), 2, Array(3, 4), 10),
      DropWorksOnSimpleCase(Array(3, 7, 5, 1, 7, 6, 4, 8, 2, 1, 6, 5, 5, 4, 8, 9, 6), 4, Array(3, 7, 5, 7, 6, 4, 2, 1, 6, 5, 4, 8, 6), 10),
      DropWorksOnSimpleCase(Array(3, 7, 5, 1, 7, 6, 4, 8, 2, 1, 6, 5, 5, 4, 8, 9, 6), 1, Array[Int](), 10),
    )

