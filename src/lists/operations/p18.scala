package lists.operations

object p18 {

  println("(**) Extract a slice from a list.")
  /*
* Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
Example:

scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
res0: List[Symbol] = List('d, 'e, 'f, 'g)
*
*/

  //we just use the implementation of split defined earlier...
  import p17.split

  def slice(i: Int, k: Int, l: List[Any]): List[Any] = {
    split(k - i, split(i, l)._2)._1
  }
  
}