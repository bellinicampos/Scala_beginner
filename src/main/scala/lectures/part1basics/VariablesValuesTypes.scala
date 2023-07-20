package lectures.part1basics

object VariablesValuesTypes extends App {

  // vals are IMMUTABLE!! it can't be reassigned
  val x: Int = 42
  // x = 39 is not possible
  println(x)

  // type of vals are optional, compiler can infer types
  val y = 42
  println(y)

  val aString: String = "Hello, this is a string";

  val aBoolean: Boolean = false
  val anotherBoolean: Boolean = true

  val aChar: Char = 'a'
  val anInt: Int = 32
  val aShort: Short = 23155
  val aLong: Long = 93423958429324L
  val aFloat: Float = 2.454f
  val aDouble: Double = 3.14

  // Variables can be reassigned
  var aVariable: Int = 4
  aVariable = 5 // side effects
  
}
