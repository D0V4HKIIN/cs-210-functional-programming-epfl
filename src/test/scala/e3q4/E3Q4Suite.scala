/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e3q4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q4Suite extends munit.FunSuite {

  import E3Q4._

  val leq: (Int, Int) => Boolean = (x, y) => x <= y
  val empty: EmptyTree[Int] = EmptyTree(leq)
  val singleNode: Node[Int] = Node(empty, 1, empty, leq)

  def mkTest(i: Int): (Tree[Int], List[Int], String) = { 
    if (i == 1) (empty, List(), "empty tree to list")
    else if (i == 2) (singleNode, List(1), "single node to list")
    else if (i == 3) (empty.add(1).add(2).add(3).add(4).add(5), List(1, 2, 3, 4, 5), "tree to list 1")
    else if (i == 4) (empty.add(5).add(4).add(3).add(2).add(1), List(1, 2, 3, 4, 5), "tree to list 2")
    else if (i == 5) (empty.add(10).add(20).add(5).add(3).add(7).add(25).add(12).add(1).add(100), List(1, 3, 5, 7, 10, 12, 20, 25, 100), "big tree to list")
    else (empty, List(), "empty tree to list")
  }

  test("test everything (10pts)") {
    (1 to 5).foreach((i: Int) => {
      val (in, out, msg) = mkTest(i)
      assertEquals(in.toList, out, msg)
    })
  }

  test("empty tree to list (10pts)") {
    assertEquals(empty.toList, List())
  }

  test("single node to list (10pts)") {
    assertEquals(singleNode.toList, List(1))
  }

  test("tree to list 1 (10pts)") {
    assertEquals(empty.add(1).add(2).add(3).add(4).add(5).toList, List(1, 2, 3, 4, 5))
  }

  test("tree to list 2 (10pts)") {
    assertEquals(empty.add(5).add(4).add(3).add(2).add(1).toList, List(1, 2, 3, 4, 5))
  }

  test("big tree to list (10pts)") {
    assertEquals(empty.add(10).add(20).add(5).add(3).add(7).add(25).add(12).add(1).add(100).toList, List(1, 3, 5, 7, 10, 12, 20, 25, 100))
  }


  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
}
