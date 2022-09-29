/* Copyright 2022 EPFL, Lausanne */

package e3q4

object E3Q4:

  trait Tree[T]:
    def add(t: T): Tree[T]

    /**
      * The sorted list representation for the tree
      */
    def toList: List[T] = ???
  
  case class EmptyTree[T](leq: (T, T) => Boolean) extends Tree[T]:
    // Paste your solution from previous question
    def add(t: T): Tree[T] = ???
  
  case class Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T]:
    // Paste your solution from previous question
    def add(t: T): Tree[T] = ???
    

