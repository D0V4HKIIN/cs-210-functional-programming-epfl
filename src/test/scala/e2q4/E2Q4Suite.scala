/* Copyright 2022 EPFL, Lausanne */

package e2q4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q4Suite extends munit.FunSuite:

  import E2Q4._
  import E2Q4SuiteIO._

  extension (t: Tests)
    def execute: Unit =
      t match
        case s: SimpleCaseWorks =>
          assertEquals(fixedPoint(s.f)(s.arg), s.exp, s.msg)      

    def msg: String =
      t match
        case SimpleCaseWorks(_, _, _, fname, _) =>
          s"Wrong value for $fname"  

    def title: String =
      t match
        case SimpleCaseWorks(_, _, _, fname, pts) =>
          s"Fixed point of $fname ($pts pts)"
        

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
