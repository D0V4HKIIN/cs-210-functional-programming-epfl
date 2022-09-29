/* Copyright 2022 EPFL, Lausanne */

package e2q5

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q5Suite extends munit.FunSuite:

  import E2Q5._
  import E2Q5SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case SimpleCaseSumF(f, a, b, exp, fname, pts) =>
          s"Sum of $fname from $a to $b ($pts pts)"
        case SimpleCaseQuadratic(c, arg, exp, pts) =>
          s"Quadratic with c = $c ($pts pts)"
        case SimpleCaseQuad3Integrate(a, b, exp, pts) =>
          val n = b - a
          s"Quad3Integrate for $n values ($pts pts)"
        case ExceptionOnSumF(f, a, b, pts) =>
          s"Exception for sum() applied between $a and $b ($pts pts)"
        case ExceptionOnQuad3Integrate(a, b, pts) =>
          s"Exception for Quad3Integrate between $a and $b ($pts pts)"

    def msg: String =
      t match
        case SimpleCaseSumF(f, a, b, exp, fname, pts) =>
          s"Wrong result for the sum of $fname between $a and $b"
        case SimpleCaseQuadratic(c, arg, exp, pts) =>
          s"Wrong result for the quadratic of $arg with c = $c"
        case SimpleCaseQuad3Integrate(a, b, exp, pts) =>
          s"Wrong result for quad3Integrate between $a and $b"
        case ExceptionOnSumF(f, a, b, pts) =>
          s"An Exception should have been thrown for a given wrong interval : [$a, $b]"
        case ExceptionOnQuad3Integrate(a, b, pts) =>
          s"An Exception should have been thrown for the wrong arguments : a = $a and b = $b"
    
    def execute: Unit =
      t match 
        case s: SimpleCaseSumF =>
          assertEquals(sum(s.a, s.b)(s.f), s.exp, s.msg)
        case q: SimpleCaseQuadratic =>
          assertEquals(quadratic(q.c)(q.arg), q.exp, q.msg)
        case q3: SimpleCaseQuad3Integrate =>
          assertEquals(quad3Integrate(q3.a, q3.b), q3.exp, q3.msg)
        case es: ExceptionOnSumF =>
          intercept[java.lang.IllegalArgumentException] {
            sum(es.a, es.b)(es.f)
          }
        case eq: ExceptionOnQuad3Integrate =>
          intercept[IllegalArgumentException] {
            quad3Integrate(eq.a, eq.b)
          }
  
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )
  
  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")

