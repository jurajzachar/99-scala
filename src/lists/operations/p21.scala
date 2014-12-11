package lists.operations

object p21 {

  println("(*) Insert an element at a given position into a list.")

  /*
   * scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
   * res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
   */
  import p17.split
  import p05.reverse
  def insertAt(elem: Any, i: Int, l: List[Any]): List[Any] = {
    i match {
      case 0 => elem :: l
      case x => {
        val sl = split(i, l)
        sl._1 ++ List(elem) ++ sl._2
      }
    }
  }
}