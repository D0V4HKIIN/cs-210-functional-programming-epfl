package recfun

object RecFun extends RecFunInterface:

    def main(args: Array[String]): Unit =
        println("Pascal's Triangle")
        for row <- 0 to 10 do
            for col <- 0 to row do print(s"${pascal(col, row)} ")
            println()

    /** Exercise 1
      */
    def pascal(c: Int, r: Int): Int = {
        if (c == 0 || r == 0 || c == r) {
            1
        } else
            pascal(c - 1, r - 1) + pascal(c, r - 1)
    }

    /** Exercise 2
      */
    def balance(chars: List[Char]): Boolean = {
        def count_balance(chars: List[Char], parentheses: Int): Boolean = {
            if (parentheses < 0) {
                false
            } else if (chars.isEmpty)
                parentheses == 0
            else if (chars.head == '(') {
                count_balance(chars.tail, parentheses + 1)
            } else if (chars.head == ')') {
                count_balance(chars.tail, parentheses - 1)
            } else if (parentheses < 0)
                false
            else count_balance(chars.tail, parentheses)
        }
        count_balance(chars, 0);
    }

    /** Exercise 3
      */
    def countChange(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.isEmpty) {
            0
        } else if (money == 0) {
            1
        } else
            countChange(money - coins.head, coins) +
                countChange(money, coins.tail);
    }
