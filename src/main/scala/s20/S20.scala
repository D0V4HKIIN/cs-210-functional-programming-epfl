/* Copyright 2022 EPFL, Lausanne */

package s20

object S20:

  case object End extends Tree
  case class Node(elem: Char, left: Tree, right: Tree) extends Tree
  object Node:
    def apply(c: Char): Node =
      Node(c, End, End)

  trait Tree:
  
    /***
      * @return The number of leaves of this Tree
      */
    def leavesCount: Int = ???

  /***
    * @return A List containing all values from the leaves of this Tree
    */
    def leavesList: List[Char] = ???

    /***
      * @return A List containing all values from the nodes (except leaves) of this Tree
      */
    def nodesList: List[Char] = ???

    /***
      * @param level The wanted level of nodes (root is defined at level 1)
      * @return A list containing all values from nodes at a given level of this Tree
      */
    def valuesAtLevel(l: Int): List[Char] = ???
    