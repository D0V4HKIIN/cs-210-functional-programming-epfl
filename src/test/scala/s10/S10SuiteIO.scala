/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s10

object S10SuiteIO:

  sealed abstract class Tests
  case class UncompressWorksOnSimpleCase(arg: Array[(Int, Char)], exp: Array[Char], points: Int) extends Tests
  case class UncompressedThrowsException(arg: Array[(Int, Char)], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      UncompressedThrowsException(Array((-1, 'a')), 10),
      UncompressedThrowsException(Array((1, 'a'), (-10, 'd')), 10),
      UncompressWorksOnSimpleCase(Array[(Int, Char)](), Array[Char](), 10),
      UncompressWorksOnSimpleCase(Array((1, 'a')), Array('a'), 10),
      UncompressWorksOnSimpleCase(Array((1, 'e'), (1, 'z')), Array('e', 'z'), 10),
      UncompressWorksOnSimpleCase(Array((2, 'e'), (1, 'y')), Array('e', 'e', 'y'), 10),
      UncompressWorksOnSimpleCase(Array((1, 'e'), (3, 'z')), Array('e', 'z', 'z', 'z'), 10),
      UncompressWorksOnSimpleCase(Array((5, 'a')), Array('a', 'a', 'a', 'a', 'a'), 10),
      UncompressWorksOnSimpleCase(
        Array((1, 's'), (1, 'i'), (1, 'n'), (1, 'g'), (1, 'l'), (1, 'e')), 
        Array('s', 'i', 'n', 'g', 'l', 'e'), 
        10
      ),
      UncompressWorksOnSimpleCase(
        Array((4, 'l'), (1, 'a'), (3, 'r'), (5, 'g'), (2, 'e')), 
        Array('l', 'l', 'l', 'l', 'a', 'r', 'r', 'r', 'g', 'g', 'g', 'g', 'g', 'e', 'e'), 
        10
      ),
      UncompressWorksOnSimpleCase(
        Array((4, 'l'), (1, 'a'), (1, 'l'), (3, 'r'), (5, 'g'), (2, 'e')), 
        Array('l', 'l', 'l', 'l', 'a', 'l', 'r', 'r', 'r', 'g', 'g', 'g', 'g', 'g', 'e', 'e'), 
        10
      )
    )