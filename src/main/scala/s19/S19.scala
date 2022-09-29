/* Copyright 2022 EPFL, Lausanne */

package s19

object S19:

  sealed abstract class Tree:
    def nodeCount: Int

  case class Node(value: Char, left: Tree, right: Tree) extends Tree:
    override def toString = 
      s"( $left  $value  $right )"
    def nodeCount: Int = left.nodeCount + right.nodeCount + 1

  case object End extends Tree:
    override def toString = "_"
    def nodeCount: Int = 0
    
  object Node:
    def apply(value: Char): Node = Node(value, End, End)

  object Tree:

    /***
      * @param nodes The number of nodes for the resulting Trees
      * @param value The value which will be the same for all nodes of the resulting Tree
      * @return A List containing all the possibilities of completely balanced Trees
      */
    def allCBalanced(nodes: Int, value: Char): List[Tree] = ???

    /**
    * @param tree a binary tree
    * @return whether `tree` is symmetric (in terms of structure) or not
    */
    def isSymmetric(tree: Tree): Boolean = ???
      //Paste here your implementation from previous exercise

    def allSymCBalanced(nodes: Int, value: Char): List[Tree] = ???

    /***
      * @param height The height wanted for the resulting Trees
      * @param value The value which will be the same for all nodes of the resulting Tree
      * @return A List containing all the possibilities of height balanced Trees
      */
    def allHBalanced(height: Int, value: Char): List[Tree] = ???

    /***
      * @param nodes The number of nodes for the resulting Trees
      * @param value The value which will be the same for all nodes of the resulting Tree
      * @return A List containing all the possibilities of height balanced Trees
      */
    def allHBalancedWithNodes(nodes: Int, value: Char): List[Tree] = ???
