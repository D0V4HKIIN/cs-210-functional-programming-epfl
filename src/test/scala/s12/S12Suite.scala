/* Copyright 2022 EPFL, Lausanne */

package s12

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S12Suite extends munit.FunSuite:

  import S12._
  import S12SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case IsPrimeWorksOnSimpleCase(arg, exp, pts) =>
          s"$arg is prime ($pts pts)"
        case IsPrimeThrowsException(_, pts) =>
          s"Exception is thrown for negative numbers ($pts pts)"

    def msg: String =
      t match
        case IsPrimeWorksOnSimpleCase(arg, exp, pts) =>
          s"Wrong result for primality check of $arg"
        case IsPrimeThrowsException(_, _) =>
          s"An Exception should have been thrown for negative numbers"

    def execute: Unit =
      t match
        case d: IsPrimeWorksOnSimpleCase =>
          assertEquals(isPrime(d.arg), d.exp, d.msg)
        case e: IsPrimeThrowsException =>
          intercept[IllegalArgumentException] {
            isPrime(e.arg)
          }

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
