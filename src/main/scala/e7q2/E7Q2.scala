
/* Copyright 2022 EPFL, Lausanne */

package e7q2

object E7Q2:
  /**
    * A lazy list of squares of integers ≥ 1
    */
  val squares: LazyList[Int] = ???

/**
  * A lazy list of all non-empty strings using the characters "0" and "1"
  */
  val codes: LazyList[String] = ???

/**
  * A lazy list of all possible non-empty palindromes of "0" and "1"
  */
  val palCodes: LazyList[String] = ???

/**
  * A simple example of otherCodes
  */
  val otherCodes: LazyList[String] = LazyList.from(1).map(_.toString())

/**
  * A lazy list that interleaves `palCodes` and `otherCodes` (beginning with `palCodes`)
  */
  val allCodes: LazyList[String] = ???
