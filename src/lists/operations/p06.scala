package lists.operations

object p06 {
  
  println("Find out whether a list is a palindrome.")
                                                  
  /*
   * scala> isPalindrome(List(1, 2, 3, 2, 1))
	 * res0: Boolean = true
   */
  
  import p05.reverse
  
  def isPalindrome(x: Iterable[Any]): Boolean = {
  	
    def wrapper(n: Iterable[Any], k: Iterable[Any]): Boolean = {
    	(n, k) match {
    	  case (Nil, Nil) => true
    	  case (Nil, _) => false
    	  case (_, Nil) => false
    	  case (x :: xs, y :: ys) => {
    	    x == y match {
    	      case true => true && wrapper(xs, ys)
    	      case fals => false
    	    }
    	  }
    	}	
    }
    wrapper(x, reverse(x.toList))
  }
  
}