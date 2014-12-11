package lists.operations

object p25 {

  println("P25 (*) Generate a random permutation of the elements of a list.")
  import p23.randomSelect
  def randomPermute(l: List[Any]): List[Any] = {
    randomSelect(l.length, l)
  }
}