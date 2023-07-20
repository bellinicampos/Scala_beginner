package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

//  @tailrec
  def factorial(n: Int): Int =
    if (n<=1) 1
    else n * factorial(n-1) // ERROR: not tail recursive

  println(factorial(6))

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x-1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factorialHelper(n, 1)

  }

  println(anotherFactorial(6))

  // WHEN YOU NEED LOOPS, USE _TAIL_RECURSION

  /**
   * 1) Concatenate a string n times
   * 2) isPrime function tail recursive
   * 3) Fibonacci function, tail recursive
   */

  // 1
  @tailrec
  def concatanateString(aString: String, n: Int, acc: String): String =
    if (n <= 0) acc
    else concatanateString(aString, n-1, aString + acc)
  println(concatanateString("olar ", 4, ""))

  // 2
  def primeNumber(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeUntil(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeUntil(n / 2, true)
  }

  println(primeNumber(6))

  // 3
  def fibonacciByIndexFunction(n: Int): Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, beforeLast: Int): Int =
      if (i >= n) last
      else fiboTailrec(i + 1, last + beforeLast, last)

    if (n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }

  println(fibonacciByIndexFunction(8))

}

