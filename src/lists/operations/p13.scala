package lists.operations

object p13 {

    def encodeDirect(list: List[Any]): List[(Int, Any)] =  {
      def encode_wrapper(i: Int, list: List[Any]): List[(Int, Any)] = {
        list match {
          case Nil      => Nil
          case x :: Nil => List((i, x))
          case x :: xs => list.head.equals(xs.head) match {
            case true  => encode_wrapper(i + 1, xs)
            case false => (i, x) :: encode_wrapper(1, xs)
          }
        }
      }
      encode_wrapper(1, list)
  }
    
}