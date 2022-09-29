/* Copyright 2022 EPFL, Lausanne */

package e3q5

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q5Suite extends munit.FunSuite:

  import E3Q5._
  import E3Q5SuiteIO._

  val leq: (Int, Int) => Boolean = (x, y) => x <= y

  extension (t: Tests)
    def title: String =
      t match
        case SortedListWorks(args, exp, pts) =>
          s"SortedList works on a list of size : ${args.length} ($pts pts)"
      
    def msg: String =
      t match
        case SortedListWorks(args, exp, pts) =>
          s"Wrong result for an array of size : ${args.length}"
      
    def execute: Unit =
      t match
        case s: SortedListWorks =>
          assertEquals(sortedList(leq, s.args.toList), s.exp.toList, s.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
