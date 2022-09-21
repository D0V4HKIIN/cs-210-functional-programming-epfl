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
            return 1;
        }
        return pascal(c - 1, r - 1) + pascal(c, r - 1);
    }

    /** Exercise 2
      */
    def balance(chars: List[Char]): Boolean = {
        def count_balance(chars: List[Char], parentheses: Int): Boolean = {
            if (parentheses < 0) {
                return false;
            }
            if (chars.isEmpty)
                return parentheses == 0;

            if (chars.head == '(') {
                return count_balance(chars.tail, parentheses + 1)
            } else if (chars.head == ')') {
                return count_balance(chars.tail, parentheses - 1)
            }

            if (parentheses < 0)
                return false;

            return count_balance(chars.tail, parentheses)
        }
        return count_balance(chars, 0);
    }

    /** Exercise 3
      */
    def countChange(money: Int, coins: List[Int]): Int = {
        if (money < 0 || coins.isEmpty) {
            return 0;
        } else if (money == 0) {
            return 1;
        }
        return countChange(money - coins.head, coins) +
            countChange(money, coins.tail);
    }
