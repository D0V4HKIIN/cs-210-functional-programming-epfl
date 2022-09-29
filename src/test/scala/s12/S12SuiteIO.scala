/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s12

object S12SuiteIO:
  sealed abstract class Tests
  case class IsPrimeWorksOnSimpleCase(arg: Int, exp: Boolean, points: Int) extends Tests
  case class IsPrimeThrowsException(arg: Int, points: Int) extends Tests

  val allTests: Array[Tests] =
    Array(
      IsPrimeThrowsException(-23, 10),
      IsPrimeThrowsException(-1, 10),
      IsPrimeWorksOnSimpleCase(0, false, 10),
      IsPrimeWorksOnSimpleCase(1, false, 10),
      IsPrimeWorksOnSimpleCase(2, true, 10),
      IsPrimeWorksOnSimpleCase(3, true, 10),
      IsPrimeWorksOnSimpleCase(4, false, 10),
      IsPrimeWorksOnSimpleCase(5, true, 10),
      IsPrimeWorksOnSimpleCase(17, true, 10),
      IsPrimeWorksOnSimpleCase(19, true, 10),
      IsPrimeWorksOnSimpleCase(67, true, 10),
      IsPrimeWorksOnSimpleCase(71, true, 10),
      IsPrimeWorksOnSimpleCase(72, false, 10),
      IsPrimeWorksOnSimpleCase(73, true, 10),
      IsPrimeWorksOnSimpleCase(89, true, 10),
      IsPrimeWorksOnSimpleCase(88, false, 10),
      IsPrimeWorksOnSimpleCase(91, false, 10)
    )

