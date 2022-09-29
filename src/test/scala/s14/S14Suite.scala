/* Copyright 2022 EPFL, Lausanne */

package s14

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S14Suite extends munit.FunSuite:

  import S14._
  import S14SuiteIO._

  extension (t: Tests)
    def title: String = 
      t match
        case PrimeFactWorksOnSimpleCase(arg, _, pts) =>
          s"Prime factorization of $arg ($pts pts)"
        case PrimeFactThrowsException(arg, pts) =>
          s"Exception is thrown for $arg as argument ($pts pts)"
      
    def msg: String =
      t match
        case PrimeFactWorksOnSimpleCase(arg, _, pts) =>
          s"Wrong result for the prime factorization of $arg"
        case PrimeFactThrowsException(arg, pts) =>
          s"An exception should have been thrown for $arg as argument"

    def execute: Unit =
      t match
        case s: PrimeFactWorksOnSimpleCase =>
          assertEquals(primeFact(s.arg), s.exp.toMap, s.msg)

        case e: PrimeFactThrowsException =>
          intercept[IllegalArgumentException] {
            primeFact(e.arg)
          }
      
          
  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
