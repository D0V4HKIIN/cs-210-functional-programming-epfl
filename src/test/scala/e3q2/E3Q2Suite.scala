/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e3q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q2Suite extends munit.FunSuite {

  import E3Q2._

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: EmptyTree[Int] = EmptyTree(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)
  val littleTree: Node[Int] = Node(singleNode, 1, singleNode, leq)
  val middleTree: Node[Int] = Node(littleTree, 1, littleTree, leq)
  val bigTree: Node[Int] = Node(middleTree, 1, middleTree, leq)

  def mkTest(i: Int): (Tree[Int], Int, String) = { 
    if (i == 1) (empty, 0, "size1 of an empty tree")
    else if (i == 2) (singleNode, 1, "size1 of a node")
    else if (i == 3) (bigTree, 15, "size1 of a big tree")
    else if (i == 4) (empty, 0, "size2 of an empty tree")
    else if (i == 5) (singleNode, 1, "size2 of a node")
    else if (i == 6) (bigTree, 15, "size2 of a big tree")
    else (empty, 0, "size1 of an empty tree")
  }

  test("test everything (10pts)") {
    (1 to 3).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(in.size1, out, msg)
    })

    (4 to 6).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(in.size2, out, msg)
    })
  }

  test("size1 of an empty tree (10pts)") {
    assertEquals(empty.size1, 0)
  }

  test("size1 of a node (10pts)") {
    assertEquals(singleNode.size1, 1)
  }

  test("size1 of a big tree (10pts)") {
    assertEquals(bigTree.size1, 15)
  }

  test("size2 of an empty tree (10pts)") {
    assertEquals(empty.size2, 0)
  }

  test("size2 of a node (10pts)") {
    assertEquals(singleNode.size2, 1)
  }

  test("size2 of a big tree (10pts)") {
    assertEquals(bigTree.size2, 15)
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
