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
}