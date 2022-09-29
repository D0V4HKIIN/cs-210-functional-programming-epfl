/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s6

object S6SuiteIO:
  sealed abstract class Tests
  case class SortedWorksOnSimpleCase(arg: Array[Int], exp: Boolean, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SortedWorksOnSimpleCase(Array[Int](), true, 10),
      SortedWorksOnSimpleCase(Array(42), true, 10),
      SortedWorksOnSimpleCase(Array(4, 8), true, 10),
      SortedWorksOnSimpleCase(Array(3, 7, 5), false, 10),
      SortedWorksOnSimpleCase(Array(2, 4, -2, 8), false, 10),
      SortedWorksOnSimpleCase(Array(-2, -3, -4, -5, -6), false, 10),
      SortedWorksOnSimpleCase(Array(-6, -5, -4, -3, -2, 0), true, 10),
      SortedWorksOnSimpleCase(Array(0, 0, 0, 0, 0, 0, 0), true, 10),
      SortedWorksOnSimpleCase(Array(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144), true, 10),
      SortedWorksOnSimpleCase(Array(3, 7, 5, 1, 7, 6, 4, 8, 2, 1, 6, 5, 5, 4, 8, 9, 6), false, 10)
    )