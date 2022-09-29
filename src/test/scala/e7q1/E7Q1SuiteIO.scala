/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e7q1

object E7Q1SuiteIO:

  sealed abstract class Tests
  case class NextLineWorksOnSimpleCase(arg: Array[Int], exp: Array[Int], descr: String, points: Int) extends Tests
  case class FunSeqWorksOnSimpleCase(index: Int, exp: Array[Int], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      NextLineWorksOnSimpleCase(Array[Int](), Array[Int](), "an empty list", 10),
      NextLineWorksOnSimpleCase(Array(1), Array(1, 1), "the first element", 10),
      NextLineWorksOnSimpleCase(Array(3, 1, 2, 2, 1, 1), Array(1, 3, 1, 1, 2, 2, 2, 1), "the example", 10),
      NextLineWorksOnSimpleCase(Array(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1), Array(13, 1), "a list full of the same element", 10),
      NextLineWorksOnSimpleCase(
        Array(3, 1, 1, 3, 1, 1, 2, 2, 2, 1, 2, 3, 2, 1, 1, 2, 1, 
              1, 1, 3, 1, 2, 2, 1, 1, 3, 1, 2, 1, 1, 3, 2, 1, 1), 
        Array(1, 3, 2, 1, 1, 3, 2, 1, 3, 2, 1, 1, 1, 2, 1, 3, 1, 2, 2, 1, 1, 2, 3, 
              1, 1, 3, 1, 1, 2, 2, 2, 1, 1, 3, 1, 1, 1, 2, 2, 1, 1, 3, 1, 2, 2, 1),
        "the 12th line",
        10
      ),

      FunSeqWorksOnSimpleCase(0, Array(1), 10),
      FunSeqWorksOnSimpleCase(1, Array(1, 1), 10),
      FunSeqWorksOnSimpleCase(6, Array(1, 3, 1, 1, 2, 2, 2, 1), 10),
      FunSeqWorksOnSimpleCase(12,
       Array(1, 3, 2, 1, 1, 3, 2, 1, 3, 2, 1, 1, 1, 2, 1, 3, 1, 2, 2, 1, 1, 2, 3, 1, 1, 3, 
            1, 1, 2, 2, 2, 1, 1, 3, 1, 1, 1, 2, 2, 1, 1, 3, 1, 2, 2, 1)
       , 10
      )
    )
