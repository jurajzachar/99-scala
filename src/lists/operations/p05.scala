package lists.operations

object p05 {
  println("Reverse a list")                       
  /*
	 * scala> reverse(List(1, 1, 2, 3, 5, 8))
	 * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
	 */

  val l = List(1, 1, 2, 3, 5, 8)                  
  
  def reverse(x: List[Any]): List[Any] = {
  	def wrapper(n: List[Any], k: List[Any]): List[Any] = {
  		(n, k) match {
  			case (_, Nil) => n
  			case (_, x :: Nil) => x :: n
  			case (_, x :: xs) => wrapper(x :: n, xs)
  		}
  	}
  	wrapper(Nil, x)
  }                                               
  
  reverse(l)                                      
}