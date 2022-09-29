/* Copyright 2022 EPFL, Lausanne */

package s21

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S21Suite extends munit.FunSuite:

  import S21._
  import S21SuiteIO._

  extension (t: Tests)
    def title: String =
      t match
        case NotWorks(a, exp, pts) =>
          s"negation of $a ($pts pts)"
        case AndWorks(a, b, exp, pts) =>
          s"$a or $b ($pts pts)"
        case OrWorks(a, b, exp, pts) =>
          s"$a and $b ($pts pts)"
        case EquWorks(a, b, exp, pts) =>
          s"$a equals $b ($pts pts)"
        case XorWorks(a, b, exp, pts) =>
          s"$a xor $b ($pts pts)"
        case NandWorks(a, b, exp, pts) =>
          s"$a nand $b ($pts pts)"
        case ImplWorks(a, b, exp, pts) =>
          s"$a implies $b ($pts pts)"
      
    def msg: String =
      t match
        case NotWorks(a, exp, pts) =>
          s"negation of $a is wrong"
        case AndWorks(a, b, exp, pts) =>
          s"$a or $b is wrong"
        case OrWorks(a, b, exp, pts) =>
          s"$a and $b is wrong"
        case EquWorks(a, b, exp, pts) =>
          s"$a equals $b is wrong"
        case XorWorks(a, b, exp, pts) =>
          s"$a xor $b is wrong"
        case NandWorks(a, b, exp, pts) =>
          s"$a nand $b is wrong"
        case ImplWorks(a, b, exp, pts) =>
          s"$a implies $b is wrong"

    def execute: Unit =
      t match
        case n: NotWorks =>
          assertEquals(not (n.a), n.exp, n.msg)
        case a: AndWorks =>
          assertEquals(a.a and a.b, a.exp, a.msg)
        case o: OrWorks =>
          assertEquals(o.a or o.b, o.exp, o.msg)
        case e: EquWorks =>
          assertEquals(e.a equ e.b, e.exp, e.msg)
        case x: XorWorks =>
          assertEquals(x.a xor x.b, x.exp, x.msg)
        case na: NandWorks =>
          assertEquals(na.a nand na.b, na.exp, na.msg)
        case i: ImplWorks =>
          assertEquals(i.a impl i.b, i.exp, i.msg)
      
  
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")