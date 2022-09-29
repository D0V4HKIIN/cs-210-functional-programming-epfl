/* Copyright 2022 EPFL, Lausanne */

package e3q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q3Suite extends munit.FunSuite:

  import E3Q3._
  import E3Q3SuiteIO._

  extension (t: Tests)
    def title: String =
      t match 
        case AddWorks(args, stree, rtree, descr, pts) =>
          s"$descr ($pts pts)"

    def msg: String =
      t match 
        case AddWorks(args, stree, rtree, descr, pts) =>
          val size = args.size
          s"Wrong result when $descr (#$size call(s) to add)"

    def execute: Unit =
      t match
        case a: AddWorks =>
          val adds = a.args.toList.foldLeft(a.start_tree)((acc, first) => acc.add(first))
          assertEquals(adds, a.res_tree, a.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
