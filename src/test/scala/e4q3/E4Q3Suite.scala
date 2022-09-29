/* Copyright 2022 EPFL, Lausanne */

package e4q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E4Q3Suite extends munit.FunSuite:

  import E4Q3._
  import E4Q3SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case SimplifyWorksOnCase(_, _, descr, pts) =>
          s"Simplify $descr ($pts pts)"
      
    def execute: Unit =
      t match
        case s: SimplifyWorksOnCase =>
          assertEquals(simplify(s.arg), s.res)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")

