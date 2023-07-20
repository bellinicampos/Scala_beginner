package lectures.part2oop

object OOBasics extends App {

//    val person = new Person("Pedro", 31)
//    println(person.age)
//
//    person.greet("Daniel")
//    person.greet2()
//
//    // constructor, not all parameters and fields (must be val or var)
//    class Person(name: String, val age: Int = 0) {
//      // body
//      val x = 2
//
//      println(1 + 3)
//
//      // method
//      def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
//
//      // overloading
//      def greet2(): Unit = println(s"My name is $name")
//
//      // overloading / multiple constructors
//      def this(name: String) = this(name, 0)
//      def this() = this("John Doe")

      /**
       * Novel and Writer class
       *
       * Writer: first name, surname, year
       * - method full name
       *
       * Novel: name, yearRelease, author
       * - method authorAge
       * - isWrittenBy(author)
       * - copy (new year of release) = new instance of Novel
       */

      class Novel(name: String, yearRelease: Int, author: Writer) {
        def authorAge = yearRelease - author.yearOfBirth // authorAge(): Int = yearRelease - author.yearOfBirth
        def isWrittenBy(author: Writer): Boolean = author == this.author
        def copy(newYear: Int): Novel = new Novel(name, newYear, author)
      }

      class Writer(firstName: String, surname: String, val yearOfBirth: Int) {
        def fullName = firstName + " " + surname // def fullName(): String = firstName = " " + surname
      }

      val writer: Writer = new Writer("Pedro", "Bellini", 31)

      val novel: Novel = new Novel("Livro 1", 2015, writer)
      println(novel.authorAge)
      println(novel.isWrittenBy(writer))
      println(novel.copy(2020))

      /**
       * Counter class
       * - receive an int value
       * - methord current count
       * - method increment/decrement => new Counter
       * - overload inc/dec to receive an ammount
       */

      class Counter(val count: Int = 0) {
        def increment = new Counter(count + 1) // immutability
        def decrement = new Counter(count - 1)

        def increment(n: Int): Counter = {
          if (n <= 0) this
          else increment.increment(n - 1)
        }
        def decrement(n: Int): Counter = {
          if (n <= 0) this
          else decrement.decrement(n - 1)
        }
        def print = println(count)
      }

      val counter: Counter = new Counter
      counter.increment.print
      counter.decrement(3).print
}
