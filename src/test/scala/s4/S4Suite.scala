/* Copyright 2022 EPFL, Lausanne */

package s4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S4Suite extends munit.FunSuite:

  import S4._
  import S4SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case LengthWorksOnSimpleCase(arg, _, pts) =>
          val size = arg.length
          if size == 0 then 
            s"Length works on an empty list ($pts pts)"
          else 
            s"Length works on a list of size : $size ($pts pts)"
          
    def msg: String =
      t match
        case LengthWorksOnSimpleCase(arg, _, _) =>
          val size = arg.length
          if size == 0 then 
            s"Wrong result for an empty list"
          else 
            s"Wrong result for a list of size : $size"

    def execute: Unit =
      t match
        case l: LengthWorksOnSimpleCase =>
          assertEquals(length(l.arg.toList), l.exp, l.msg)

  allTests.foreach(t => 
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
