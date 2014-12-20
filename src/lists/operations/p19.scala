package lists.operations

object p19 {

  println("(**) Rotate a list N places to the left.")

  /*
   * scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
	scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
   */

  // we use the existing implementation of split 
  import p17.split
  def rotate(n: Int, l: List[Any]): List[Any] = {
    split(n, l)._2 ++ split(n, l)._1
  }
}