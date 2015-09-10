package logic

/** @author jzachar
  */
package object operators {

  def not(a: Boolean) = !a
  
  implicit class BooleanOperators(a: Boolean) {

    def and(b: Boolean): Boolean =
      (a, b) match {
        case (true, true) => true
        case (_, _)       => false
      }

    def or(b: Boolean): Boolean =
      (a, b) match {
        case (false, false) => false
        case (_, _)         => true
      }

    def nand(b: Boolean): Boolean = !a and (b)

    def nor(b: Boolean): Boolean = !a or (b)

    def xor(b: Boolean): Boolean =
      (a, b) match {
        case (true, true)   => false
        case (false, false) => false
        case (_, _)         => true
      }

    def impl(b: Boolean): Boolean =
      (a, b) match {
        case (true, true)   => true
        case (true, false)  => false
        case (false, true)  => true
        case (false, false) => false
      }

    def equ(b: Boolean): Boolean = if (a == b) true else false

  }

}