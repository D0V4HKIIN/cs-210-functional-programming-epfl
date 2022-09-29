/* Copyright 2022 EPFL, Lausanne */

package e1q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */

class E1Q1Suite extends munit.FunSuite: 

  import E1Q1._
  import E1Q1SuiteIO._  

  extension (t: Tests)

    def msg: String = 
      t match
        case ExceptionIsThrown(arg, pts) => s"Exception is not thrown for factorial of $arg" 
        case SimpleCaseWorks(arg, exp, pts) => s"Factorial of $arg is wrong"

    def title: String =
      t match
        case ExceptionIsThrown(arg, pts) => s"Exception is thrown when factorial of $arg ($pts pts)"
        case SimpleCaseWorks(arg, exp, pts) => s"Factorial of $arg ($pts pts)"

    def execute: Unit =
      t match 
        case e: ExceptionIsThrown =>
          intercept[IllegalArgumentException] {
            factorial(e.arg)
          }
        case s: SimpleCaseWorks =>
          assertEquals(factorial(s.arg), s.exp, s.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")

