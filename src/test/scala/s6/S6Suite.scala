/* Copyright 2022 EPFL, Lausanne */

package s6

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S6Suite extends munit.FunSuite:

  import S6._
  import S6SuiteIO._

  extension (t: Tests) 
    def title: String =
      t match
        case SortedWorksOnSimpleCase(arg, exp, pts) =>
          val size = arg.length
          if size == 0 then 
            s"Sorted works for an empty list ($pts pts)"
          else if size == 1 then
            s"Sorted works for a singleton list ($pts pts)"
          else if exp then 
            s"Sorted works for an ordered list of size : ${arg.length} ($pts pts)"
          else
            s"Sorted works for an unordered list of size : ${arg.length} ($pts pts)"

    def msg: String =
      t match
        case SortedWorksOnSimpleCase(arg, exp, _) =>
          val size = arg.length
          if exp then 
            s"Wrong result for an ordered list of size : $size"
          else 
            s"Wrong result for an unordered list of size : $size"

    def execute: Unit =
      t match
        case s: SortedWorksOnSimpleCase =>
          assertEquals(sorted(s.arg.toList), s.exp, s.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")