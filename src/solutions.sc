object solutions {
	println("Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ ")
                                                  //> Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ 
	
	val l = List(1, 1, 2, 3, 5, 8)            //> l  : List[Int] = List(1, 1, 2, 3, 5, 8)
	val xxl = List(List(1, 1), 2, List(3, List(5, 8)))
                                                  //> xxl  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
	
	import lists.operations.p01
	p01.last(l)                               //> Find the last element of a list
                                                  //| res0: Any = 8
 
	import lists.operations.p02
  p02.penultimate(l)                              //> Find the last but one element of a list
                                                  //| res1: Any = 5
  
  import lists.operations.p03
  p03.nth(2, l)                                   //> Find the Kth element of a list
                                                  //| res2: Any = 2
  
  import lists.operations.p04
  p04.length(l)                                   //> Find the number of elements of a list.
                                                  //| res3: Int = 6
 	
 	import lists.operations.p05
 	p05.reverse(l)                            //> Reverse a list
                                                  //| res4: List[Any] = List(8, 5, 3, 2, 1, 1)
 	
 	import lists.operations.p06
 	p06.isPalindrome(List(1, 2, 3, 2, 1))     //> Find out whether a list is a palindrome.
                                                  //| res5: Boolean = true
 	p06.isPalindrome(List(1, 2, 3, 2, 2, 1))  //> res6: Boolean = false
 	
 	import lists.operations.p07
 		p07.flatten(xxl)                  //> Flatten a nested list structure.
                                                  //| res7: List[Any] = List(1, 1, 2, 3, 5, 8)
		p07.flatten(List(List(xxl)))      //> res8: List[Any] = List(1, 1, 2, 3, 5, 8)
}