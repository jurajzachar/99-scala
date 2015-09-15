package logic

object logicWorksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  import p46._
  
  println("AND")                                  //> AND
  prettyTable(and)                                //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		true
                                                  //| true		false		false
                                                  //| false		true		false
                                                  //| false		false		false
  println                                         //> 
  println("OR")                                   //> OR
  prettyTable(or)                                 //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		true
                                                  //| true		false		true
                                                  //| false		true		true
                                                  //| false		false		false
  println                                         //> 
  println("XOR")                                  //> XOR
  prettyTable(xor)                                //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		false
                                                  //| true		false		true
                                                  //| false		true		true
                                                  //| false		false		false
  println                                         //> 
  
  println("NAND")                                 //> NAND
  prettyTable(nand)                               //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		false
                                                  //| true		false		true
                                                  //| false		true		true
                                                  //| false		false		true
  println                                         //> 
  println("NOR")                                  //> NOR
  prettyTable(nand)                               //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		false
                                                  //| true		false		true
                                                  //| false		true		true
                                                  //| false		false		true
  println                                         //> 
  println("IMPL")                                 //> IMPL
  prettyTable(impl)                               //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		true
                                                  //| true		false		false
                                                  //| false		true		true
                                                  //| false		false		false
  println                                         //> 
  println("EQU")                                  //> EQU
  prettyTable(equ)                                //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		true
                                                  //| true		false		false
                                                  //| false		true		false
                                                  //| false		false		true
 
  import logic.operators.{not, BooleanOperators}
  
  val a = true                                    //> a  : Boolean = true
  val b = false                                   //> b  : Boolean = false
  
  p46.prettyTable((a: Boolean, b: Boolean) => a and (a or not(b)))
                                                  //> A				B				Result
                                                  //| ----------------------
                                                  //| true		true		true
                                                  //| true		false		true
                                                  //| false		true		false
                                                  //| false		false		false
  
 type Pair = (String, Int)
 implicit def pairComparator(a:Pair, b:Pair) = a._2 < b._2
                                                  //> pairComparator: (a: logic.logicWorksheet.Pair, b: logic.logicWorksheet.Pair)
                                                  //| Boolean
 implicit def addStrings(a: String, b: String) = a + b
                                                  //> addStrings: (a: String, b: String)String
 implicit def addInts(a: Int, b: Int) = a + b     //> addInts: (a: Int, b: Int)Int
 val elements = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))
                                                  //> elements  : List[(String, Int)] = List((a,45), (b,13), (c,12), (d,16), (e,9)
                                                  //| , (f,5))
 val ht = new HuffmanTree[String, Int](elements)  //> ht  : logic.HuffmanTree[String,Int] = [root: (acbfed,100), left: (a,45), rig
                                                  //| ht: (cbfed,55)]
                                                  //| [root: (a,45)]
                                                  //| [root: (cbfed,55), left: (cb,25), right: (fed,30)]
                                                  //| [root: (cb,25), left: (c,12), right: (b,13)]
                                                  //| [root: (c,12)]
                                                  //| [root: (b,13)]
                                                  //| [root: (fed,30), left: (fe,14), right: (d,16)]
                                                  //| [root: (fe,14), left: (f,5), right: (e,9)]
                                                  //| [root: (f,5)]
                                                  //| [root: (e,9)]
                                                  //| [root: (d,16)]
  
}