/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package s15

object S15:

  abstract class Tree
  case class Node(value: Char, left: Tree, right: Tree) extends Tree

  case object End extends Tree
  case object Node:
    def apply(c: Char): Node = Node(c, End, End)
  
  /**
    *
    * @param tree a binary tree
    * @return whether `tree` is symmetric (in terms of structure) or not
    */
  def isSymmetric(tree: Tree): Boolean = ???
