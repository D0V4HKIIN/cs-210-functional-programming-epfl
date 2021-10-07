/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e3q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q3Suite extends munit.FunSuite {

  import E3Q3._

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: EmptyTree[Int] = EmptyTree(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)

  def mkTest(i: Int): (Tree[Int], Tree[Int], String) = { 
    if (i == 1) (empty.add(1), singleNode, "add an element to an empty tree")
    else if (i == 2) (singleNode.add(2), Node(empty, 1, Node(empty, 2, empty, leq), leq), "add a bigger element to a node")
    else if (i == 3) (singleNode.add(-1), Node(Node(empty, -1, empty, leq), 1, empty, leq), "add a smaller element to a node")
    else if (i == 4) (empty.add(1).add(2).add(3).add(4).add(5), Node(empty, 1, Node(empty, 2, Node(empty, 3, Node(empty, 4, Node(empty, 5, empty, leq), leq), leq), leq), leq), "consecutively adding bigger elements to an empty tree")
    else if (i == 5) (empty.add(5).add(4).add(3).add(2).add(1), Node(Node(Node(Node(Node(empty, 1, empty, leq), 2, empty, leq), 3, empty, leq), 4, empty, leq), 5, empty, leq), "consecutively adding smaller elements to an empty tree")
    else (empty.add(1), singleNode, "add an element to an empty tree")
  }

  test("test everything (10pts)") {
    (1 to 5).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(in, out, msg)
    })
  }

  test("add an element to an empty tree (10pts)") {
    assertEquals(empty.add(1), singleNode)
  }

  test("add a bigger element to a node (10pts)") {
    assertEquals(singleNode.add(2), Node(empty, 1, Node(empty, 2, empty, leq), leq))
  }

  test("add a smaller element to a node (10pts)") {
    assertEquals(singleNode.add(-1), Node(Node(empty, -1, empty, leq), 1, empty, leq))
  }

  test("consecutively adding bigger elements to an empty tree (10pts)") {
    assertEquals(empty.add(1).add(2).add(3).add(4).add(5), Node(empty, 1, Node(empty, 2, Node(empty, 3, Node(empty, 4, Node(empty, 5, empty, leq), leq), leq), leq), leq))
  }

  test("consecutively adding smaller elements to an empty tree (10pts)") {
    assertEquals(empty.add(5).add(4).add(3).add(2).add(1), Node(Node(Node(Node(Node(empty, 1, empty, leq), 2, empty, leq), 3, empty, leq), 4, empty, leq), 5, empty, leq))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
