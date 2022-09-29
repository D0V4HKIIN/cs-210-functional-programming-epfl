/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s17

object S17SuiteIO:

  import S17._
  import S17.Tree._

  sealed abstract class Tests
  case class CollectInOrderWorks(start_tree: Tree[Int], exp: List[Int], descr: String, points: Int) extends Tests
  case class CollectPreOrderWorks(start_tree: Tree[Int], exp: List[Int], descr: String, points: Int) extends Tests
  case class CollectPostOrderWorks(start_tree: Tree[Int], exp: List[Int], descr: String, points: Int) extends Tests
  case class FoldInOrderWorks[T, U](start_tree: Tree[T], op: (U, T) => U, z: U, exp: U, descr: String, points: Int) extends Tests
  case class FoldPreOrderWorks[T, U](start_tree: Tree[T], op: (U, T) => U, z: U, exp: U, descr: String, points: Int) extends Tests
  case class FoldPostOrderWorks[T, U](start_tree: Tree[T], op: (U, T) => U, z: U, exp: U, descr: String, points: Int) extends Tests

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: Empty[Int] = Empty(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)
  val cons: (List[Int], Int) => List[Int] = (acc, first) => first :: acc
  val addi: (Int, Int) => Int = (x, y) => x + y

  val testTree: Tree[Int] = 
    Node(
      Node(Node(Node(empty, 1, empty, leq), 2, Node(empty, 3, empty, leq), leq), 4, empty, leq), 
      8, 
      Node(Node(empty, 10, Node(empty, 11, empty, leq), leq), 12, Node(empty, 14, empty, leq), leq),
      leq
    )

  val allTests: Array[Tests] =
    Array(
      CollectInOrderWorks(testTree, List(1, 2, 3, 4, 8, 10, 11, 12, 14), "on test tree", 10),
      CollectPreOrderWorks(testTree, List(8, 4, 2, 1, 3, 12, 10, 11, 14), "on test tree", 10),
      CollectPostOrderWorks(testTree, List(1, 3, 2, 4, 11, 10, 14, 12, 8), "on test tree", 10),
      FoldInOrderWorks(testTree, addi, 0, 65, "with sum function", 10),
      FoldPreOrderWorks(testTree, addi, 0, 65, "with sum function", 10),
      FoldPostOrderWorks(testTree, addi, 0, 65, "with sum function", 10),
      FoldInOrderWorks[Int, List[Int]](testTree, cons, Nil, List(1, 2, 3, 4, 8, 10, 11, 12, 14), "as collect", 10),
      FoldPreOrderWorks[Int, List[Int]](testTree, cons, Nil, List(8, 4, 2, 1, 3, 12, 10, 11, 14), "as collect", 10),
      FoldPostOrderWorks[Int, List[Int]](testTree, cons, Nil, List(1, 3, 2, 4, 11, 10, 14, 12, 8), "as collect", 10)
    )