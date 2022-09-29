/* Copyright 2022 EPFL, Lausanne */

package s8

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S8Suite extends munit.FunSuite:

  import S8._
  import S8SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case DuplicateNWorksOnSimpleCase(ls, n, _, pts) =>
          s"Duplicate $n times a list of size ${ls.length} ($pts pts)"

    def msg: String =
      t match
        case DuplicateNWorksOnSimpleCase(ls, n, _, _) =>
          s"Wrong result when duplicate $n times a list of size ${ls.length} "

    def execute: Unit =
      t match
        case d: DuplicateNWorksOnSimpleCase =>
          assertEquals(duplicateN(d.ls.toList, d.n), d.exp.toList, d.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
