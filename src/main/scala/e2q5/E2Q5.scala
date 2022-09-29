/* Copyright 2022 EPFL, Lausanne */

package e2q5

import annotation.tailrec

object E2Q5:

/**
  * 
  *
  * @param a An integer
  * @param b An integer
  * @param f A function
  * @return The sum of `f(i)` where `i` ranges from `a` to `b` 
  */
  def sum(a: Int, b: Int)(f: Int => Int): Int = ???

/**
  * 
  *
  * @param c An integer
  * @return A function that takes an integer `x` as argument and returns `(x - c)²`
  */
  def quadratic(c: Int): Int => Int = ???

/**
  * 
  *
  * @param a An integer
  * @param b An integer
  * @return The sum of `(i - 3)²` where `i` ranges from `a` to `b - 1`
  */
  def quad3Integrate(a: Int, b: Int): Int = ???
