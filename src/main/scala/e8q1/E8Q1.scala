/* Copyright 2022 EPFL, Lausanne */

package e8q1

object E8Q1:

  case class Person(name: String, age: Int, neighbours: List[String])

  trait Eq[T]:
    extension (x: T)
      def === (y: T): Boolean

  /**
    * Compare two lists
    */
  given EqList[T]: Eq[List[T]] with 
    extension (xs: List[T])
      def === (ys: List[T]): Boolean =
        ???
  //given EqList[T](using ???): Eq[List[T]] with

  /**
    * Compare two triples
    */
  given EqTriple[T, U, S]: Eq[(T, U, S)] with 
    extension (x: (T, U, S))
      def === (y: (T, U, S)): Boolean =
        ???
  //given EqTriple[T, U, S](using ???): Eq[(T, U, S)] with



  /**
    * Compare two persons
    */
  given EqPerson: Eq[Person] with 
    extension (a: Person)
      def === (b: Person) =
        ???
  //given EqPerson(using ???): Eq[Person] with ...
