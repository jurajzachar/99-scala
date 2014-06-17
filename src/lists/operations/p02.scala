package lists.operations

object p02 {
  println("Find the last but one element of a list")
                                                  
  //scala> penultimate(List(1, 1, 2, 3, 5, 8))
  //res0: Int = 5

  val l = List(1, 1, 2, 3, 5, 8)                  

  def penultimate(x: List[Any]): Any = {
    x match {
      case x :: Nil => x
      case x :: xs :: Nil => x
      case x :: xs => penultimate(xs)
      
  	}
  }                                             
  
  penultimate(l)                                  
}