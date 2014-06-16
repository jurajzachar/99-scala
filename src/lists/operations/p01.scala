package lists.operations

object p01 {
  println("Find the last element of a list")      //> Find the last element of a list
  val l = List(1,2,3,4,5,8)                       //> l  : List[Int] = List(1, 2, 3, 4, 5, 8)
  
  /* solution */
  def last(x: List[Any]): Any = {
  	x match {
  		case x :: Nil => x
  		case x :: xs => last(xs)
  	}
  }                                               //> last: (x: List[Any])Any
  
  last(l)                                         //> res0: Any = 8
 
}