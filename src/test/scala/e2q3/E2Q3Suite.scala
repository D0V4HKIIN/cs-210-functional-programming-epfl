/* Copyright 2022 EPFL, Lausanne */

package e2q3

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E2Q3Suite extends munit.FunSuite:

  import E2Q3._
  import E2Q3SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case SimpleCaseWorks(f_uncur, f_cur, args, exp, fname, pts) =>
          s"$fname ($pts pts)"

    def title_cur: String =
      val str = t.title
      s"curry $str"

    def title_uncur: String =
      val str = t.title
      s"uncurry $str"

    def msg: String =
      t match
        case SimpleCaseWorks(_, _, args, _, fname, _) =>
          s"Wrong value for $fname with $args as arguments"
          
    def msg_uncur: String =
      val str = t.msg
      s"$str when uncurrying"

    def msg_cur: String =
      val str = t.msg
      s"$str when currying"

    def ex_cur: Unit =
      t match
        case s: SimpleCaseWorks =>
          assertEquals(curry2(s.f_uncur)(s.args._1)(s.args._2), s.exp, s.msg_cur)

    def ex_uncur: Unit =
      t match
        case s: SimpleCaseWorks =>
          assertEquals(uncurry2(s.f_cur)(s.args._1, s.args._2), s.exp, s.msg_uncur)

  allTests.foreach(t =>
    test(t.title_cur) { t.ex_cur }
    test(t.title_uncur) { t.ex_uncur }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")
