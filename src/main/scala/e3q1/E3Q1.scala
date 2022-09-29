/* Copyright 2022 EPFL, Lausanne */

package e3q1

object E3Q1:

  /**
    * The less-than-or-equal operator
    */
  val intLeq: (Int, Int) => Boolean = (x, y) => x <= y

  /**
   * The equal-to operator using `intLeq`
   */
  val intEq: (Int, Int) => Boolean = ???

  /**
   * The striclty-less-than operator using `intLeq`
   */
  val intLess: (Int, Int) => Boolean = ???
