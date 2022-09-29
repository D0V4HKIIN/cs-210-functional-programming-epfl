/* Copyright 2022 EPFL, Lausanne */

package s9

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S9Suite extends munit.FunSuite:

  import S9._
  import S9SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case RunLengthWorksOnSimpleCase(arg, _, pts) =>
          s"RunLength works on a list of size : ${arg.length} ($pts pts)"

    def msg: String =
      t match
        case RunLengthWorksOnSimpleCase(arg, _, _) =>
          s"Wrong result for a list of size : ${arg.length}"

    def execute: Unit = 
      t match
        case r: RunLengthWorksOnSimpleCase =>
          assertEquals(runLength(r.arg.toList), r.exp.toList, r.msg)
      
  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
