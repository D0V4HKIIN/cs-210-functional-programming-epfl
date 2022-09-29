/* Copyright 2022 EPFL, Lausanne */

package e3q4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q4Suite extends munit.FunSuite:

  import E3Q4._
  import E3Q4SuiteIO._


  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: EmptyTree[Int] = EmptyTree(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)


  extension (t: Tests)
    def title: String =
      t match 
        case ToListWorks(args, _, pts) =>
          s"ToList works for a tree of size : ${args.length} ($pts pts)"
    def msg: String =
      t match 
        case ToListWorks(args, _, _) =>
          s"Wrong result for a tree of size : ${args.length}"

    def execute: Unit =
      t match
        case t: ToListWorks =>
          val comp = t.args.toList.foldLeft[Tree[Int]](empty)((acc, first) => acc.add(first))
          assertEquals(comp.toList, t.exp.toList, t.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }    
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
