/* Copyright 2022 EPFL, Lausanne */

package s1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S1Suite extends munit.FunSuite:

  import S1._
  import S1SuiteIO._

  extension (t: Tests)

    def nestedArrayToList(na: Array[Array[Int]]): List[List[Int]] =
      na.toList.map(a => a.toList)

    def title: String = 
      t match
        case TailsWorksOnSimpleCase(arg, _, pts) =>
          s"Tails works on an array of size ${arg.length} ($pts pts)"

    def msg: String = 
      t match
        case TailsWorksOnSimpleCase(arg, _, _) =>
          s"Wrong result for an array of size ${arg.length}"
      
    def execute: Unit = 
      t match 
        case t: TailsWorksOnSimpleCase =>
          assertEquals(tails(t.arg.toList), nestedArrayToList(t.exp), t.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
