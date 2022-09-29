/* Copyright 2022 EPFL, Lausanne */

package s16

object S16:

  import Tree._

  enum Tree[T]:
    case Empty[T](leq: (T, T) => Boolean) extends Tree[T]
    case Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T]

  
    /***
      * @param t The element to add to this Tree
      * @return A copy of this Tree with the element `t` added
      */
    def add(t: T): Tree[T] = ???
      //Add here your implementation from the previous exercise

    /**
      * Helper function for delete (don't need to manage the case when applied on an Empty Tree)
      * @return The less valued Node under this Node
      */
    def minimum: Node[T] = ???

    /**
      * @param t The element to delete from this Tree
      * @return A copy of this Tree without the element `t`
      */
    def delete(t: T): Tree[T] = ???

  def equ[T](e1: T, e2: T, leq: (T, T) => Boolean): Boolean =
      leq(e1, e2) && leq(e2, e1)