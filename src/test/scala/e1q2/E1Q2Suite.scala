/* Copyright 2022 EPFL, Lausanne */

package e1q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q2Suite extends munit.FunSuite:

  import E1Q2._
  import E1Q2SuiteIO._

  extension (t: Tests)

    def msg: String = 
      t match 
        case s: SimpleCaseWorks => 
          val len = s.arg.length
          s"Wrong sum for an array of size : $len"

    def title: String = 
      t match 
        case SimpleCaseWorks(arg, exp, pts) => 
          val len = arg.length
          s"Sum of a list of size $len ($pts pts)"

    def execute: Unit =
      t match 
        case s: SimpleCaseWorks => 
          assertEquals(sumList(s.arg.toList), s.exp, s.msg)

  allTest.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
