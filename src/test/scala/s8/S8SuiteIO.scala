/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s8

object S8SuiteIO:
  
  sealed abstract class Tests
  case class DuplicateNWorksOnSimpleCase(ls : Array[Char], n: Int, exp: Array[Char], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      DuplicateNWorksOnSimpleCase(Array('v', 'o', 'i', 'd'), 0, Array[Char](), 10),
      DuplicateNWorksOnSimpleCase(Array('a'), 1, Array('a'), 10),
      DuplicateNWorksOnSimpleCase(Array[Char](), 2, Array[Char](), 10),
      DuplicateNWorksOnSimpleCase(Array('a'), 3, Array('a', 'a', 'a'), 10),
      DuplicateNWorksOnSimpleCase(Array('e', 'a', 'y'), 2, Array('e', 'e', 'a', 'a', 'y', 'y'), 10),
      DuplicateNWorksOnSimpleCase(Array('e', 'z'), 3, Array('e', 'e', 'e', 'z', 'z', 'z'), 10),
      DuplicateNWorksOnSimpleCase(Array('e', 'e', 'z'), 3, Array('e', 'e', 'e', 'e', 'e', 'e', 'z', 'z', 'z'), 10),
      DuplicateNWorksOnSimpleCase(Array('s', 'i', 'n', 'g', 'l', 'e'), 1, Array('s', 'i', 'n', 'g', 'l', 'e'), 10)
    )