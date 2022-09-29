/* Copyright 2022 EPFL, Lausanne */

package s10

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S10Suite extends munit.FunSuite:

  import S10._
  import S10SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case UncompressWorksOnSimpleCase(_, exp, pts) =>
          s"Uncompress a list of size : ${exp.length} ($pts pts)"
        case UncompressedThrowsException(arg, pts) =>
          s"Exception is thrown for a list of size ${arg.length} ($pts pts)"

    def msg: String =
      t match
        case UncompressWorksOnSimpleCase(_, exp, _) =>
          s"Wrong result for a list of size : ${exp.length}"
        case UncompressedThrowsException(_, _) =>
          "An illegal argument exception should have been thrown"

    def execute: Unit =
      t match
        case u: UncompressWorksOnSimpleCase =>
          assertEquals(uncompress(u.arg.toList), u.exp.toList, u.msg)
        case e: UncompressedThrowsException =>
          intercept[IllegalArgumentException] {
            uncompress(e.arg.toList)
          }
      
  allTests.foreach(t => 
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
