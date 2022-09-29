/* Copyright 2022 EPFL, Lausanne */

package s20

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S20Suite extends munit.FunSuite:

  import S20._
  import S20SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case LeavesCountWorks(arg, exp, descr, pts) =>
          s"Count the leaves of $descr ($pts pts)"
        case LeavesListWorks(arg, exp, descr, pts) =>
          s"Collect the leaves of $descr ($pts pts)"
        case NodesListWorks(arg, exp, descr, pts) =>
          s"Collect the values from nodes of $descr ($pts pts)"
        case ValuesAtLevelWorks(stree, l, exp, descr, pts) =>
          s"Collect the values from nodes at level : $l of $descr ($pts pts)"
        
    def msg: String =
      t match
        case LeavesCountWorks(arg, exp, descr, pts) =>
          s"Wrong leaves count of $descr"
        case LeavesListWorks(arg, exp, descr, pts) =>
          s"Wrong leaves values collected for $descr"
        case NodesListWorks(arg, expr, descr, pts) =>
          s"Wrong nodes values collected for $descr" 
        case ValuesAtLevelWorks(stree, l, exp, descr, pts) =>
          s"Wrong values collected at level : $l of $descr"

    def execute: Unit =
      t match
        case lc: LeavesCountWorks =>
          assertEquals(lc.arg.leavesCount, lc.exp, lc.msg)  
        case ll: LeavesListWorks =>
          assertEquals(ll.arg.leavesList.sorted, ll.exp.toList.sorted, ll.msg)
        case nl: NodesListWorks =>
          assertEquals(nl.arg.nodesList.sorted, nl.exp.toList.sorted, nl.msg)
        case nlev: ValuesAtLevelWorks =>
          assertEquals(nlev.stree.valuesAtLevel(nlev.level).sorted, nlev.exp.toList.sorted, nlev.msg)
  
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")