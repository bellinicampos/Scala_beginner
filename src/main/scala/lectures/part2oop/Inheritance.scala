package lectures.part2oop

object Inheritance extends App {
  /**
   * Scala modifiers are:
   * - private = can only be used within the class
   * - protected = can be extended within sub-classes
   * - no modifier = same as public
   */
  class Animal {
    val creatureType = "wild"
    def eats: Unit = println("nom nom nom")
  }
  class Cat extends Animal {
    def crunch: Unit = {
      eats
      println("crunch crunch")
    }
  }
  val cat = new Cat
  cat.crunch

  // constructor v1
  class Person1(name: String, age: Int)
  class Adult1(name: String, age: Int, idCard: String) extends Person1(name, age)

  // constructor v2
  class Person2(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult2(name: String, age: Int, idCard: String) extends Person2(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eats: Unit = println("crunch crunch")
  }
  val dog = new Dog("K9")
  dog.eats
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eats

  // overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1 - use final on member
  // 2 - use final on the entire class
  // 3- seal the class = extends classes in THIS FILE, prevent extension in other files


}
