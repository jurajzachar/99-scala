package lists.operations

object p17 {

  println("(*) Split a list into two parts. The length of the first part is given. Use a Tuple for your result.")

  def split(size: Int, l: List[Any]): (List[Any], List[Any]) = {
    l match {
      case Nil => (Nil, l)
      case x :: xs => size > 0 match {
        case true => (x :: split(size - 1, xs)._1, split(size - 1, xs)._2)
        case false => (split(size, xs)._1, l)
      }
    }
  }
}