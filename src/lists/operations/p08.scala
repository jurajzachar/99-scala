package lists.operations

object p08 {

  println("Eliminate consecutive duplicates of list elements.")

  /* 
   * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
   */

  def compress(list: List[Symbol]): List[Symbol] = {
    list match {
      case Nil      => Nil
      case x :: Nil => List(x)
      case x :: xs  => list.head :: compress(list.dropWhile(x => list.head.equals(x)))

    }
  }

}