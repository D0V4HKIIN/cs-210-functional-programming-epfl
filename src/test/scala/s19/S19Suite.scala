/* Copyright 2022 EPFL, Lausanne */

package s19

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S19Suite extends munit.FunSuite:

  import S19._
  import S19SuiteIO._
  import S19.Tree._


  extension (t: Tests)
    def title: String =
      t match
        case AllCBalancedWorks(n, _, _, pts) =>
          s"All completely balanced trees with $n nodes ($pts pts)"
        case AllSymCBalancedWorks(n, _, _, pts) =>
          s"All symmetric and completely balanced trees with $n nodes ($pts pts)"
        case AllHBalancedWorks(h, _, _, pts) =>
          s"All height balanced trees with height : $h ($pts pts)"
        case AllHBalancedWithNodesWorks(n, _, _, pts) =>
          s"All height balanced trees with $n nodes ($pts pts)"

    def msg: String =
      t match
        case AllCBalancedWorks(n, _, _, _) => 
          s"Wrong result for all completely balanced trees with $n nodes"
        case AllSymCBalancedWorks(n, _, _, _) =>
          s"Wrong result for all symmetric and completely balanced trees with $n nodes"
        case AllHBalancedWorks(h, _, _, _) =>
          s"Wrong result for all height balanced trees with height : $h"
        case AllHBalancedWithNodesWorks(n, _, _, _) =>
          s"Wrong result for all height balanced trees with $n nodes"

    def execute: Unit =
      
      def toSetWDupCheck(ls: List[Tree]): Set[Tree] =
        val s = ls.toSet
        require(ls.size == s.size, "Your resulted list shouldn't contains some duplicate trees")
        s

      t match
        case cb: AllCBalancedWorks =>
          assertEquals(toSetWDupCheck(allCBalanced(cb.n, cb.v)), cb.exp.toSet, cb.msg)
        case scb: AllSymCBalancedWorks =>
          assertEquals(toSetWDupCheck(allSymCBalanced(scb.n, scb.v)), scb.exp.toSet, scb.msg)
        case hb: AllHBalancedWorks =>
          assertEquals(toSetWDupCheck(allHBalanced(hb.h, hb.v)), hb.exp.toSet, hb.msg)
        case hbn: AllHBalancedWithNodesWorks =>
          val res = allHBalancedWithNodes(hbn.n, hbn.v)
          assertEquals(toSetWDupCheck(res), hbn.exp.toSet, hbn.msg)
    
        
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")