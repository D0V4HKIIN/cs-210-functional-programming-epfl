/* Copyright 2021 EPFL, Lausanne */
/* Author: Nicolas Matekalo */

package e4q2

object E4Q2 {

  abstract class Expr
  case class Number(x: Int) extends Expr
  case class Var(name: String) extends Expr
  case class Sum(e1: Expr, e2: Expr) extends Expr
  case class Prod(e1: Expr, e2: Expr) extends Expr

  /**
    *
    * @param expr The expression to derive
    * @param v The variable of derivation
    * @return The partial derivative of `expr` with respect to the variable `v`
    */
  def deriv(expr: Expr, v: String): Expr = ???

}
