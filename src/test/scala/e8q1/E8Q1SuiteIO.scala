/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e8q1

object E8Q1SuiteIO:

  sealed abstract class Tests
  case class EqListWorksOnSimpleCase(arg1: Array[Int], arg2: Array[Int], exp: Boolean, descr: String, points: Int) extends Tests
  case class EqTripleWorksOnSimpleCase(arg1: (Int, String, Int), arg2: (Int, String, Int), exp: Boolean, descr: String, points: Int) extends Tests
  case class EqPersonWorksOnSimpleCase(arg1: (String, Int, Array[String]), arg2: (String, Int, Array[String]), exp: Boolean, descr: String, points: Int) extends Tests

  val list1: Array[Int] = Array(1, 2, 3)
  val list2: Array[Int] = Array(4, 5, 6)
  val triple1: (Int, String, Int) = (3, "allSafe", 655)
  val triple2: (Int, String, Int) = (5, "fsociety", 9)
  val person1: (String, Int, Array[String]) = ("Eliott", 28, Array("Tyrell, Darlene"))
  val person2: (String, Int, Array[String]) = ("Darlene", 25, Array("Eliott, Cisco"))

  val allTests: Array[Tests] =
    Array(
      EqListWorksOnSimpleCase(Array[Int](), Array[Int](), true, "a nil equality", 10),
      EqListWorksOnSimpleCase(list1, Array[Int](), false, "a nil comparison", 10),
      EqListWorksOnSimpleCase(list1, list1, true, "a same list", 10),
      EqListWorksOnSimpleCase(list1, list2, false, "a different list", 10),

      EqTripleWorksOnSimpleCase(triple1, triple1, true, "a same triple", 10),
      EqTripleWorksOnSimpleCase(triple1, triple2, false, "a different triple", 10),

      EqPersonWorksOnSimpleCase(person1, person1, true, "a same person", 10),
      EqPersonWorksOnSimpleCase(person1, person2, false, "a different person", 10)
    )