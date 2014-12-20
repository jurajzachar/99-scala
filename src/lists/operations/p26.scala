package lists.operations

object p26 extends App {

  println("(**) Generate the combinations of K distinct objects chosen from the N elements of a list.")

  /*
   * scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
   * res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
   */
  
  //to-do: implement with lists signature as per above example
  
  def combinations(k: Int, nSet: Set[Any]): Set[Set[Any]] = {
      def enumerate(outSet: Set[Any], k: Int, inSet: Set[Any]): Set[Set[Any]] = {
        if (k == 0) {
          Set(outSet)
        } else {
           for (x <- inSet) yield enumerate(outSet + x, k - 1, inSet - x) flatten
        }
      }
      enumerate(Set(), k, nSet)
  }

}
