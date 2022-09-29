/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e7q2

object E7Q2SuiteIO:
  
  import E7Q2._

  sealed abstract class Tests
  case class SquareWorksOnSimpleCase(arg: Int, exp: Int, points: Int) extends Tests
  case class CodesWorksOnSimpleCase(arg: String, exp: Boolean, points: Int) extends Tests
  case class PalCodesWorksOnSimpleCase(arg: String, exp: Boolean, points: Int) extends Tests
  case class AllCodesWorksForPalCodes(index: Int, exp: Boolean, points: Int) extends Tests
  case class AllCodesWorksForOtherCodes(index: Int, exp: Boolean, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      SquareWorksOnSimpleCase(1, 1, 10),
      SquareWorksOnSimpleCase(2, 4, 10),
      SquareWorksOnSimpleCase(3, 9, 10),
      SquareWorksOnSimpleCase(4, 16, 10),
      SquareWorksOnSimpleCase(5, 25, 10),
      SquareWorksOnSimpleCase(6, 36, 10),
      SquareWorksOnSimpleCase(9, 81, 10),
      SquareWorksOnSimpleCase(25, 625, 10),
      SquareWorksOnSimpleCase(100, 10000, 10),

      CodesWorksOnSimpleCase("", false, 10),
      CodesWorksOnSimpleCase("0", true, 10),
      CodesWorksOnSimpleCase("1", true, 10),
      CodesWorksOnSimpleCase("2", false, 10),
      CodesWorksOnSimpleCase("01", true, 10),
      CodesWorksOnSimpleCase("11", true, 10),
      CodesWorksOnSimpleCase("00", true, 10),
      CodesWorksOnSimpleCase("110", true, 10),
      CodesWorksOnSimpleCase("010", true, 10),
      CodesWorksOnSimpleCase("0011", true, 10),
      CodesWorksOnSimpleCase("0110", true, 10),
      CodesWorksOnSimpleCase("1100110011", true, 10),
      CodesWorksOnSimpleCase("1100111011", true, 10),

      PalCodesWorksOnSimpleCase("", false, 10),
      PalCodesWorksOnSimpleCase("01", false, 10),
      PalCodesWorksOnSimpleCase("11", true, 10),
      PalCodesWorksOnSimpleCase("00", true, 10),
      PalCodesWorksOnSimpleCase("110", false, 10),
      PalCodesWorksOnSimpleCase("010", true, 10),
      PalCodesWorksOnSimpleCase("0011", false, 10),
      PalCodesWorksOnSimpleCase("0110", true, 10),
      PalCodesWorksOnSimpleCase("1100110011", true, 10),
      PalCodesWorksOnSimpleCase("1100111011", false, 10),

      AllCodesWorksForOtherCodes(2, true, 10),
      AllCodesWorksForOtherCodes(10, true, 10),
      AllCodesWorksForPalCodes(1, true, 10),
      AllCodesWorksForPalCodes(19, true, 10)
    )