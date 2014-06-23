package lists.operations

object p09 {

  println("Pack consecutive duplicates of list elements into sublists.")

  def pack(list: List[Any]): List[List[Any]] = {
      def pack_wrapper(subl: List[Any], orig: List[Any]): List[List[Any]] = {
        orig match {
          case Nil      => Nil
          case x :: Nil => List(x :: subl)
          case x :: xs => orig.head.equals(xs.head) match {
            case true  => pack_wrapper(x :: subl, xs)
            case false => (x :: subl) :: pack_wrapper(Nil, xs)
          }
        }
      }
    pack_wrapper(Nil, list)
  }
}