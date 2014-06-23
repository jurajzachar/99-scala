package lists.operations

object p12 {

  println("Decode a run-length encoded list.")

  def fill(i: Int, e: Any): List[Any] = {
    i match {
      case 0 => Nil
      case 1 => e :: Nil
      case _ => e :: fill(i - 1, e)
    }
  }
  
  def decode(ls: List[(Int, Any)]): List[Any] = {
    (for (e <- ls) yield fill(e._1, e._2)) flatten
  }

}