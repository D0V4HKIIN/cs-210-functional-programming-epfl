/* Copyright 2022 EPFL, Lausanne */

package e4q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E4Q2Suite extends munit.FunSuite:

  import E4Q2._
  import E4Q2SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case DerivWorksOnCase(_, _, _, descr, pts) =>
          s"Derivative of $descr ($pts pts)"
    
    def execute: Unit =
      t match
        case d: DerivWorksOnCase =>
          assertEquals(deriv(d.expr, d.v), d.res)
      
  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
