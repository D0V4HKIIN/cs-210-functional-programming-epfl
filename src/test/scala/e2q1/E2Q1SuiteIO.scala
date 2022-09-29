/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package e2q1

//Double is not supported by Stainless, have to swap type with Real type
object E2Q1SuiteIO:
  sealed abstract class Tests:
    def f: (Int, Double) => Int
    def fname: String
    
  case class Identity(args: (Double, Int), exp: Int, points: Int) extends Tests:
    override def f = (i: Int, d: Double) => i 
    override def fname = "identity"
  
  case class Substraction(args: (Double, Int), exp: Int, points: Int) extends Tests:
    override def f = (i: Int, d: Double) => i - d.intValue
    override def fname = "substraction"

  case class Multiplication(args: (Double, Int), exp: Int, points: Int) extends Tests:
    override def f = (i: Int, d: Double) => i * d.intValue
    override def fname = "multiplication"
 
  case class Division(args: (Double, Int), exp: Int, points: Int) extends Tests:
    require(args._1 != 0)
    override def f = (i: Int, d: Double) => i / d.intValue
    override def fname = "division"
 
  case class Comparison(args: (Double, Int), exp: Int, points: Int) extends Tests:
    override def f = (i: Int, d: Double) => if i > d then i else d.intValue
    override def fname = "comparison"

  val allTests: Array[Tests] = 
    Array(
      Identity((3.5, 1), 1, 10),
      Identity((0.0, 1), 1, 10),
      Identity((1.0, 0), 0, 10),
      Substraction((4.5, 2), -2, 10),
      Substraction((2.0, 4), 2, 10),
      Substraction((1.5, 0), -1, 10),
      Multiplication((4.759, 8), 32, 10),
      Multiplication((3.0, 7), 21, 10),
      Multiplication((0.0, 7), 0, 10),
      Multiplication((4.26, 0), 0, 10),
      Multiplication((1.00, 6), 6, 10),
      Multiplication((4.00, 1), 4, 10),
      Division((1, 0), 0, 10),
      Division((10, 1), 0, 10),
      Division((1, 10), 10, 10),
      Comparison((150.1, 25), 150, 10),
      Comparison((25.1, 150), 150, 10),
      Comparison((25.0, 25), 25, 10)
    )