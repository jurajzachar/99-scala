package arithmetic

import scala.annotation.tailrec
import scala.annotation.tailrec

/** @author jzachar
  */
object arithmetic {

  /** @author jzachar
    *
    * (**) Determine whether a given integer number is prime.
    * scala> 7.isPrime
    * res0: Boolean = true
    *
    */
  object p31 {
    implicit def isPrime(i: Int): Boolean = {
        @tailrec
        def wrapper(i: Int, k: Int): Boolean = {
          if (k < i && i % k == 0) {
            false
          } else if (k > i) {
            true
          } else {
            wrapper(i, k + 1)
          }
        }
      wrapper(i, 2)
    }
  }

  /** @author jzachar
    *
    * P32 (**) Determine the greatest common divisor of two positive integer numbers.
    * Use Euclid's algorithm.
    * scala> gcd(36, 63
    */
  object p32 {
    @tailrec
    def gcd(a: Int, b: Int): Int = {
      if (b == 0) {
        a
      } else {
        gcd(b, a % b)
      }
    }
  }

  /** @author jzachar
    *
    * P33 (*) Determine whether two positive integer numbers are coprime.
    * Two numbers are coprime if their greatest common divisor equals 1.
    * scala> 35.isCoprimeTo(64)
    * res0: Boolean = true
    */
  object p33 {

    import p32.gcd

    def isCoprime(i: Int, k: Int): Boolean = {
      gcd(i, k) == 1
    }
  }

  /** @author jzachar
    * P34 (**) Calculate Euler's totient function phi(m) .
    * Euler's so-called totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
    * scala> 10.totient
    * res0: Int = 4
    */
  object p34 {
    import p33.isCoprime
    def totient(m: Int): Int = {
        @tailrec
        def wrapper(i: Int, counter: Int): Int = {
          if (i == m) {
            counter
          } else {
            isCoprime(m, i) match {
              case false => wrapper(i + 1, counter)
              case true  => wrapper(i + 1, counter + 1)
            }
          }
        }
      wrapper(1, 0)
    }
  }

  /** @author jzachar
    *
    * P35 (**) Determine the prime factors of a given positive integer.
    * Construct a flat list containing the prime factors in ascending order.
    * scala> 315.primeFactors
    * res0: List[Int] = List(3, 3, 5, 7)
    */

  object p35 {

    def greatestDivisor(k: Int): Int = {
      var x: Int = k - 1
      while ((k % x) != 0) x = x - 1
      x
    }

    def primeFactors(n: Int): List[Int] = {
      val gd = greatestDivisor(n)
      val multiplier = n / gd
      (p31.isPrime(gd), p31.isPrime(multiplier)) match {
        case (true, true)   => List(gd, multiplier)
        case (true, false)  => gd :: primeFactors(multiplier)
        case (false, true)  => multiplier :: primeFactors(gd)
        case (false, false) => primeFactors(gd) ++ primeFactors(multiplier)
      }
    }

    /** P36 (**) Determine the prime factors of a given positive integer (2).
      * Construct a list containing the prime factors and their multiplicity.
      * scala> 315.primeFactorMultiplicity
      * res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
      * @author jzachar
      */
    object p36 {
      def primeFactorMultiplicity(n: Int) = p35.primeFactors(n).groupBy(identity).mapValues(_.size)
    }

    /** P37 (**) Calculate Euler's totient function phi(m) (improved).
      * See problem P34 for the definition of Euler's totient function.
      * If the list of the prime factors of a number m is known in the
      * form of problem P36 then the function phi(m>) can be efficiently
      * calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...]
      * be the list of prime factors (and their multiplicities) of a given
      * number m. Then phi(m) can be calculated with the following formula:
      *
      * phi(m) = (p1-1)*p1^(m1-1) * (p2-1)*p2^(m2-1) * (p3-1)*p3^(m3-1) * ...
      *
      * @author jzachar
      */
    object p37 {
      def totient(m: Int): Int = {
        p36.primeFactorMultiplicity(m).foldLeft(1) { case (acc, (factor, multiplicity)) => acc * ((factor - 1) * Math.pow(factor, multiplicity - 1).toInt) }
      }
    }

    /** P39 (*) A list of prime numbers.
      * Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
      *
      * scala> listPrimesinRange(7 to 31)
      * res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
      *
      * @author jzachar
      */
    object p39 {
      def listPrimesInRange(range: Range): List[Int] =
        range.foldLeft(List[Int]()) { case (acc, (v)) => if (p31.isPrime(v)) v :: acc else acc } reverse
    }

    /** This is P40 + P41 (**) Goldbach's conjecture.
      * Goldbach's conjecture says that every positive even number greater than 2
      * is the sum of two prime numbers. E.g. 28 = 5 + 23. It is one of the most
      * famous facts in number theory that has not been proved to be correct in
      * the general case. It has been numerically confirmed up to very large numbers
      * (much larger than Scala's Int can represent). Write a function to find the
      * two prime numbers that sum up to a given even integer.
      *
      * scala> 28.goldbach
      * res0: (Int, Int) = (5,23)
      *
      * @author jzachar
      */

    object p41 {

      def goldbachList(n: Int): List[(Int, Int)] = {
        require(n > 2)
          def findComplementaryPrime(xs: List[Int], sum: Int, candidateA: Int, candidateB: Int): Option[Int] = {
            xs match {
              case Nil      => if (candidateA + candidateB == sum) Some(candidateB) else None
              case x :: Nil => if (candidateA + x == sum) Some(x) else None
              case x :: xs  => if (candidateA + x == sum) Some(x) else findComplementaryPrime(xs, sum, candidateA, candidateB)
            }
          }
        val primesInRange = p39.listPrimesInRange(2 to n)
        primesInRange.map(p => (p, findComplementaryPrime(primesInRange, n, p, 0))).flatMap { p => if (p._2.isDefined) List((p._1, p._2.get)) else List() }
      }

      def goldbachListForRange(range: Range): List[(Int, Int)] = {
        (range flatMap goldbachList toSet) toList
      }

      def prettyPrint(xs: List[(Int, Int)]) =
        xs.sorted.foreach(e => println(e._1 + " + " + e._2 + " = " + (e._1 + e._2)))
    }
  }
}