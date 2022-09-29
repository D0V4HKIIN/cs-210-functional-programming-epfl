/* Copyright 2022 EPFL, Lausanne */

package e8q1

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E8Q1Suite extends munit.FunSuite:

  import E8Q1._
  import E8Q1.{given Eq[?]}
  import E8Q1SuiteIO._

  extension (t: Tests) 
    def title: String =
      t match 
        case EqListWorksOnSimpleCase(_, _, _, descr, pts) =>
          s"EqList works for $descr ($pts pts)"
        case EqTripleWorksOnSimpleCase(_, _, _, descr, pts) =>
          s"EqTriple works for $descr ($pts pts)"
        case EqPersonWorksOnSimpleCase(_, _, _, descr, pts) =>
          s"EqPerson works for $descr ($pts pts)"

    def msg: String =
      t match 
        case EqListWorksOnSimpleCase(_, _, _, descr, _) =>
          s"Wrong result for EqList when $descr"
        case EqTripleWorksOnSimpleCase(_, _, _, descr, _) =>
          s"Wrong result for EqTriple when $descr"
        case EqPersonWorksOnSimpleCase(_, _, _, descr, _) =>
          s"Wrong result for EqPerson when $descr"

    def execute: Unit =
      t match 
        case l: EqListWorksOnSimpleCase =>
          assertEquals(l.arg1.toList == l.arg2.toList, l.exp, t.msg)
        case tr: EqTripleWorksOnSimpleCase =>
          assertEquals(tr.arg1 == tr.arg2, tr.exp, tr.msg)
        case p: EqPersonWorksOnSimpleCase =>
          val p1 = Person(p.arg1._1, p.arg1._2, p.arg1._3.toList)
          val p2 = Person(p.arg2._1, p.arg2._2, p.arg2._3.toList)
          assertEquals(p1 == p2, p.exp, p.msg)

  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
