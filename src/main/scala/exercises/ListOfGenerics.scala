package exercises

abstract class ListOfGenerics[+A] {
  /**
   * head = first element of this list
   * tail = remainder of the list
   * isEmpty = is this list empty
   * add(int) => new list with this element added
   * toString => a string representation of the list
   */
  def head: A
  def tail: ListOfGenerics[A]
  def isEmpty: Boolean
  def add[B >: A](n: B): ListOfGenerics[B]
  def printElements: String
  def stringfy: String = "[" + printElements + "]"
  def map[B](transformer: MyTransformer[A, B]): ListOfGenerics[B]
  def flatMap[B](transformer: MyTransformer[A, ListOfGenerics[B]]): ListOfGenerics[B]
  def filter(predicate: MyPredicate[A]): ListOfGenerics[A]
  // CONCATENATION
  def ++[B >: A](listing: ListOfGenerics[B]): ListOfGenerics[B]
}

case object EmptyList extends ListOfGenerics[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: Nothing = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): ListOfGenerics[B] = Const(element, EmptyList)
  def printElements: String = ""
  def map[B](transformer: MyTransformer[Nothing, B]): ListOfGenerics[B] = EmptyList
  def flatMap[B](transformer: MyTransformer[Nothing, ListOfGenerics[B]]): ListOfGenerics[B] = EmptyList
  def filter(predicate: MyPredicate[Nothing]): ListOfGenerics[Nothing] = EmptyList
  def ++[B >: Nothing] (listing: ListOfGenerics[B]): ListOfGenerics[B] = listing
}

case class Const[+A](element: A, lista: ListOfGenerics[A]) extends ListOfGenerics[A] {
  def head: A = element
  def tail: ListOfGenerics[A] = lista
  def isEmpty: Boolean = false
  def add[B >: A](newElement: B): ListOfGenerics[B] = new Const(newElement, this)
  def printElements: String =
    if (lista.isEmpty) "" + element
    else "" + element + " " + lista.printElements
  /**
   * HOW FILTER WORKS
   *
   * [1,2,3].filter(n % 2 == 0) =
   *    [2,3].filter(n % 2 == 0) =
   *    new Const(2, [3].filter(n % 2 == 0)) =
   *    new Const(2, EmptyList.filter(n % 2 == 0)) =
   *    new Const(2, EmptyList)
   */
  def filter(predicate: MyPredicate[A]): ListOfGenerics[A] =
    if (predicate.test(element)) new Const(element, lista.filter(predicate))
    else lista.filter(predicate)
  /**
   * HOW MAP WORKS
   *
   * [1,2,3].map(2*n)
   *  = new Const(2, [2,3].map(2*n))
   *  = new Const(2, new Const(4, [3].map(2*n)))
   *  = new Const(2, new Const(4, new Const(6, EmptyList.map(2*n))))
   *  = new Const(2, new Const(4, new Const(6, EmptyList)))
   */
  def map[B](transformer: MyTransformer[A, B]): ListOfGenerics[B] =
    new Const(transformer.transform(element), lista.map(transformer))
  /**
   * CONCATENATION (++)
   * [1,2] ++ [3,4,5]
   * = new Const(1, [2] ++ [3,4,5]
   * = new Const(1, new Const(2, EmptyList ++ [3,4,5])
   * = new Const(1, new Const(2, new Const(3, new Const(4, new Const(5)))))
   */
  def ++[B >: A](listing: ListOfGenerics[B]): ListOfGenerics[B] = new Const(element, lista ++ listing)
  /**
   * HOW FLATMAP WORKS
   * [1,2].flatMap(n => [n, n+1])
   * = [1,2] ++ [2].flatMap(n => [n, n+1])
   * = [1,2] ++ [2,3] ++ EmptyList.flatMap(n => [n, n+1])
   * = [1,2] ++ [2,3] ++ EmptyList
   * = [1,2,2,3]
   */
  def flatMap[B](transformer: MyTransformer[A, ListOfGenerics[B]]): ListOfGenerics[B] =
    transformer.transform(element) ++ lista.flatMap(transformer)
}

trait MyPredicate[-T] {
  def test(elementValue: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elementValue: A): B
}

object CriarLista extends App {
  val lista = new Const(1, new Const(2, new Const(3, EmptyList)))
  val listaClone = new Const(1, new Const(2, new Const(3, EmptyList)))
  val outraLista = new Const(4, new Const(5, EmptyList))
//  val lista = new Const("Hello", new Const("Scala", new Const("Nerds", EmptyList)))
  println(lista.head)
  println(lista.tail)
  println(lista.isEmpty)
  println(lista.printElements)
  println(lista.map(new MyTransformer[Int, Int] {
    override def transform(element: Int): Int = element * 2
  }).stringfy)
  println(lista.filter(new MyPredicate[Int] {
    override def test(element: Int): Boolean = element % 2 == 0
  }).stringfy)
  println((lista ++ outraLista).stringfy)
  println(lista.flatMap(new MyTransformer[Int, ListOfGenerics[Int]] {
    override def transform(element: Int): ListOfGenerics[Int] = new Const(element, new Const(element+1, EmptyList))
  }).stringfy)

  println(lista==listaClone)
}