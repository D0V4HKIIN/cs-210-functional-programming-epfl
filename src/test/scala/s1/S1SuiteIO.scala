/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s1

object S1SuiteIO:
  sealed abstract class Tests
  case class TailsWorksOnSimpleCase(arg: Array[Int], exp: Array[Array[Int]], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      TailsWorksOnSimpleCase(Array[Int](), Array(Array[Int]()), 10),
      TailsWorksOnSimpleCase(Array(9), Array(Array(9), Array[Int]()), 10),
      TailsWorksOnSimpleCase(Array(2, 7), Array(Array(2, 7), Array(7),Array[Int]()), 10),
      TailsWorksOnSimpleCase(Array(3, 7, 2), Array(Array(3, 7, 2), Array(7, 2), Array(2), Array[Int]()), 10),
      TailsWorksOnSimpleCase(Array(14, 13, 23, 43, 12), Array(Array(14, 13, 23, 43, 12), Array(13, 23, 43, 12), Array(23, 43, 12), Array(43, 12), Array(12), Array[Int]()), 10)
    )