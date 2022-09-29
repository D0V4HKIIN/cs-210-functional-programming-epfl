/* Copyright 2022 EPFL, Lausanne */

package e2q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q2Suite extends munit.FunSuite:

  import E2Q2._
  import E2Q2SuiteIO._

  extension (t: Tests)
    def title: String =
      t match 
        case SimpleCaseId(arg, pts) =>
          s"Identity of $arg ($pts pts)"
        case SimpleCaseCompose(f, g, arg, exp, fname, pts) =>
          s"Composition of $fname ($pts pts)"
        case SimpleCaseRepeated(f, n, arg, exp, fname, pts) =>
          s"Repeat $n times : $fname ($pts pts)"
        case ExceptionIsThrownRepeated(f, n, pts) =>
          s"Exception is thrown when f applied a negative number of times ($pts pts)"

    def msg: String =
      t match 
        case SimpleCaseId(arg, pts) =>
          s"Wrong result with identity of $arg"
        case SimpleCaseCompose(f, g, arg, exp, fname, pts) =>
          s"Wrong result for composition of $fname"
        case SimpleCaseRepeated(f, n, arg, exp, fname, pts) =>
          s"Wrong result for a $n time repetition of $fname"
        case ExceptionIsThrownRepeated(f, n, pts) =>
          s"An exception should have been thrown when n is negative"

    def execute: Unit =
      t match
        case i: SimpleCaseId =>
          assertEquals(id(i.arg), i.arg, i.msg)
        case c: SimpleCaseCompose =>
          assertEquals(compose(c.f, c.g)(c.arg), c.exp, c.msg)
        case r: SimpleCaseRepeated =>
          assertEquals(repeated(r.f, r.n)(r.arg), r.exp, r.msg)
        case e: ExceptionIsThrownRepeated =>
          intercept[IllegalArgumentException] {
            repeated(e.f, e.n)
          }

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
