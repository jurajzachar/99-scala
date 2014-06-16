package lists.operations

object p03 {
  println("Find the Kth element of a list")       //> Find the Kth element of a list
	/*
	 * scala> nth(2, List(1, 1, 2, 3, 5, 8))
	 * res0: Int = 2
	 */
	 
	 val l = List(1, 1, 2, 3, 5, 8)           //> l  : List[Int] = List(1, 1, 2, 3, 5, 8)
	 
	 /* solution */
	 def nth(a: Int, x: Iterable[Any]): Any = {
	  	def get(n: Int, k: Int, x: Iterable[Any]): Any = (k == n, x) match {
	  		case (true, Nil) => println("Element index out of bounds!"); Nil
	  		case (true, x :: xs) => x
	  		case (false, x :: xs) => get(a, k+1, xs)
	  		case (_,_) => println("Eeek!")
	  	}
	  	get(a, 0, x)
	 }                                        //> nth: (a: Int, x: Iterable[Any])Any
	 
	 nth(2, l)                                //> res0: Any = 2
}