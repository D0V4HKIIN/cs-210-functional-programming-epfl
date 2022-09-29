/* Copyright 2022 EPFL, Lausanne */

package s18

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S18Suite extends munit.FunSuite:

  import S18._
  import S18SuiteIO._
  
  extension (t: Tests)
    def title: String =
      t match 
        case HeightWorks(stree, exp, descr, pts) =>
          s"The height of $descr ($pts pts)"
        case IsBalancedWorks(stree, exp, descr, pts) =>
          s"Is $descr balanced ? ($pts pts)"
        case BalancedWorks(stree, exp, descr, pts) =>
          s"Apply balanced on $descr ($pts pts)"

    def msg: String =
      t match 
        case HeightWorks(stree, exp, descr, pts) =>
          s"Wrong result for the height of $descr"
        case IsBalancedWorks(stree, exp, descr, pts) =>
          s"Wrong when determining if $descr is balanced"
        case BalancedWorks(stree, exp, descr, pts) =>
          s"Wrong result when applying balanced on $descr"

    def execute[T, U]: Unit =
      t match
        case h: HeightWorks =>
          assertEquals(h.start_tree.height, h.exp, h.msg)
        case i: IsBalancedWorks =>
          assertEquals(i.start_tree.isBalanced, i.exp, i.msg)
        case b: BalancedWorks =>
          assertEquals(b.start_tree.balanced, b.exp, b.msg)
        
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")