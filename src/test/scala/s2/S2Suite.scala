/* Copyright 2022 EPFL, Lausanne */

package s2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S2Suite extends munit.FunSuite:

  import S2._
  import S2SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case LastOnSimpleCase(arg, _, pts) =>
          s"Last works on an array of size ${arg.length} ($pts pts)"

    def msg: String =
      t match
        case LastOnSimpleCase(arg, _, _) =>
          s"Wrong result for an array of size ${arg.length}"
  
    def execute: Unit =
      t match
        case l: LastOnSimpleCase =>
          assertEquals(last(l.arg.toList), l.exp, l.msg)
      
  allTests.foreach(t => 
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
