/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s13

object S13SuiteIO:
  sealed abstract class Tests
  case class GCDWorksOnSimpleCase(a: Int, b: Int, exp: Int, points: Int) extends Tests
  case class GCDThrowsException(a: Int, b: Int, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      GCDThrowsException(-1, 1, 10),
      GCDThrowsException(2, -1, 10),
      GCDThrowsException(-3, -3, 10),
      GCDWorksOnSimpleCase(0, 0, 0, 10),
      GCDWorksOnSimpleCase(7, 0, 7, 10),
      GCDWorksOnSimpleCase(0, 8, 8, 10),
      GCDWorksOnSimpleCase(1, 1, 1, 10),
      GCDWorksOnSimpleCase(2, 4, 2, 10),
      GCDWorksOnSimpleCase(16, 24, 8, 10),
      GCDWorksOnSimpleCase(63, 36, 9, 10),
      GCDWorksOnSimpleCase(1001, 99, 11, 10),
      GCDWorksOnSimpleCase(11111, 9999, 1, 10),
      GCDWorksOnSimpleCase(1597451, 987642049, 1, 10)
    )