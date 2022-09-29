/* Copyright 2022 EPFL, Lausanne */

package s11

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S11Suite extends munit.FunSuite:

  import S11._
  import S11SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case DropWorksOnSimpleCase(ls, n, exp, pts) =>
          s"Drop every $n element in a list of size ${ls.length} ($pts pts)"
        case DropThrowsException(_, n, pts) =>
          s"Exception is thrown when trying to drop $n elements ($pts pts)"

    def msg: String =
      t match
        case DropWorksOnSimpleCase(ls, n, exp, pts) =>
          s"Wrong result when dropping every $n element in a list of size ${ls.length}"
        case DropThrowsException(_, n, _) =>
          s"An Exception should have been thrown when trying to drop $n elements"

    def execute: Unit =
      t match
        case d: DropWorksOnSimpleCase =>
          assertEquals(drop(d.ls.toList, d.n), d.exp.toList, d.msg)
        case e: DropThrowsException =>
          intercept[IllegalArgumentException] {
            drop(e.ls.toList, e.n)
          }

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
