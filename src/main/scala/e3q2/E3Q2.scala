/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e3q2

object E3Q2 {

  trait Tree[T] {
    /**
      * The size of the tree using pattern matching
      */
      def size1: Int = ???
  
    /**
      * The size of the tree implemented in the subclasses
      */
    def size2: Int
  }
  case class EmptyTree[T](leq: (T, T) => Boolean) extends Tree[T] {

      def size2: Int = ???
    }
  case class Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T] {

      def size2: Int = ???
    }

}
