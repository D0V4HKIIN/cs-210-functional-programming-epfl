/* Copyright 2022 EPFL, Lausanne */
/* Written in Pure Scala in order to be compatible for Stainless */
/* https://epfl-lara.github.io/stainless/purescala.html */

package s23

object S23SuiteIO:

  import S23._

  sealed abstract class Tests
  case class CanBuyWorks(n: Int, c: Int, e: Int, prods: Array[(Int, Int)], exp: Boolean, descr: String, points: Int) extends Tests
  case class CanBuyThrowsException(n: Int, c: Int, e: Int, prods: Array[(Int, Int)], descr: String, points: Int) extends Tests

  val arr4 = Array((1, 1), (1, 3), (5, 5), (4, 3))
  val arr8 = Array((8, 7), (6, 4), (3, 2), (7, 8), (20, 30), (12, 6), (15, 17), (18, 21))
  val arr8z = Array((0, 0), (6, 4), (3, 2), (7, 8), (20, 30), (12, 6), (15, 17), (18, 21))
  val arr7a = Array((6, 4), (3, 2), (7, 8), (20, 30), (12, 6), (15, 17), (18, 21))
  val arr7b = Array((8, 7), (6, 4), (3, 2), (7, 8), (20, 30), (12, 6), (15, 17))
  
  val allTests: Array[Tests] =
    Array(
      CanBuyThrowsException(4, 1, 1, Array((1, 1)), "Throws Exception when n is bigger than prods size", 10),
      CanBuyThrowsException(1, -1, 1, Array((1, 1)), "Throws Exception when c is negative", 10),
      CanBuyThrowsException(1, 1, -1, Array((1, 1)), "Throws Exception when e is negative", 10),
      CanBuyThrowsException(1, 1, -1, Array((-1, 1), (1, 2)), "Throws Exception when price of a product is negative", 10),
      CanBuyThrowsException(1, 1, -1, Array((1, 1), (1, -3)), "Throws Exception when calories of a product is negative", 10),
      CanBuyWorks(2, 2, 2, Array((1, 2), (2, 1)), false, "Not matching for two products in the shop", 10),
      CanBuyWorks(4, 5, 6, arr4, true, "Can buy two products", 10),
      CanBuyWorks(3, 2, 2, Array((1, 2), (2, 2), (2, 1)), true, "Can buy only one product", 10),
      CanBuyWorks(4, 6, 7, arr4, true, "Can buy three products", 10),
      CanBuyWorks(8, 25, 37, arr8, false, "Not matching for eight products in the shop", 10),
      CanBuyWorks(8, 81, 88, arr8z, true, "Can buy some products with a product counting for (0, 0)", 10),
      CanBuyWorks(8, 81, 88, arr8, true, "Can buy all products except of the first", 10),
      CanBuyWorks(8, 71, 74, arr8, true, "Can buy all products except of the last", 10),
      CanBuyWorks(7, 18, 21, arr7b, false, "Can't buy on a shop with seven products", 10),
      CanBuyWorks(8, 18, 21, arr8, true, "Can buy one product in shop with 8 products", 10),
      CanBuyWorks(7, 49, 60, arr7b, false, "Can't buy on an other shop with seven products", 10),
      CanBuyWorks(8, 49, 60, arr8, true, "Can buy half of the shop :)", 10),
      CanBuyWorks(8, 89, 95, arr8, true, "Buy all the shop !", 10),
    )