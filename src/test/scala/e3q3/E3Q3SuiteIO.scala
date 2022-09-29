/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e3q3

object E3Q3SuiteIO:

  import E3Q3._

  sealed abstract class Tests
  case class AddWorks(args: Array[Int], start_tree: Tree[Int], res_tree: Tree[Int], descr: String, points: Int) extends Tests

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: EmptyTree[Int] = EmptyTree(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)

  val allTests: Array[Tests] =
    Array(
      AddWorks(Array(1), empty, singleNode, "add an element to an empty tree", 10),
      AddWorks(Array(2), singleNode, Node(empty, 1, Node(empty, 2, empty, leq), leq), "add a bigger element to a node", 10),
      AddWorks(Array(-1), singleNode, Node(Node(empty, -1, empty, leq), 1, empty, leq), "add a smaller element to a node", 10),
      AddWorks(Array(1, 2, 3, 4, 5), empty, Node(empty, 1, Node(empty, 2, Node(empty, 3, Node(empty, 4, Node(empty, 5, empty, leq), leq), leq), leq), leq), "consecutively adding bigger elements to an empty tree", 10),
      AddWorks(Array(5, 4, 3, 2, 1), empty, Node(Node(Node(Node(Node(empty, 1, empty, leq), 2, empty, leq), 3, empty, leq), 4, empty, leq), 5, empty, leq), "consecutively adding smaller elements to an empty tree", 10),
      AddWorks(Array(1), singleNode, singleNode, "add the same element to a node", 10),
      AddWorks(
        Array(10, 20, 5, 3, 7, 25, 12, 10,25), 
        empty,
        Node(Node(Node(empty, 3, empty, leq), 5, Node(empty, 7, empty, leq), leq), 10, Node(Node(empty, 12, empty, leq), 20, Node(empty, 25, empty, leq), leq), leq),
        "consecutively adding elements to an empty tree", 
        10
      )
    )
