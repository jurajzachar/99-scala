package lists.operations

object p20 {

  println("(*) Remove the Kth element from a list.")

  /*
   * scala> removeAt(1, List('a, 'b, 'c, 'd))
   * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
   */
  import p17.split
  import p05.reverse
  
  def removeAt(i: Int, l: List[Any]): (List[Any], _) = {
    if(i > l.length-1) throw new IllegalArgumentException
    i match {
      case 0 => (l.tail, l.head)
      case x => {
        val sl = split(x, l)
        val removed = sl._2.head
        (sl._1 ++ sl._2.tail, removed)
      }
    }
  }
}