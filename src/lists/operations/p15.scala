package lists.operations

object p15 {
	
  println("(**) Duplicate the elements of a list a given number of times.")
  
    //we borrow the implementation of fill
  import p12.fill;
  
  def duplicateN(k: Int, l: List[Any]): List[Any] = {
    l match {
      case Nil => Nil
      case x :: xs => fill(k, x) ::: duplicateN(k, xs) 
    }
    
  }
}