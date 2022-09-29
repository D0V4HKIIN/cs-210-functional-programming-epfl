/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s3

object S3SuiteIO:
  sealed abstract class Tests
  case class KthWorksOnSimpleCase(k: Int, ls: Array[Int], exp: Option[Int], points: Int) extends Tests
  case class KthThrowsException(k: Int, ls: Array[Int], points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      KthWorksOnSimpleCase(2, Array(4, 5), None, 10),
      KthWorksOnSimpleCase(3, Array(2, 5, 8, 1), Some(1), 10),
      KthWorksOnSimpleCase(0, Array(), None, 10),
      KthWorksOnSimpleCase(1, Array(1, 4, 2), Some(4), 10),
      KthThrowsException(-3, Array(), 10),
      KthThrowsException(-6, Array(), 10),
    )