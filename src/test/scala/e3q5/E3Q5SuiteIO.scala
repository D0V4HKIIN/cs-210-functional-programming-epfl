/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e3q5

object E3Q5SuiteIO:
  sealed abstract class Tests
  case class SortedListWorks(args: Array[Int], exp: Array[Int], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SortedListWorks(Array(), Array(), 10),
      SortedListWorks(Array(1), Array(1), 10),
      SortedListWorks(Array(2, 5, 4, 6, 7, 1, 3, 9, 8), Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 10),
      SortedListWorks(Array(20, -55, -4, 16, 87, -2, 111, 7843, -1919, 0), Array(-1919, -55, -4, -2, 0, 16, 20, 87, 111, 7843), 10)
    )
