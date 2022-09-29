/* Copyright 2022 EPFL, Lausanne */

package s3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S3Suite extends munit.FunSuite:

  import S3._
  import S3SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case KthWorksOnSimpleCase(k, ls, _, pts) =>
          s"Kth works when k = $k for a list of size : ${ls.length} ($pts pts)"
        case KthThrowsException(k, ls, pts) =>
          s"Kth throws an Exception when k = $k and a list of size : ${ls.length} ($pts pts)"

    def msg: String =
      t match
        case KthWorksOnSimpleCase(k, ls, _, _) =>
          s"Wrong result for k = $k and a list of size : ${ls.length}"
        case KthThrowsException(k, ls, _) =>
          s"An Exception should have been thrown for a list of size : {ls.length}"

    def execute: Unit =
      t match
        case k: KthWorksOnSimpleCase =>
          assertEquals(kth(k.k, k.ls.toList), k.exp, k.msg)
        case e: KthThrowsException =>
          intercept[IllegalArgumentException] { 
            kth(e.k, e.ls.toList) 
          }

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")