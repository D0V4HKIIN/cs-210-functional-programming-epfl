/* Copyright 2022 EPFL, Lausanne */

package e4q1

object E4Q1:

  /**
   *
   * The subtyping relation of each line in the table (`>:`, `<:` or `X`). Hence they are string values.
   * They are 
   */
  type Answer = String

  val lines: Array[Answer] = ???

  /*Exemple :
    Array(
      "<:", //first line (#0)
      ":>", //second line (#1)
      "X", // ...
      "X",
      "<:"
    )
  */

  assert(lines.length == 11, "The array must contains all answers ! (11 lines)")
