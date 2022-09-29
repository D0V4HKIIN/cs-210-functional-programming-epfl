/* Copyright 2022 EPFL, Lausanne */

package s16

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S16Suite extends munit.FunSuite:

  import S16._
  import S16SuiteIO._
  
  extension (t: Tests)
    def title: String =
      t match 
        case AddWorks(args, stree, rtree, descr, pts) =>
          s"$descr ($pts pts)"
        case DeleteWorks(args, stree, rtree, descr, pts) =>
          s"$descr ($pts pts)"

    def msg: String =
      t match 
        case AddWorks(args, stree, rtree, descr, pts) =>
          val size = args.size
          s"Wrong result when $descr (#$size call(s) to add)"

        case DeleteWorks(args, stree, rtree, descr, pts) =>
          val size = args.size
          s"Wrong result when $descr (#$size call(s) to delete)"

    def execute: Unit =
      t match
        case a: AddWorks =>
          val adds = a.args.toList.foldLeft(a.start_tree)((acc, first) => acc.add(first))
          assertEquals(adds, a.res_tree, a.msg)
        case d: DeleteWorks =>
          val dels = d.args.toList.foldLeft(d.start_tree)((acc, first) => acc.delete(first))
          assertEquals(dels, d.res_tree, d.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")