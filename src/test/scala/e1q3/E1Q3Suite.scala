/* Copyright 2022 EPFL, Lausanne */

package e1q3

import scala.concurrent.duration.Duration.apply
import java.util.concurrent.TimeUnit

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E1Q3Suite extends munit.FunSuite:

  import E1Q3._
  import scala.concurrent._
  import ExecutionContext.Implicits.global
  import scala.language.postfixOps
  import E1Q3SuiteIO._


  extension (t: Tests) 

    def msg: String = 
      t match    
        case e: ExceptionIsThrown => 
          val (b, exp) = e.arg
          s"An exception should have been thrown for $b at the power of $exp"
        case s: SimpleCaseWorks =>
          val exp = s.arg._2
          s"Fail with an exponent of $exp"

    def title: String = 
      t match 
        case ExceptionIsThrown(arg, pts) =>
          val (b, exp) = arg
          s"Exception is thrown when $b at the power of $exp ($pts pts)"
        case SimpleCaseWorks(arg, exp, pts) =>
          val (b, exp) = arg 
          s"Case $b to the power of $exp ($pts pts)"
    
    def execute: Unit = 
      t match 
        case e: ExceptionIsThrown =>
          intercept[IllegalArgumentException] {
            fastExp(e.arg._1, e.arg._2)
          }
        case s: SimpleCaseWorks =>
          assertEquals(fastExp(s.arg._1, s.arg._2), s.exp, s.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
