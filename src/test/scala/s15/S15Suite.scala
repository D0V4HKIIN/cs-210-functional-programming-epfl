/* Copyright 2022 EPFL, Lausanne */

package s15

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S15Suite extends munit.FunSuite:

  import S15._
  import S15SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case IsSymmetricWorksOnSimpleTree(_, _, descr, pts) =>
          s"Symmetry of $descr ($pts pts)"
    
    def msg: String =
      t match
        case IsSymmetricWorksOnSimpleTree(_, _, descr, _) =>
          s"Wrong result for $descr"
    
    def execute: Unit =
      t match
        case s: IsSymmetricWorksOnSimpleTree =>
          assertEquals(isSymmetric(s.arg), s.exp, s.msg)
      
  
  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")