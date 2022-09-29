/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s9

object S9SuiteIO:
  sealed abstract class Tests 
  case class RunLengthWorksOnSimpleCase(arg: Array[Char], exp: Array[(Int, Char)], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      RunLengthWorksOnSimpleCase(Array[Char](), Array[(Int, Char)](), 10),
      RunLengthWorksOnSimpleCase(Array('a'), Array((1, 'a')), 10),
      RunLengthWorksOnSimpleCase(Array('e', 'z'), Array((1, 'e'), (1, 'z')), 10),
      RunLengthWorksOnSimpleCase(Array('e', 'e', 'y'), Array((2, 'e'), (1, 'y')), 10),
      RunLengthWorksOnSimpleCase(Array('e', 'z', 'z', 'z'), Array((1, 'e'), (3, 'z')), 10),
      RunLengthWorksOnSimpleCase(Array('a', 'a', 'a', 'a', 'a'), Array((5, 'a')), 10),
      RunLengthWorksOnSimpleCase(
        Array('s', 'i', 'n', 'g', 'l', 'e'), 
        Array((1, 's'), (1, 'i'), (1, 'n'), (1, 'g'), (1, 'l'), (1, 'e')), 
        10
      ),
      RunLengthWorksOnSimpleCase(
        Array('l', 'l', 'l', 'l', 'a', 'r', 'r', 'r', 'g', 'g', 'g', 'g', 'g', 'e', 'e'),
        Array((4, 'l'), (1, 'a'), (3, 'r'), (5, 'g'), (2, 'e')), 
        10
      ),
      RunLengthWorksOnSimpleCase(
        Array('l', 'l', 'l', 'l', 'a', 'l', 'r', 'r', 'r', 'g', 'g', 'g', 'g', 'g', 'e', 'e'),
        Array((4, 'l'), (1, 'a'), (1, 'l'), (3, 'r'), (5, 'g'), (2, 'e')), 
        10
      )
    )