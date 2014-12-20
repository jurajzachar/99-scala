package lists.operations

object p24 {
  println("(*) Lotto: Draw N different random numbers from the set 1..M.")

  import p22.range
  import p23.randomSelect

  def lotto(size: Int, m: Int): List[Any] = {
    randomSelect(size, range(1,m))
  }
}