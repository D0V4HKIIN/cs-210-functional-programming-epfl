/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s15

object S15SuiteIO:

  import S15._

  sealed abstract class Tests
  case class IsSymmetricWorksOnSimpleTree(arg: Tree, exp: Boolean, descr: String, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      IsSymmetricWorksOnSimpleTree(Node('a'), true, "a single root node", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b'), End), false, "a 2-element tree (lelft)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', End, Node('b')), false, "a 2-element tree (right)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b'), Node('c')), true, "a complete 3-element tree", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', Node('c'), End), End), false, "an asymetric 3-element tree (left)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', End, Node('b', Node('c'), End)), false, "an asymetric 3-element tree (right)", 10),

      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', Node('c'), End), Node('d')), false, "an asymetric 4-element tree (left)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b'), Node('c', End, Node('d'))), false, "an asymetric 4-element tree (right)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', Node('c'), End), Node('d', End, Node('e'))), true, "a symetric 5-element tree (wide)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', End, Node('c')), Node('d', Node('e'), End)), true, "a symetric 5-element tree (narrow)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', Node('f'), Node('c')), Node('d', Node('e'), Node('g'))), true, "a complete tree of height 2", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', Node('c'), End), Node('d', Node('e'), End)), false, "an asymmetric 5-element tree (left)", 10),
      IsSymmetricWorksOnSimpleTree(Node('a', Node('b', End, Node('c')), Node('d', End, Node('e'))), false, "an asymmetric 5-element tree (right)", 10),
      IsSymmetricWorksOnSimpleTree(Node('f', Node('a', Node('l'), Node('s')), Node('e')), false, "an asymmetric 4-element tree", 10)
    )