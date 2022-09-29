/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e3q4

object E3Q4SuiteIO:
  sealed abstract class Tests
  case class ToListWorks(args: Array[Int], exp: Array[Int], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      ToListWorks(Array(), Array(), 10),
      ToListWorks(Array(1), Array(1), 10),
      ToListWorks(Array(1, 2, 3, 4, 5), Array(1, 2, 3, 4, 5), 10),
      ToListWorks(Array(5, 4, 3, 2, 1), Array(1, 2, 3, 4, 5), 10),
      ToListWorks(Array(10, 20, 5, 3, 7, 25, 12, 1, 100), Array(1, 3, 5, 7, 10, 12, 20, 25, 100), 10)
    )
