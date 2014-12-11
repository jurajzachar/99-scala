package lists.operations

object p22 {

  println("(*) Create a list containing all integers within a given range.")
  
  def range(from: Int, to: Int): List[Int] = {
    if (from < Integer.MIN_VALUE || 
        from > Integer.MAX_VALUE ||
        to < Integer.MIN_VALUE ||
        to > Integer.MAX_VALUE ) throw new IllegalArgumentException();
    from < to match {
      case false => List(to)
      case true => List(from) ++ range(from + 1, to)
    }
  }
}