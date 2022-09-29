/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s2

object S2SuiteIO:

  sealed abstract class Tests
  case class LastOnSimpleCase(arg: Array[Int], exp: Option[Int], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      LastOnSimpleCase(Array[Int](), None, 10),
      LastOnSimpleCase(Array(2), Some(2), 10),
      LastOnSimpleCase(Array(4, 5), Some(5), 10),
      LastOnSimpleCase(Array(5, 9, 7), Some(7), 10),
      LastOnSimpleCase(Array(3, 2, 2, 5), Some(5), 10),
      LastOnSimpleCase(Array(4, 3, 4, 4, 2, 5, 3), Some(3), 10)
    )