package logic

object huffman {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  type Pair = (String, Int)
  implicit def pairComparator(a: Pair, b: Pair) = a._2 < b._2
                                                  //> pairComparator: (a: logic.huffman.Pair, b: logic.huffman.Pair)Boolean
  implicit def addStrings(a: String, b: String) = a + b
                                                  //> addStrings: (a: String, b: String)String
  implicit def addInts(a: Int, b: Int) = a + b    //> addInts: (a: Int, b: Int)Int
  val elements = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))
                                                  //> elements  : List[(String, Int)] = List((a,45), (b,13), (c,12), (d,16), (e,9)
                                                  //| , (f,5))
	
  val ht = new HuffmanTree[String, Int](elements) //> ht  : logic.HuffmanTree[String,Int] = HuffmanTree: root = (acbfed,100)
 ht.depth()                                       //> res0: Int = 5
 ht.prettyPrint                                   //> res1: String = "
                                                  //| Queue((acbfed,100))
                                                  //| counter: 1
                                                  //| Queue((a,45), (cbfed,55))
                                                  //| counter: 2
                                                  //| Queue((cbfed,55))
                                                  //| counter: 3
                                                  //| Queue((cb,25), (fed,30))
                                                  //| counter: 4
                                                  //| Queue((fed,30), (c,12), (b,13))
                                                  //| counter: 5
                                                  //| Queue((c,12), (b,13), (fe,14), (d,16))
                                                  //| counter: 6
                                                  //| Queue((b,13), (fe,14), (d,16))
                                                  //| counter: 7
                                                  //| Queue((fe,14), (d,16))
                                                  //| counter: 8
                                                  //| Queue((d,16), (f,5), (e,9))
                                                  //| counter: 9
                                                  //| Queue((f,5), (e,9))
                                                  //| counter: 10
                                                  //| Queue((e,9))
                                                  //| counter: 11
                                                  //| "
}