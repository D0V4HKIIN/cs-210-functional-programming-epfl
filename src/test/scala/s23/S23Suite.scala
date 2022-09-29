/* Copyright 2022 EPFL, Lausanne */

package s23

/**
 * To run this test suite, start "sbt" then run the "test" command.
 */
class S23Suite extends munit.FunSuite:

  import S23._
  import S23SuiteIO._

  extension (t: Tests)
    def title: String =
      t match 
        case CanBuyWorks(n, c, e, prods, exp, descr, pts) =>
          s"$descr ($pts pts)" 
        case CanBuyThrowsException(n, c, e, prods, descr, pts) =>
          s"$descr ($pts pts)"
    def msg: String =
      t match 
        case CanBuyWorks(n, c, e, prods, exp, descr, pts) =>
          s"Wrong result for : $descr" 
        case CanBuyThrowsException(n, c, e, prods, descr, pts) =>
          s"$descr"
    def execute: Unit =
      t match 
        case c: CanBuyWorks => 
          assertEquals(canBuy(c.n, c.c, c.e, c.prods.toList), c.exp, c.msg)
        case e: CanBuyThrowsException =>
          intercept[IllegalArgumentException] {
            canBuy(e.n, e.c, e.e, e.prods.toList)
          }
  
  allTests.foreach(t =>
    test(t.title) { t.execute }
  )

  override val munitTimeout = scala.concurrent.duration.Duration(1, "s")