/* Copyright 2022 EPFL, Lausanne */

package e3q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q1Suite extends munit.FunSuite:

  import E3Q1._
  import E3Q1SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case SimpleEqualityWorks(x, y, _, pts) =>
          s"$x == $y ($pts pts)"
        case SimpleStrictInequalityWorks(x, y, _, pts) =>
          s"$x < $y ($pts pts)"
      
    def msg: String =
      t match
        case SimpleEqualityWorks(x, y, _, _) =>
          s"Wrong result for $x == $y"
        case SimpleStrictInequalityWorks(x, y, _, _) =>
          s"Wrong result for $x < $y"

    def execute: Unit =
      t match
        case e: SimpleEqualityWorks =>
          assertEquals(intEq(e.x, e.y), e.exp, e.msg)
        case i: SimpleStrictInequalityWorks =>
          assertEquals(intLess(i.x, i.y), i.exp, i.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
