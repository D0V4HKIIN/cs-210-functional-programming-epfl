/* Copyright 2022 EPFL, Lausanne */

package e3q5

object E3Q5:

  trait Tree[T]:
    def add(t: T): Tree[T]

    // Paste your solution from previous questions
    def toList: List[T] = ???
  
  case class EmptyTree[T](leq: (T, T) => Boolean) extends Tree[T]:
    // Paste your solution from previous questions
    def add(t: T): Tree[T] = ???
  
  case class Node[T](left: Tree[T], elem: T, right: Tree[T], leq: (T, T) => Boolean) extends Tree[T]:
    // Paste your solution from previous questions
    def add(t: T): Tree[T] = ???
  

    /**
      *
      * @param leq The less-or-equal-than operator
      * @param ls A list of integers
      * @return The sorted version of `ls`
      */
  def sortedList[T](leq: (T, T) => Boolean, ls: List[T]): List[T] = ???

