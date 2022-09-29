/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s19

object S19SuiteIO:

  import S19._
  import S19.Tree._

  sealed abstract class Tests
  case class AllCBalancedWorks(n: Int, v: Char, exp: Array[Tree], points: Int) extends Tests
  case class AllSymCBalancedWorks(n: Int, v: Char, exp: Array[Tree], points: Int) extends Tests
  case class AllHBalancedWorks(h: Int, v: Char, exp: Array[Tree], points: Int) extends Tests
  case class AllHBalancedWithNodesWorks(n: Int, v: Char, exp: Array[Tree], points: Int) extends Tests 

  val trees4nCBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), End), Node('x')),
      Node('x', Node('x', End, Node('x')), Node('x')),
      Node('x', Node('x'), Node('x', Node('x'), End)),
      Node('x', Node('x'), Node('x', End, Node('x')))
    )

  val trees5nCBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), End), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', Node('x'), End)),
      Node('x', Node('x', Node('x'), End), Node('x', Node('x'), End)),
    )

  val trees6nCBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), End), Node('x', Node('x'), Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', Node('x'), Node('x'))),
      Node('x', Node('x', Node('x'), Node('x')), Node('x', End, Node('x'))),
      Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), End))
    )

  val trees7nCBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), Node('x')))
    )

  val trees5nCSymBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), End), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', Node('x'), End))
    )

  val trees2HBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), End), Node('x')),
      Node('x', Node('x', End, Node('x')), Node('x')),
      Node('x', Node('x'), Node('x', Node('x'), End)),
      Node('x', Node('x'), Node('x', End, Node('x'))),

      Node('x', Node('x', Node('x'), End), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', Node('x'), End)),
      Node('x', Node('x', Node('x'), End), Node('x', Node('x'), End)),

      Node('x', Node('x', Node('x'), End), Node('x', Node('x'), Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', Node('x'), Node('x'))),
      Node('x', Node('x', Node('x'), Node('x')), Node('x', End, Node('x'))),
      Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), End)),

      Node('x', Node('x', End, End), Node('x', Node('x'), Node('x'))),
      Node('x', Node('x', Node('x'), Node('x')), Node('x', End, End)),

      Node('x', Node('x', Node('x'), Node('x')), Node('x', Node('x'), Node('x')))
    )

  val trees5nHBalanced: Array[Tree] =
    Array(
      Node('x', Node('x', Node('x'), End), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', End, Node('x'))),
      Node('x', Node('x', End, Node('x')), Node('x', Node('x'), End)),
      Node('x', Node('x', Node('x'), End), Node('x', Node('x'), End)),

      Node('x', Node('x', End, End), Node('x', Node('x'), Node('x'))),
      Node('x', Node('x', Node('x'), Node('x')), Node('x', End, End))
    )


  val allTests: Array[Tests] =
    Array(
      AllCBalancedWorks(-1, 'x', Array(End), 10),
      AllCBalancedWorks(0, 'x', Array(End), 10),
      AllCBalancedWorks(1, 'x', Array(Node('x')), 10),
      AllCBalancedWorks(2, 'x', Array(Node('x', End, Node('x')), Node('x', Node('x'), End)), 10),
      AllCBalancedWorks(3, 'x', Array(Node('x', Node('x'), Node('x'))), 10),
      AllCBalancedWorks(4, 'x', trees4nCBalanced, 10),
      AllCBalancedWorks(5, 'x', trees5nCBalanced, 10),
      AllCBalancedWorks(6, 'x', trees6nCBalanced, 10),
      AllCBalancedWorks(7, 'x', trees7nCBalanced, 10),

      AllSymCBalancedWorks(-1, 'x', Array(End), 10),
      AllSymCBalancedWorks(0, 'x', Array(End), 10),
      AllSymCBalancedWorks(1, 'x', Array(Node('x')), 10),
      AllSymCBalancedWorks(2, 'x', Array[Tree](), 10),
      AllSymCBalancedWorks(3, 'x', Array(Node('x', Node('x'), Node('x'))), 10),
      AllSymCBalancedWorks(4, 'x', Array[Tree](), 10),
      AllSymCBalancedWorks(5, 'x', trees5nCSymBalanced, 10),
      AllSymCBalancedWorks(6, 'x', Array[Tree](), 10),
      AllSymCBalancedWorks(7, 'x', trees7nCBalanced, 10),

      AllHBalancedWorks(-1, 'x', Array(End), 10),
      AllHBalancedWorks(0, 'x', Array(Node('x')), 10),
      AllHBalancedWorks(1, 'x', Array(Node('x', Node('x'), Node('x')), Node('x', End, Node('x')), Node('x', Node('x'), End)), 10),
      AllHBalancedWorks(2, 'x', trees2HBalanced, 10),

      AllHBalancedWithNodesWorks(-1, 'x', Array(End), 10),
      AllHBalancedWithNodesWorks(0, 'x', Array(End), 10),
      AllHBalancedWithNodesWorks(1, 'x', Array(Node('x')), 10),
      AllHBalancedWithNodesWorks(2, 'x', Array(Node('x', Node('x'), End), Node('x', End, Node('x'))), 10),
      AllHBalancedWithNodesWorks(3, 'x', Array(Node('x', Node('x'), Node('x'))), 10),
      AllHBalancedWithNodesWorks(4, 'x', trees4nCBalanced, 10),
      AllHBalancedWithNodesWorks(5, 'x', trees5nHBalanced, 10)
    )