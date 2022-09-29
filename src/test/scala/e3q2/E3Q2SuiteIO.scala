/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e3q2

object E3Q2SuiteIO:

  import E3Q2._

  sealed abstract class Tests
  case class SizeWorks(tree: Tree[Int], exp: Int, points: Int) extends Tests

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: EmptyTree[Int] = EmptyTree(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)
  val littleTree: Node[Int] = Node(singleNode, 1, singleNode, leq)
  val middleTree: Node[Int] = Node(littleTree, 1, littleTree, leq)
  val bigTree: Node[Int] = Node(middleTree, 1, middleTree, leq)

  val allTests: Array[Tests] =
    Array(
      SizeWorks(EmptyTree(leq), 0, 10),
      SizeWorks(singleNode, 1, 10),
      SizeWorks(littleTree, 3, 10),
      SizeWorks(middleTree, 7, 10),
      SizeWorks(bigTree, 15, 10)
    )

    