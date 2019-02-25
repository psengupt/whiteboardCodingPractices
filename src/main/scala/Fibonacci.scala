/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).



Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
*/

object Fibonacci {

  def fib(N: Int): Int = {
    N match {
      case 0 => 0
      case 1 => 1
      case x : Int => fib(x - 1) + fib(x-2)
    }
  }

  def main(args: Array[String]): Unit = {
    println(s"the fibonacci for 3 is: ${fib(3)}")
  }

}
