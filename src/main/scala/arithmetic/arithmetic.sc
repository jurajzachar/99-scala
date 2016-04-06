object arithmeticws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  import arithmetic._

  p31.isPrime(15481)                              //> res0: Boolean = false
  p31.isPrime(31)                                 //> res1: Boolean = true

  p32.gcd(546, 170)                               //> res2: Int = 2
  p32.gcd(31, 17)                                 //> res3: Int = 1

  p33.isCoprime(7, 5)                             //> res4: Boolean = true
  p33.isCoprime(7, 6)                             //> res5: Boolean = true
  p33.isCoprime(12, 6)                            //> res6: Boolean = false

  p34.totient(10090)                              //> res7: Int = 4032

  val n = 1000009;                                //> n  : Int = 1000009
  val c = Math.floor(Math.pow(n.asInstanceOf[Double], 0.25))
                                                  //> c  : Double = 31.0

  val tmp = for {
    i <- (0 until c.toInt); val jmin = 1 + i * c; val jmax = jmin + c - 1;
    j <- (jmin.toInt until jmax.toInt)
  } yield (i * j % n)                             //> tmp  : scala.collection.immutable.IndexedSeq[Int] = Vector(0, 0, 0, 0, 0, 0,
                                                  //|  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32,
                                                  //|  33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51,
                                                  //|  52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 126, 128, 130, 132, 134, 136, 138, 
                                                  //| 140, 142, 144, 146, 148, 150, 152, 154, 156, 158, 160, 162, 164, 166, 168, 1
                                                  //| 70, 172, 174, 176, 178, 180, 182, 184, 282, 285, 288, 291, 294, 297, 300, 30
                                                  //| 3, 306, 309, 312, 315, 318, 321, 324, 327, 330, 333, 336, 339, 342, 345, 348
                                                  //| , 351, 354, 357, 360, 363, 366, 369, 500, 504, 508, 512, 516, 520, 524, 528,
                                                  //|  532, 536, 540, 544, 548, 552, 556, 560, 564, 568, 572, 576, 580, 584, 588, 
                                                  //| 592, 596, 600, 604, 608, 612, 616, 780, 785, 790, 795, 800, 805, 810, 815, 8
                                                  //| 20, 825, 830, 835, 840, 845, 850, 855, 860, 865, 870, 875, 880, 885, 890, 89
                                                  //| 5, 900, 905, 910, 915, 920, 925, 1122, 1128, 1134, 1140, 1146, 1152, 1158, 1
                                                  //| 164, 1170, 1176, 1182, 1
                                                  //| Output exceeds cutoff limit.
  val greatestPrimeFactor = tmp.map(p32.gcd(_, n)).distinct.reverse.head
                                                  //> greatestPrimeFactor  : Int = 293

  p36.primeFactorMultiplicity(315)                //> res8: scala.collection.immutable.Map[Int,Int] = Map(5 -> 1, 7 -> 1, 3 -> 2)
  p37.totient(10090)                              //> res9: Int = 4032
  p39.listPrimesInRange(2 to 24)                  //> res10: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23)
  def findComplementaryPrime(xs: List[Int], sum: Int, candidateA: Int, candidateB: Int): Option[Int] = {
    xs match {
      case Nil      => if (candidateA + candidateB == sum) Some(candidateB) else None
      case x :: Nil => if (candidateA + x == sum) Some(x) else None
      case x :: xs  => if (candidateA + x == sum) Some(x) else findComplementaryPrime(xs, sum, candidateA, candidateB)
    }
  }                                               //> findComplementaryPrime: (xs: List[Int], sum: Int, candidateA: Int, candidat
                                                  //| eB: Int)Option[Int]
 
 p41.prettyPrint(p41.goldbachList(28))            //> 5 + 23 = 28
                                                  //| 11 + 17 = 28
                                                  //| 17 + 11 = 28
                                                  //| 23 + 5 = 28
 p41.prettyPrint(p41.goldbachListForRange(3 to 9))//> 2 + 2 = 4
                                                  //| 2 + 3 = 5
                                                  //| 2 + 5 = 7
                                                  //| 2 + 7 = 9
                                                  //| 3 + 2 = 5
                                                  //| 3 + 3 = 6
                                                  //| 3 + 5 = 8
                                                  //| 5 + 2 = 7
                                                  //| 5 + 3 = 8
                                                  //| 7 + 2 = 9
}