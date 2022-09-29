/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s20

object S20SuiteIO:

  import S20._

  sealed abstract class Tests
  case class LeavesCountWorks(arg: Tree, exp: Int, descr: String, points: Int) extends Tests
  case class LeavesListWorks(arg: Tree, exp: Array[Char], descr: String, points: Int) extends Tests
  case class NodesListWorks(arg: Tree, exp: Array[Char], descr: String, points: Int) extends Tests
  case class ValuesAtLevelWorks(stree: Tree, level: Int, exp: Array[Char], descr: String, points: Int) extends Tests 

  val emptyTree = (End, "an empty tree")
  val singleRoot = (Node('a'), "a single root node")
  val tree2left = (Node('a', Node('b'), End), "a 2-element tree (lelft)")
  val tree2right = (Node('a', End, Node('b')), "a 2-element tree (right)")
  val comp3 = (Node('a', Node('b'), Node('c')), "a complete 3-element tree")
  val asym3left = (Node('a', Node('b', Node('c'), End), End), "an asymetric 3-element tree (left)")
  val asym3right = (Node('a', End, Node('b', Node('c'), End)), "an asymetric 3-element tree (right)")
  val asym4left = (Node('a', Node('b', Node('c'), End), Node('d')), "an asymetric 4-element tree (left)")
  val asym4right = (Node('a', Node('b'), Node('c', End, Node('d'))), "an asymetric 4-element tree (right)")
  val sym5Wide = (Node('a', Node('b', Node('c'), End), Node('d', End, Node('e'))), "a symetric 5-element tree (wide)")
  val sym5Narrow = (Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), "a symetric 5-element tree (narrow)")
  val compH2 = (Node('a', Node('b', Node('f'), Node('c')), Node('d', Node('e'), Node('g'))), "a complete tree of height 2")
  val asym5left = (Node('a', Node('b', Node('c'), End), Node('d', Node('e'), End)), "an asymmetric 5-element tree (left)")
  val asym5right = (Node('a', Node('b', End, Node('c')), Node('d', End, Node('e'))), "an asymmetric 5-element tree (right)")
  val asym4 = (Node('f', Node('a', Node('l'), Node('s')), Node('e')), "an asymmetric 4-element tree")

  
  val allTests: Array[Tests] =
    Array(
      LeavesCountWorks(emptyTree._1, 0, emptyTree._2, 10),
      LeavesCountWorks(singleRoot._1, 1, singleRoot._2, 10),
      LeavesCountWorks(tree2left._1, 1, tree2left._2, 10),
      LeavesCountWorks(tree2right._1, 1, tree2right._2, 10),
      LeavesCountWorks(comp3._1, 2, comp3._2, 10),
      LeavesCountWorks(asym3left._1, 1, asym3left._2, 10),
      LeavesCountWorks(asym3right._1, 1, asym3right._2, 10),
      LeavesCountWorks(asym4left._1, 2, asym4left._2, 10),
      LeavesCountWorks(asym4right._1, 2, asym4right._2, 10),
      LeavesCountWorks(sym5Wide._1, 2, sym5Wide._2, 10),
      LeavesCountWorks(sym5Narrow._1, 2, sym5Narrow._2, 10),
      LeavesCountWorks(compH2._1, 4, compH2._2, 10),
      LeavesCountWorks(asym5left._1, 2, asym5left._2, 10),
      LeavesCountWorks(asym5right._1, 2, asym5right._2, 10),
      LeavesCountWorks(asym4._1, 3, asym4._2, 10),

      LeavesListWorks(emptyTree._1, Array[Char](), emptyTree._2, 10),
      LeavesListWorks(singleRoot._1, Array('a'), singleRoot._2, 10),
      LeavesListWorks(tree2left._1, Array('b'), tree2left._2, 10),
      LeavesListWorks(tree2right._1, Array('b'), tree2right._2, 10),
      LeavesListWorks(comp3._1, Array('b', 'c'), comp3._2, 10),
      LeavesListWorks(asym3left._1, Array('c'), asym3left._2, 10),
      LeavesListWorks(asym3right._1, Array('c'), asym3right._2, 10),
      LeavesListWorks(asym4left._1, Array('c', 'd'), asym4left._2, 10),
      LeavesListWorks(asym4right._1, Array('d', 'b'), asym4right._2, 10),
      LeavesListWorks(sym5Wide._1, Array('c', 'e'), sym5Wide._2, 10),
      LeavesListWorks(sym5Narrow._1, Array('c', 'e'), sym5Narrow._2, 10),
      LeavesListWorks(compH2._1, Array('f', 'c', 'e', 'g'), compH2._2, 10),
      LeavesListWorks(asym5left._1, Array('c', 'e'), asym5left._2, 10),
      LeavesListWorks(asym5right._1, Array('c', 'e'), asym5right._2, 10),
      LeavesListWorks(asym4._1, Array('e', 'l', 's'), asym4._2, 10),

      NodesListWorks(emptyTree._1, Array[Char](), emptyTree._2, 10),
      NodesListWorks(singleRoot._1, Array[Char](), singleRoot._2, 10),
      NodesListWorks(tree2left._1, Array('a'), tree2left._2, 10),
      NodesListWorks(tree2right._1, Array('a'), tree2right._2, 10),
      NodesListWorks(comp3._1, Array('a'), comp3._2, 10),
      NodesListWorks(asym3left._1, Array('a', 'b'), asym3left._2, 10),
      NodesListWorks(asym3right._1, Array('a', 'b'), asym3right._2, 10),
      NodesListWorks(asym4left._1, Array('a', 'b'), asym4left._2, 10),
      NodesListWorks(asym4right._1, Array('a', 'c'), asym4right._2, 10),
      NodesListWorks(sym5Wide._1, Array('a', 'b', 'd'), sym5Wide._2, 10),
      NodesListWorks(sym5Narrow._1, Array('a', 'b', 'd'), sym5Narrow._2, 10),
      NodesListWorks(compH2._1, Array('a', 'b', 'd'), compH2._2, 10),
      NodesListWorks(asym5left._1, Array('a', 'b', 'd'), asym5left._2, 10),
      NodesListWorks(asym5right._1, Array('a', 'b', 'd'), asym5right._2, 10),
      NodesListWorks(asym4._1, Array('f', 'a'), asym4._2, 10),

      ValuesAtLevelWorks(emptyTree._1, -1, Array[Char](), emptyTree._2, 10),
      ValuesAtLevelWorks(emptyTree._1, 30, Array[Char](), emptyTree._2, 10),
      ValuesAtLevelWorks(emptyTree._1, 1, Array[Char](), emptyTree._2, 10),
      ValuesAtLevelWorks(singleRoot._1, 1, Array[Char]('a'), singleRoot._2, 10),
      ValuesAtLevelWorks(tree2left._1, 1, Array('a'), tree2left._2, 10),
      ValuesAtLevelWorks(tree2right._1, 0, Array[Char](), tree2right._2, 10),
      ValuesAtLevelWorks(comp3._1, 1, Array('a'), comp3._2, 10),
      ValuesAtLevelWorks(comp3._1, 2, Array('b', 'c'), comp3._2, 10),
      ValuesAtLevelWorks(asym3right._1, 1, Array('a'), asym3right._2, 10),
      ValuesAtLevelWorks(asym3right._1, 2, Array('b'), asym3right._2, 10),
      ValuesAtLevelWorks(asym3right._1, 3, Array('c'), asym3right._2, 10),
      ValuesAtLevelWorks(asym4left._1, 2, Array('b', 'd'), asym4left._2, 10),
      ValuesAtLevelWorks(asym4right._1, 3, Array('d'), asym4right._2, 10),
      ValuesAtLevelWorks(sym5Wide._1, 3, Array('c', 'e'), sym5Wide._2, 10),
      ValuesAtLevelWorks(sym5Narrow._1, 2, Array('b', 'd'), sym5Narrow._2, 10),
      ValuesAtLevelWorks(compH2._1, 2, Array('b', 'd'), compH2._2, 10),
      ValuesAtLevelWorks(compH2._1, 3, Array('f', 'c', 'e', 'g'), compH2._2, 10),
      ValuesAtLevelWorks(asym5left._1, 2, Array('b', 'd'), asym5left._2, 10),
      ValuesAtLevelWorks(asym5left._1, 3, Array('c', 'e'), asym5left._2, 10),
      ValuesAtLevelWorks(asym4._1, 1, Array('f'), asym4._2, 10),
      ValuesAtLevelWorks(asym4._1, 2, Array('e', 'a'), asym4._2, 10),
    )
