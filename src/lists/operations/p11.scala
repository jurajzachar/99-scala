package lists.operations

object p11 {

  println(" Modified run-length encoding of a list. Unique elements are singletons.")

def encodeModified(list: List[Any]): List[Any] = {
      def encode_wrapper(i: Int, list: List[Any]): List[Any] = {
        list match {
          case Nil      => Nil
          case x :: Nil => List((i, x))
          case x :: xs => list.head.equals(xs.head) match {
            case true => encode_wrapper(i + 1, xs)
            case false => i match {
              case 1 => x :: encode_wrapper(1, xs)
              case _ => (i, x) :: encode_wrapper(1, xs)
            }
          }
        }
      }
    encode_wrapper(1, list)
  }
}