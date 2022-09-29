/* Copyright 2022 EPFL, Lausanne */

package e3q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E3Q2Suite extends munit.FunSuite:

  import E3Q2._
  import E3Q2SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case SizeWorks(_, exp, pts) =>
          s"Size of a tree of size $exp ($pts pts)"

    def msg: String =
      t match
        case SizeWorks(_, exp, _) =>
          s"Wrong result for a tree of size $exp"

    def execute1: Unit =
      t match
        case s: SizeWorks =>
          val msg = s.msg
          assertEquals(s.tree.size1, s.exp, s"size1 : $msg")
          
    def execute2: Unit =
      t match
        case s: SizeWorks =>
          val msg = s.msg
          assertEquals(s.tree.size2, s.exp, s"size2 : $msg")

  allTests.foreach(t =>
    val title = t.title
    test(s"size1 : $title") { t.execute1 }  
    test(s"size2 : $title") { t.execute2 }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
