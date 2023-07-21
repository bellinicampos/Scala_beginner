package lectures.part2oop

object AbstractDataTypes extends App {

  // abstract
  abstract class Animal {
    val creatureType: String = "wild"
    def eats: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eats: Unit = println("crunch... crunch...")
  }

  // traits
  trait Carnivore {
    def eats(animal: Animal): Unit
    val preferedMeal: String = "fresh meat"
  }

  class Crocodile extends Animal with Carnivore {
    override val creatureType: String = "Croc"
    override def eats: Unit = println("nom nom nom")
    override def eats(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile

  croc eats dog

  // traits vs abstract classes
  // 1 - traits do not have constructors parameters
  // 2 - multiple traits can be inherited by the same class
  // 3 - traits = behavior, abstract class = "thing"

}
