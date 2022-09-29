/* Copyright 2022 EPFL, Lausanne */

package e2q2

object E2Q2:

/**
  * The identity function
  */
  val id: Int => Int = ???

/**
  *
  * @param f A function
  * @param g A function
  * @return The function that composes them, i.e., `f ∘ g`
  */
  def compose(f: Int => Int, g: Int => Int): Int => Int = ???

/**
  *
  * @param f A function
  * @param n An integer
  * @return The function that repeats `f` for `n` iterations
  */
  def repeated(f: Int => Int, n: Int): Int => Int = ???
