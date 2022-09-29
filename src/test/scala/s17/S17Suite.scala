/* Copyright 2022 EPFL, Lausanne */

package s17

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S17Suite extends munit.FunSuite:

  import S17._
  import S17SuiteIO._
  
  extension (t: Tests)
    def title: String =
      t match 
        case CollectInOrderWorks(arg, exp, descr, pts) =>
          s"Collect elements in order $descr ($pts pts)"
        case CollectPostOrderWorks(arg, exp, descr, pts) =>
          s"Collect elements in post order $descr ($pts pts)"
        case CollectPreOrderWorks(arg, exp, descr, pts) =>
          s"Collect elements in pre order $descr ($pts pts)"
        case FoldInOrderWorks(_, _, _, _, descr, pts) =>
          s"Fold elements in order $descr ($pts pts)"
        case FoldPreOrderWorks(_, _, _, _, descr, pts) =>
          s"Fold elements in pre order $descr ($pts pts)"
        case FoldPostOrderWorks(_, _, _, _, descr, pts) =>
          s"Fold elements in post order $descr ($pts pts)"

    def msg: String =
      t match 
        case CollectInOrderWorks(arg, exp, descr, pts) =>
          s"Wrong result when collecting elements in order $descr"
        case CollectPostOrderWorks(arg, exp, descr, pts) =>
          s"Wrong result collecting elements in post order $descr"
        case CollectPreOrderWorks(arg, exp, descr, pts) =>
          s"Wrong result collecting elements in pre order $descr"
        case FoldInOrderWorks(_, _, _, _, descr, pts) =>
          s"Wrong result when folding elements in order $descr ($pts pts)"
        case FoldPreOrderWorks(_, _, _, _, descr, pts) =>
          s"Fold elements when folding in pre order $descr ($pts pts)"
        case FoldPostOrderWorks(_, _, _, _, descr, pts) =>
          s"Fold elements in post order $descr ($pts pts)"

    def execute[T, U]: Unit =
      t match
        case io: CollectInOrderWorks =>
          assertEquals(io.start_tree.collectInOrder, io.exp, io.msg)
        case pre: CollectPreOrderWorks =>
          assertEquals(pre.start_tree.collectPreOrder, pre.exp, pre.msg)
        case po: CollectPostOrderWorks =>
          assertEquals(po.start_tree.collectPostOrder, po.exp, po.msg)
        case io: FoldInOrderWorks[T, U] =>
          assertEquals(io.start_tree.foldInOrder(io.z)(io.op), io.exp, io.msg)
        case pre: FoldPreOrderWorks[T, U] =>
          assertEquals(pre.start_tree.foldPreOrder(pre.z)(pre.op), pre.exp, pre.msg)
        case po: FoldPostOrderWorks[T, U] =>
          assertEquals(po.start_tree.foldPostOrder(po.z)(po.op), po.exp, po.msg)
        
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )
  
  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")