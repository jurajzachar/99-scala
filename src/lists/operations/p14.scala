package lists.operations

object p14 {

  println("Duplicate the elements of a list.");
  //we borrow the implementation of fill
  import p12.fill;
  
  def duplicate(l: List[Any]): List[Any] = {
    l match {
      case Nil => Nil
      case x :: xs => fill(2, x) ::: duplicate(xs) 
    }
    
  }
}