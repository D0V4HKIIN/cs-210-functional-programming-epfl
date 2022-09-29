/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s7

object S7SuiteIO:

  sealed abstract class Tests
  case class FlattenWorksOnIntList(arg: List[Any], exp: List[Int], descr: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      FlattenWorksOnIntList(List[Int](), List[Int](), "an empty list", 10),
      FlattenWorksOnIntList(List(List(), List()), List(), "a list nested with some empty list", 10),
      FlattenWorksOnIntList(List(3, 7, 5), List(3, 7, 5), "a single list",10),
      FlattenWorksOnIntList(List(List(4), 8), List(4, 8), "a nested list of deep : 2",10),
      FlattenWorksOnIntList(List(1, List(List(5), 6)), List(1, 5, 6), "a nested list of deep : 2 (2)", 10),
      FlattenWorksOnIntList(List(List(1, 2, 3), 4, 5, List(6, List(7, 8, List(9))), List(10)), List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), "a 4 nested list of deep : 3", 10),
      FlattenWorksOnIntList(List(List(List(List(List(42))))), List(42), "a nested list of deep : 4", 10),
      FlattenWorksOnIntList(List(1, 2, List(List(List(List(4, 5), List(), List(6)), 3))), List(1, 2, 4, 5, 6, 3), "a nested list of deep : 5", 10)
    )