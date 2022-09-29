/* Copyright 2022 EPFL, Lausanne */

package e4q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E4Q1Suite extends munit.FunSuite:

  import E4Q1._
  import E4Q1SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case Check(n, exp, pts) =>
          s"Check of line #$n ($pts pts)"
      
    def execute: Unit =
      t match 
        case c: Check =>
          assertEquals(lines(c.line_number), c.exp)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
