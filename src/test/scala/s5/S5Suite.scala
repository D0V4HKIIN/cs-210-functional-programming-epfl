/* Copyright 2022 EPFL, Lausanne */

package s5

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S5Suite extends munit.FunSuite:

  import S5._
  import S5SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case EvenSlotsWorksOnSimpleCase(arg, _, pts) =>
          val size = arg.length
          if size == 0 then 
            s"Even slots elements of an empty list ($pts pts)"
          else 
            s"Even slots elements of a list of size : $size ($pts pts)"
    
    def msg: String =
      t match
        case EvenSlotsWorksOnSimpleCase(arg, _, _) =>
          val size = arg.length
          if size == 0 then 
            s"Wrong result for an empty list"
          else 
            s"Wrong result for a list of size : $size"
          
    def execute: Unit =
      t match
        case e: EvenSlotsWorksOnSimpleCase =>
          assertEquals(evenSlots(e.arg.toList), e.exp.toList, e.msg)
      

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
