/* Copyright 2022 EPFL, Lausanne */

package e1q4

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q4Suite extends munit.FunSuite:

  import E1Q4._
  import E1Q4SuiteIO._

    extension (t: Tests)

      def msg: String = 
        t match
          case ExceptionIsThrown(arg, pts) =>
            s"An exception should have been thrown for fibonacci of $arg"
          case SimpleCaseWorks(arg, exp, pts) => 
            s"Wrong value for $arg as argument"

      def title: String =  
        t match 
          case ExceptionIsThrown(arg, pts) => 
            s"Exception is thrown when fibonacci of $arg ($pts pts)"
          case SimpleCaseWorks(arg, exp, pts) => 
            s"Fibonacci of $arg ($pts pts)"
          
      def execute: Unit =
        t match 
          case e: ExceptionIsThrown =>
            intercept[IllegalArgumentException] {
              fibonacci(e.arg)
            }
          case s: SimpleCaseWorks =>
            assertEquals(fibonacci(s.arg), s.exp, s.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")