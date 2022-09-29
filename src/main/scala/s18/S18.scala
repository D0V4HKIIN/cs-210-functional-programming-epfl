/* Copyright 2022 EPFL, Lausanne */

package s18

object S18:

  enum Tree[T]:
    case Empty[T](leq: (T, T) => Boolean) extends Tree[T]
    case Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T]


    /***
      * @param t The element to add to this Tree
      * @return A copy of this Tree with the element `t` added
      */
    def add(t: T): Tree[T] = ???
      //Add here your implementation from the previous exercise

    /***
      * @return The height of this Tree
      */
    def height: Int = ???

    /***
      * @return Whether this Tree is balanced or not
      */
    def isBalanced: Boolean = ???

    /***
      * @return A Tree with same elements of this but with a balanced skeleton
      */
    def balanced: Tree[T] = ???
