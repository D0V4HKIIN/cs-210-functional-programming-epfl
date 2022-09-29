/* Copyright 2022 EPFL, Lausanne */

package s13

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S13Suite extends munit.FunSuite:

  import S13._
  import S13SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case GCDWorksOnSimpleCase(a, b, _, pts) =>
          s"GCD between $a and $b ($pts pts)"
        case GCDThrowsException(a, b, pts) =>
          s"Exception is thrown for wrong arguments ($a, $b) ($pts pts)"

    def msg: String =
      t match
        case GCDWorksOnSimpleCase(a, b, _, _) =>
          s"Wrong result of GCD between $a and $b"
        case GCDThrowsException(a, b, _) =>
          s"An exception should be thrown on wrong arguments : ($a, $b)"

    def execute: Unit =
      t match
        case s: GCDWorksOnSimpleCase =>
          assertEquals(gcd(s.a, s.b), s.exp, s.msg)
        case e: GCDThrowsException =>
          intercept[IllegalArgumentException] {
            gcd(e.a, e.b)
          }

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
