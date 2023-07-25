package exercises
import scala.language.postfixOps

abstract class Listinha {
  def head: Int
  def tail: Listinha
  def isEmpty: Boolean
  def add(newElement: Int): Listinha
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object ListinhaVazia extends Listinha {
  def head: Int = throw new NoSuchElementException()
  def tail: Listinha = throw new NoSuchElementException()
  def isEmpty = true
  def add(newElement: Int): Listinha = new ListinhaCheia(newElement, ListinhaVazia)
  def printElements: String = ""
}

class ListinhaCheia(firstElement: Int, remainder: Listinha) extends Listinha {
  def head: Int = firstElement
  def tail: Listinha = remainder
  def isEmpty = false
  def add(newElement: Int): Listinha = new ListinhaCheia(newElement, this)
  def printElements: String =
    if (remainder.isEmpty) "" + firstElement
    else "" + firstElement + " " + remainder.printElements
}

object Teste extends App {

  val list = new ListinhaCheia(1, new ListinhaCheia(2, new ListinhaCheia(3, ListinhaVazia)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.toString)

}