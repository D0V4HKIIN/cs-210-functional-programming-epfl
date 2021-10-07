/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e4q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E4Q1Suite extends munit.FunSuite {

  import E4Q1._


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
