package lists.operations

object p16 {

  println("(**) Drop every Nth element from a list.")

  def drop(n: Int, l: List[Any]): List[Any] = {
    def wrapper(index: Int, l: List[Any]): List[Any] = {
      n match {
        case 0 => l
        case _ => {
          l match {
            case Nil => Nil
            case x :: xs => index % n == 0 match {
              case true  => wrapper(index + 1, xs)
              case false => x :: wrapper(index + 1, xs)
            }
          }
        }

      }
    }

    wrapper(1, l)
  }
}