package lists.operations

object p07 {

  println("Flatten a nested list structure.")
  
  /* 
   * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
   * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
   */

  def flatten(l: List[Any]): List[Any] = l match {
    case Nil => Nil
    case x :: xs => (x match {
      case x: List[Any] => flatten(x)
      case i            => List(i)
    }) ++ flatten(xs)
  }

}