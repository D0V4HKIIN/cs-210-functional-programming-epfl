/* Copyright 2022 EPFL, Lausanne */

package s17

object S17:

  enum Tree[T]:
    case Empty[T](leq: (T, T) => Boolean) extends Tree[T]
    case Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T]

    /***
      * @param t The element to add to this Tree
      * @return A copy of this Tree with the element `t` added
      */
    def add(t: T): Tree[T] = ???
      //Add here your implementation from the previous exercise

    
    def colInOrRec(acc: List[T]): List[T] = ???
      
    def colPoOrRec(acc: List[T]): List[T] = ???

    def colPreOrRec(acc: List[T]): List[T] = ???

    /***
      * @return Values from this Tree collected in an "in order" walk
      */
    def collectInOrder: List[T] =
      colInOrRec(Nil)

    /***
      * @return Values from this Tree collected in a "pre order" walk
      */
    def collectPreOrder: List[T] =
      colPreOrRec(Nil)

    /***
      * @return Values from this Tree collected in a "post order" walk
      */
    def collectPostOrder: List[T] =
      colPoOrRec(Nil)



    /** Applies a binary operator to a start value and all elements of this binary tree,
    *  going in order
    *
    *  @param   z    the start value.
    *  @param   op   the binary operator.
    *  @tparam  U    the result type of the binary operator.
    *  @return  the result of applying op consecutively to : 
                the previous op result (or the start value z at beginning) 
                and one element of this Tree selected in an in order walk
    */
    def foldInOrder[U](z: U)(op: (U, T) => U): U = ???
    
    /** Applies a binary operator to a start value and all elements of this binary tree,
    *  going post order
    *
    *  @param   z    the start value.
    *  @param   op   the binary operator.
    *  @tparam  U    the result type of the binary operator.
    *  @return  the result of applying op consecutively to : 
                the previous op result (or the start value z at beginning) 
                and one element of this Tree selected in a post order walk
    */
    def foldPostOrder[U](z: U)(op: (U, T) => U): U = ???

    /** Applies a binary operator to a start value and all elements of this binary tree,
    *  going pre order
    *
    *  @param   z    the start value.
    *  @param   op   the binary operator.
    *  @tparam  U    the result type of the binary operator.
    *  @return  the result of applying op consecutively to : 
                the previous op result (or the start value z at beginning) 
                and one element of this Tree selected in a pre order walk
    */
 
    def foldPreOrder[U](z: U)(op: (U, T) => U): U = ???
