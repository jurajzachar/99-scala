package logic

/** @author jzachar
  */
object p46 {

  def and(a: Boolean, b: Boolean): Boolean =
    (a, b) match {
      case (true, true) => true
      case (_, _)       => false
    }

  def or(a: Boolean, b: Boolean): Boolean =
    (a, b) match {
      case (false, false) => false
      case (_, _)         => true
    }

  def nand(a: Boolean, b: Boolean): Boolean = !and(a, b)

  def nor(a: Boolean, b: Boolean): Boolean = !or(a, b)

  def xor(a: Boolean, b: Boolean): Boolean =
    (a, b) match {
      case (true, true)   => false
      case (false, false) => false
      case (_, _)         => true
    }

  def impl(a: Boolean, b: Boolean): Boolean =
    (a, b) match {
      case (true, true)   => true
      case (true, false)  => false
      case (false, true)  => true
      case (false, false) => false
    }

  def equ(a: Boolean, b: Boolean): Boolean = if (a == b) true else false

  def prettyTable(expr: (Boolean, Boolean) => Boolean): Unit = {
    val feed = List((true, true), (true, false), (false, true), (false, false))
    println("A\t\t\t\tB\t\t\t\tResult")
    println("-" * 22)
    feed.foreach(c => println(s"${c._1}\t\t${c._2}\t\t${expr(c._1, c._2)}"))
  }

}
