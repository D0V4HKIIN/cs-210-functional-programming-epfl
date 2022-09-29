/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e4q1

object E4Q1SuiteIO:

  sealed abstract class Tests
  case class Check(line_number: Int, exp: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      Check(0, "<:", 10),
      Check(1, "<:", 10),
      Check(2, ":>", 10),
      Check(3, "<:", 10),
      Check(4, "X", 10),
      Check(5, ":>", 10),
      Check(6, ":>", 10),
      Check(7, ":>", 10),
      Check(8, ":>", 10),
      Check(9, "X", 10),
      Check(10, "X", 10)
    )