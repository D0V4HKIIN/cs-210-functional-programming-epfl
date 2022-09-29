/* Copyright 2022 EPFL, Lausanne */

package e3q3

object E3Q3:

  trait Tree[T]:
    /**
      *
      * @param t The element to add to the tree
      * @return The new tree with the element `t` added
      */
    def add(t: T): Tree[T]
  
  case class EmptyTree[T](leq: (T, T) => Boolean) extends Tree[T]:

      def add(t: T): Tree[T] = ???
    
  case class Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T]:

      def add(t: T): Tree[T] = ???
    


