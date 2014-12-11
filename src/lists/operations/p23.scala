package lists.operations

import scala.util.Random

object p23 {
  println("(**) Extract a given number of randomly selected elements from a list.")

  import p20.removeAt
  import p19.rotate
  
  def randomSelect(size: Int, l: List[Any]): List[Any] = {
    if (size > l.length) {
      throw new IllegalArgumentException("Number of extracted elements cannot " +
        "be greater than the length of the list")
    }
    size == 1 match {
      case true => List(l.head)
      case false => {
        val rand = new Random(System.nanoTime())
        val extracted = removeAt(rand.nextInt(l.length), l)
        extracted._2 :: randomSelect(size - 1, extracted._1) 
      }
    }
  }
}
