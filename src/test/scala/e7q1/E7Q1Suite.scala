/* Copyright 2022 EPFL, Lausanne */

package e7q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E7Q1Suite extends munit.FunSuite:

  import E7Q1._
  import E7Q1SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case NextLineWorksOnSimpleCase(_, _, descr, pts) =>
          s"NextLine of $descr ($pts pts)"
        case FunSeqWorksOnSimpleCase(i, _, pts) =>
          s"Element at position : $i of funSeq ($pts pts)"
      
    def msg: String =
      t match
        case NextLineWorksOnSimpleCase(_, _, descr, _) =>
          s"Wrong result for nextLine"
        case FunSeqWorksOnSimpleCase(i, _, _) =>
          s"Wrong result for position $i of funSeq"

    def execute: Unit =
      t match
        case n: NextLineWorksOnSimpleCase =>
          assertEquals(nextLine(n.arg.toList), n.exp.toList, n.msg)
        case f: FunSeqWorksOnSimpleCase =>
          assertEquals(funSeq(f.index), f.exp.toList, f.msg)      


  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
