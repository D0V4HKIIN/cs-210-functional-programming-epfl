/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s21

object S21SuiteIO:

  import S21._

  sealed abstract class Tests
  case class NotWorks(a: Boolean, exp: Boolean, points: Int) extends Tests
  case class AndWorks(a: Boolean, b: Boolean, exp: Boolean, points: Int) extends Tests
  case class OrWorks(a: Boolean, b: Boolean, exp: Boolean, points: Int) extends Tests
  case class EquWorks(a: Boolean, b: Boolean, exp: Boolean, points: Int) extends Tests
  case class XorWorks(a: Boolean, b: Boolean, exp: Boolean, points: Int) extends Tests
  case class NandWorks(a: Boolean, b: Boolean, exp: Boolean, points: Int) extends Tests
  case class ImplWorks(a: Boolean, b: Boolean, exp: Boolean, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      NotWorks(true, false, 10),
      NotWorks(false, true, 10),

      AndWorks(true, true, true, 10),
      AndWorks(true, false, false, 10),
      AndWorks(false, true, false, 10),
      AndWorks(false, false, false, 10),

      OrWorks(true, true, true, 10),
      OrWorks(true, false, true, 10),
      OrWorks(false, true, true, 10),
      OrWorks(false, false, false, 10),

      EquWorks(true, true, true, 10),
      EquWorks(true, false, false, 10),
      EquWorks(false, true, false, 10),
      EquWorks(false, false, true, 10),

      XorWorks(true, true, false, 10),
      XorWorks(true, false, true, 10),
      XorWorks(false, true, true, 10),
      XorWorks(false, false, false, 10),

      NandWorks(true, true, false, 10),
      NandWorks(true, false, true, 10),
      NandWorks(false, true, true, 10),
      NandWorks(false, false, true, 10),

      ImplWorks(true, true, true, 10),
      ImplWorks(true, false, false, 10),
      ImplWorks(false, true, true, 10),
      ImplWorks(false, false, true, 10),
    )
