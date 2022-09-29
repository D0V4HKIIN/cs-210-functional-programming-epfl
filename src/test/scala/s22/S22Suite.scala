/* Copyright 2022 EPFL, Lausanne */

package s22

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S22Suite extends munit.FunSuite:

  import S22._
  import S22SuiteIO._

  extension (t: Tests)
    def title: String =
      t match 
        case GrayWorks(n, exp, pts) =>
          s"An $n-bit Gray code ($pts pts)" 
    def msg: String =
      t match 
        case GrayWorks(n, exp, pts) =>
          s"Wrong result for an $n-bit gray code" 
    def execute: Unit =
      t match 
        case g: GrayWorks => 
          assertEquals(gray(g.n), g.exp.toList, g.msg)
  
    
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")