package lectures.part1basics

import scala.annotation.tailrec

object DefaultArgs extends App {

  @tailrec
  def trFact(n: Int, acc: Int = 1): Int =
    if (n < 2) acc
    else trFact(n-1, n*acc)

  println(trFact(5))

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("Saving picture!")

  /**
   * 1. pass in every leading argument
   * 2. name the arguments
   */

  savePicture("bmp", 800, 600)



}
