/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e2q3

object E2Q3 {

/**
  * 
  *
  * @param f A two-argument function
  * @return The curried version of `f`
  */
  def curry2(f: (Double, Int) => Boolean): Double => (Int => Boolean) = ???

/**
  * 
  *
  * @param f A curried function
  * @return The two-argument version of `f`
  */
  def uncurry2(f: Double => Int => Boolean): (Double, Int) => Boolean = ???

}
