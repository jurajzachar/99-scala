package lists.operations

object p17 {

  def split(size: Int, l: List[Any]): (List[Any], List[Any]) = {
	  l match {
	    case Nil => (Nil, Nil)
	    case x :: xs => size <= l.size match {
	      case true => (x :: split(size-1, xs)._1, xs)
	      case false => (split(size-1, xs)._1, xs)
	    }
	  }
	 }
}