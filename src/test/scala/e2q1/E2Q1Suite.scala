/* Copyright 2022 EPFL, Lausanne */

package e2q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q1Suite extends munit.FunSuite:

  import E2Q1._
  import E2Q1SuiteIO._

  extension (t: Tests)
          
    def title: String = 
      t match
        case Identity(args, exp, pts) =>
          val fname = t.fname
          s"Flip an $fname function with $args as argument ($pts pts)"
        case Substraction(args, exp, pts) =>
          fill_title(args, pts, t.fname)
        case Multiplication(args, exp, pts) =>
          fill_title(args, pts, t.fname)
        case Division(args, exp, pts) =>
          fill_title(args, pts, t.fname)
        case Comparison(args, exp, pts) =>
          fill_title(args, pts, t.fname)

    def msg: String =
      t match
        case Identity(args, exp, pts) =>
          val fname = t.fname
          s"Incorrect value for an $fname"
        case Substraction(args, exp, pts) =>
          fill_msg(t.fname)
        case Multiplication(args, exp, pts) =>
          fill_msg(t.fname)
        case Division(args, exp, pts) =>
          fill_msg(t.fname)
        case Comparison(args, exp, pts) =>
          fill_msg(t.fname)
        
    def execute: Unit =
      t match
        case i: Identity =>
          fill_assert(i.f, i.args, i.exp, i.msg)
        case s: Substraction =>
          fill_assert(s.f, s.args, s.exp, s.msg)
        case m: Multiplication => 
          fill_assert(m.f, m.args, m.exp, m.msg)
        case d: Division =>
          fill_assert(d.f, d.args, d.exp, d.msg)
        case c: Comparison =>
          fill_assert(c.f, c.args, c.exp, c.msg)

  def fill_msg(fname: String): String =
    s"Incorrect value for a $fname"
  
  def fill_title(args: (Double, Int), pts: Int, fname: String): String =
    s"Flip a $fname function with $args as argument ($pts pts)"

  def fill_assert(f: (i: Int, d: Double) => Int, args: (Double, Int), exp: Int, msg: String): Unit =
    assertEquals(flip(f)(args._1, args._2), exp, msg)

  allTests.foreach(t => 
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
