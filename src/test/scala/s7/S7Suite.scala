/* Copyright 2022 EPFL, Lausanne */

package s7

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S7Suite extends munit.FunSuite:

  import S7._
  import S7SuiteIO._

  extension (t: Tests)

    def title: String = 
      t match
        case FlattenWorksOnIntList(arg, exp, descr, pts) =>
          s"Flatten $descr ($pts pts)"

    def msg: String = 
      t match
        case FlattenWorksOnIntList(_, _, descr, pts) =>
          s"Wrong result for $descr"
      
    def execute: Unit = 
      t match
        case f: FlattenWorksOnIntList =>
          assertEquals(flatten(f.arg), f.exp.toList, f.msg)

  allTests.foreach(t => 
    test(t.title) { t.execute }
  ) 

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
