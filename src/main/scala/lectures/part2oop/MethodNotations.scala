package lectures.part2oop
import scala.language.postfixOps

object MethodNotations extends App {

//  class Person(val name: String, favouriteMovie: String) {
//    def likes(movie: String): Boolean = favouriteMovie == movie
//    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
//    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
//    def unary_! : String = s"$name, what the heck?!"
//    def isAlive: Boolean = true
//    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
//  }

//  val mary = new Person("Mary", "Inception")
//  println(mary.likes("Inception"))
//  println(mary likes "Inception") // those are equivalent
//  // infix notation = operator notation (syntax sugar)
//
//  // "operators" in Scala
//  val tom = new Person("Tom", "Fight Club")
//  println(mary + tom)
//  println(mary.+(tom)) // those are equivalent
//
//  println(1 + 2)
//  println(1.+(2)) // those are equivalent
//
//  // ALL OPERATORS ARE METHODS
//  // Akka actors have ! ?
//
//  // prefix notation
//  val x = -1
//  val y = 1.unary_- // those are equivalent
//  // unary_ prefix only works with - + ~ !
//
//  println(!mary)
//  println(mary.unary_!)
//
//  // postfix notation - must import scala.language.postfixOps to use it
//  println(mary.isAlive)
//  println(mary isAlive) // those are equivalent
//
//  // apply
//  println(mary.apply())
//  println(mary()) // those are equivalent

  /**
   * 1. overload the + operator
   *    mary + "the rockstar" => new Person "Mary (the rockstar)"
   *
   * 2. Add an age to the Person class
   *    Add a unary + operator => new person with age + 1
   *    +mary => mary with the age incremeter
   *
   * 3. Add a "learns" method in the person class => "Mary learns Scala"
   *    Add a learnsScala method, calls learn method with "Scala" as argument
   *    Use it in postfix notation
   *
   * 4. Overloead the apply method
   *    mary.apply(2) => "Mary watched Inception 2 times"
   */

  class Person(val name: String, favouriteMovie: String, val age: Int) {
    def +(nickName: String): Person = new Person(s"$name, $nickName", favouriteMovie, age)
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def learns(subject: String): String = s"$name learns $subject"
    def learnsScala = this.learns("Scala")
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times"

  }

  val mary = new Person("Mary", "Inception", 30)
  println((mary + "The Conqueror").name)
  println((+mary).age)
  println(mary learns "Scala")
  println(mary learnsScala)
  println(mary.apply())
  println(mary())
  println(mary.apply(3))
  println(mary(3))


}
