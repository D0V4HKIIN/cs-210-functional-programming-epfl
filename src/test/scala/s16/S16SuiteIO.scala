/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s16

object S16SuiteIO:

  import S16._
  import S16.Tree._

  sealed abstract class Tests
  case class AddWorks(args: Array[Int], start_tree: Tree[Int], res_tree: Tree[Int], descr: String, points: Int) extends Tests
  case class DeleteWorks(args: Array[Int], start_tree: Tree[Int], res_tree: Tree[Int], descr: String, points: Int) extends Tests
  
  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: Empty[Int] = Empty(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)

  val testTreeForDelete: Tree[Int] = 
    Node(
      Node(Node(Node(empty, 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val treeDelete1: Tree[Int] =
    Node(
      Node(Node(empty, 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val treeDelete3: Tree[Int] =
    Node(
      Node(Node(Node(empty, 1, empty, leq), 2, empty, leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val treeDelete10: Tree[Int] =
    Node(
      Node(Node(Node(empty, 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 11, empty, leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val treeDelete4: Tree[Int] = 
    Node(
      Node(Node(empty, 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val treeDelete8: Tree[Int] = 
    Node(
      Node(Node(Node(empty, 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      10, 
      Node(Node(empty, 11, empty, leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )
  
  val treeDelete12: Tree[Int] = 
    Node(
      Node(Node(Node(empty, 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 14, empty, leq),
      leq  
    )
  
  val treeDelete2: Tree[Int] = 
    Node(
      Node(Node(Node(empty, 1, empty, leq), 3, empty, leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq  
    )

  val allTests: Array[Tests] =
    Array(
      AddWorks(Array(1), empty, singleNode, "Add an element to an empty tree", 10),
      AddWorks(Array(2), singleNode, Node(empty, 1, Node(empty, 2, empty, leq), leq), "Add a bigger element to a node", 10),
      AddWorks(Array(-1), singleNode, Node(Node(empty, -1, empty, leq), 1, empty, leq), "Add a smaller element to a node", 10),
      AddWorks(Array(1, 2, 3, 4, 5), empty, Node(empty, 1, Node(empty, 2, Node(empty, 3, Node(empty, 4, Node(empty, 5, empty, leq), leq), leq), leq), leq), "Consecutively adding bigger elements to an empty tree", 10),
      AddWorks(Array(5, 4, 3, 2, 1), empty, Node(Node(Node(Node(Node(empty, 1, empty, leq), 2, empty, leq), 3, empty, leq), 4, empty, leq), 5, empty, leq), "Consecutively adding smaller elements to an empty tree", 10),
      AddWorks(Array(1), singleNode, singleNode, "Add the same element to a node", 10),
      AddWorks(
        Array(10, 20, 5, 3, 7, 25, 12, 10,25), 
        empty,
        Node(Node(Node(empty, 3, empty, leq), 5, Node(empty, 7, empty, leq), leq), 10, Node(Node(empty, 12, empty, leq), 20, Node(empty, 25, empty, leq), leq), leq),
        "Consecutively adding elements to an empty tree", 
        10
      ),

      DeleteWorks(Array(9), testTreeForDelete, testTreeForDelete, "Delete an element not present in the tree", 10),
      DeleteWorks(Array(1), testTreeForDelete, treeDelete1, "Delete a left leaf", 10),
      DeleteWorks(Array(3), testTreeForDelete, treeDelete3, "Delete a right leaf", 10),
      DeleteWorks(Array(10), testTreeForDelete, treeDelete10, "Delete a node with only one child", 10),
      DeleteWorks(Array(4), testTreeForDelete, treeDelete4, "Delete an other node with only one child", 10),
      DeleteWorks(Array(8), testTreeForDelete, treeDelete8, "Delete the root of the tree", 10),
      DeleteWorks(Array(12), testTreeForDelete, treeDelete12, "Delete a node with two childs", 10),
      DeleteWorks(Array(2), testTreeForDelete, treeDelete2, "Delete another node with two childs", 10),
      DeleteWorks(Array(4, 2, 1, 3, 10, 11, 12, 14, 8), testTreeForDelete, empty, "Delete all the tree", 10)
    )