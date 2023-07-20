package lectures.part1basics

object StringOps extends App {

  val aString: String = "Learning Scala!"

  // Return character at index n
  println(aString.charAt(2))
  // Return the string between index n and m
  println(aString.substring(9, 14))
  // Split a string using a pattern into an array
  println(aString.split(" ").toList)
  // Return boolean if string starts with argument
  println(aString.startsWith("Learning"))
  // Replace a value for another
  println(aString.replace(" ","_"))
  // Return all lower case string, () can be omitted if no arguments
  println(aString.toLowerCase)
  // Return the length of the string, () can be omitted if no arguments
  println(aString.length)
  //

  val aNumberString = "2"
  // transform a string number to integer
  val aNumber = aNumberString.toInt
  // prepend and append values to string
  println('a' +: aNumberString :+ 'z')
  // reverse a string
  println(aString.reverse)
  // take n characters from the string
  println(aString.take(2))

  // Scala-specific: String interpolators

  // S-interpolators
  val name = "David"
  val age = 12
  val greeting = s"Hello, my name is $name%s and I'm $age years old"
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I'll be turning ${age + 1} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  // %n.mf where n is minimum characters and m is number of decimals
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth)

  // raw-interpolator
  println(raw"This is a \n newline") // ignore escaped characters
  val escaped = "This is a \n newline"
  println(raw"$escaped") // it doesn't work like this
}
