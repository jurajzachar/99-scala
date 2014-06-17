package lists.operations

object p04 {
  println("Find the number of elements of a list.")
                                                  
  /*
  * scala> length(List(1, 1, 2, 3, 5, 8))
	* res0: Int = 6
  */
  
  val l = List(1, 1, 2, 3, 5, 8)                  
  
  def length(x: Iterable[Any]): Int = {
  	def wrapper(s: Int, x: Iterable[Any]): Int = x match {
  		case Nil => 0
  		case x :: Nil => s
  		case x :: xs => wrapper(s+1, xs)
  	}
  	wrapper(1, x)
  }                                               
  
  length(l)                                       
}