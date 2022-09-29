/* Copyright 2022 EPFL, Lausanne */

package e7q2

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class E7Q2Suite extends munit.FunSuite:

  import E7Q2._
  import E7Q2SuiteIO._

  extension (t: Tests)

    def title: String =
      t match
        case SquareWorksOnSimpleCase(arg, exp, pts) =>
          s"Square of $arg ($pts pts)"

        case CodesWorksOnSimpleCase(arg, exp, pts) =>
          if exp then s"Codes contains : \"$arg\" ($pts pts)"
          else s"Codes doesn't contains : \"$arg\" ($pts pts)"

        case PalCodesWorksOnSimpleCase(arg, exp, pts) => 
          if exp then s"PalCodes contains : \"$arg\" ($pts pts)"
          else s"PalCodes doesn't contains : \"$arg\" ($pts pts)"

        case AllCodesWorksForPalCodes(arg, exp, pts) =>
          s"Element at index $arg of allCodes is in palCodes ($pts pts)"

        case AllCodesWorksForOtherCodes(arg, exp, pts) =>
          s"Element at index $arg of allCodes is in otherCodes ($pts pts)"

    def msg: String =
      s"Wrong result for ${t.title.dropRight(10)}"

    def execute: Unit =
      val list_size = 5000
      t match
        case s: SquareWorksOnSimpleCase =>
          assertEquals(squares(s.arg - 1), s.exp, s.msg)
        case c: CodesWorksOnSimpleCase =>
          assertEquals(codes.take(list_size).contains(c.arg), c.exp, c.msg)
        case p: PalCodesWorksOnSimpleCase => 
         assertEquals(palCodes.take(list_size).contains(p.arg), p.exp, p.msg)
        case ap: AllCodesWorksForPalCodes =>
          assertEquals(palCodes.take(list_size).contains(allCodes.take(list_size)(ap.index - 1)), ap.exp, ap.msg)
        case ao: AllCodesWorksForOtherCodes =>
          assertEquals(otherCodes.take(list_size).contains(allCodes.take(list_size)(ao.index - 1)), ao.exp, ao.msg)
    

  allTests.foreach(t =>
    test(t.title) { t.execute }  
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")