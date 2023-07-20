package lectures.part1basics

object Functions extends App {

  def aFunction(x: String, y: Int): String = {
    x + " " + y
  }
  println(aFunction("Hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  def aRecursiveFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRecursiveFunction(aString, n-1)
  }

  println(aRecursiveFunction("hello ", 4))

  // WHEN YOU NEED LOOPS, USE RECURSION!!!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  aFunctionWithSideEffects("Side effects")

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n*3)
  }

  println(aBigFunction(4))

  /**
   * 1. A greeting function (name, age) => "Hi, my name is $name and I'm $age years old"
   * 2. Factorial function 1 * 2 * ... * n
   * 3. A Fibonacci function
   * 4. Test if a number is prime
   */

  // 1
  def aGreetingFunction(name: String, age: Int): Unit = println(s"Hi, my name is $name and I'm $age years old.")
  aGreetingFunction("Pedro", 31)

  // 2
  def factorialFunction(n: Int): Int =
    if (n <= 1) 1
    else n * factorialFunction(n-1)

  println(factorialFunction(5))

  // 3

  val teste: Int = 7

  def fibonacciByIndexFunction(n: Int): Int =
    if (n <= 2) 1
    else fibonacciByIndexFunction(n-1) + fibonacciByIndexFunction(n-2)

  println(fibonacciByIndexFunction(teste))

  def fibonacciSumFunction(n: Int): Int =
    if (n == 1) 1
    else if (n == 2) 2
    else fibonacciByIndexFunction(n) + fibonacciSumFunction(n - 1)

  println(fibonacciSumFunction(teste))

  // 4
  def primeNumber(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n/2)
  }

  println(primeNumber(45))
  println(primeNumber(2003))
}
