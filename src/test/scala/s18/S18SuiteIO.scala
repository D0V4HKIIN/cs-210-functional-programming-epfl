/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s18

object S18SuiteIO:

  import S18._
  import S18.Tree._

  sealed abstract class Tests
  case class HeightWorks(start_tree: Tree[Int], exp: Int, descr: String, points: Int) extends Tests
  case class IsBalancedWorks(start_tree: Tree[Int], exp: Boolean, descr: String, points: Int) extends Tests
  case class BalancedWorks(start_tree: Tree[Int], exp: Tree[Int], descr: String, points: Int) extends Tests

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: Empty[Int] = Empty(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)

  val testTree1: Tree[Int] = 
    Node(
      Node(Node(Node(Node(empty, 0, empty, leq), 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )
  
  val balancedTree1: Tree[Int] =
    Node(
      Node(Node(Node(empty, 0, empty, leq), 1, empty, leq), 2, Node(Node(empty, 3, empty, leq), 4, empty, leq), leq), 
      8, 
      Node(Node(Node(empty, 10, empty, leq), 11, empty, leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val allTests: Array[Tests] =
    Array(
      HeightWorks(empty, 0, "an empty tree",10),
      HeightWorks(singleNode, 0, "a single node",10),
      HeightWorks(testTree1, 4, "a first tree", 10),
      HeightWorks(balancedTree1, 3, "the same first tree but balanced", 10),
      IsBalancedWorks(testTree1, false, "an unbalanced tree", 10),
      IsBalancedWorks(balancedTree1, true, "a balanced tree but not symmetric", 10),
      BalancedWorks(balancedTree1, balancedTree1, "an already balanced tree", 10),
      BalancedWorks(testTree1, balancedTree1, "an unbalanced tree", 10)
    )