/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e6q1

object E6Q1SuiteIO:


  sealed abstract class Tests
  case class TrianglesWorksOnSimpleGraph(arg: Array[(Int, Int)], exp: Array[Array[(Int, Int, Int)]], descr: String, points: Int) extends Tests
  case class TrianglesTranslatedWorksOnSimpleGraph(arg: Array[(Int, Int)], exp: Array[Array[(Int, Int, Int)]], descr: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      TrianglesWorksOnSimpleGraph(Array[(Int, Int)](), Array[Array[(Int, Int, Int)]](), "3-cycles of an empty list", 10),
      TrianglesWorksOnSimpleGraph(Array((1, 2), (2, 3), (3, 1)), Array(Array((1, 2, 3), (2, 3, 1), (3, 1, 2))), "3-cycles of the example", 10),
      TrianglesWorksOnSimpleGraph(Array((1, 7), (4, 1), (7, 4), (25, 10), (32, 25), (10, 32)), Array(Array((1, 7, 4), (7, 4, 1), (4, 1, 7)), Array((25, 10, 32), (10, 32, 25), (32, 25, 10))), "3-cycles of a graph", 10),
      TrianglesTranslatedWorksOnSimpleGraph(Array[(Int, Int)](), Array[Array[(Int, Int, Int)]](), "3-cycles of an empty list", 10),
      TrianglesTranslatedWorksOnSimpleGraph(Array((1, 2), (2, 3), (3, 1)), Array(Array((1, 2, 3), (2, 3, 1), (3, 1, 2))), "3-cycles of the example", 10),
      TrianglesTranslatedWorksOnSimpleGraph(Array((1, 7), (4, 1), (7, 4), (25, 10), (32, 25), (10, 32)), Array(Array((1, 7, 4), (7, 4, 1), (4, 1, 7)), Array((25, 10, 32), (10, 32, 25), (32, 25, 10))), "3-cycles of a graph", 10)
    )