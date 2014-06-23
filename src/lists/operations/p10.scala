package lists.operations

object p10 {

  println(" Run-length encoding of a list.")

  def encode(list: List[Any]): List[(Int, Any)] =  {
    println("this solution re-uses function from p09 and the built-in 'map'")
    import p09.pack
    p09.pack(list).map(x => (x.size, x.head))
  }
  
}