object solutions {
  println("Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ ")
                                                  //> Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ 

  val l = List(1, 1, 2, 3, 5, 8)                  //> l  : List[Int] = List(1, 1, 2, 3, 5, 8)
  val xxl = List(List(1, 1), 2, List(3, List(5, 8)))
                                                  //> xxl  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
                                                  //> ls  : List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e
                                                  //| , 'e)

  import lists.operations.p01
  p01.last(l)                                     //> Find the last element of a list
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
  p05.reverse(l)                                  //> Reverse a list
                                                  //| res4: List[Any] = List(8, 5, 3, 2, 1, 1)

  import lists.operations.p06
  p06.isPalindrome(List(1, 2, 3, 2, 1))           //> Find out whether a list is a palindrome.
                                                  //| res5: Boolean = true

  import lists.operations.p07
  p07.flatten(xxl)                                //> Flatten a nested list structure.
                                                  //| res6: List[Any] = List(1, 1, 2, 3, 5, 8)

  import lists.operations.p08
  p08.compress(ls)                                //> Eliminate consecutive duplicates of list elements.
                                                  //| res7: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

  import lists.operations.p09
  p09.pack(ls)                                    //> Pack consecutive duplicates of list elements into sublists.
                                                  //| res8: List[List[Any]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), L
                                                  //| ist('a, 'a), List('d), List('e, 'e, 'e, 'e))
  
  import lists.operations.p10
  val el = p10.encode(ls)                         //>  Run-length encoding of a list.
                                                  //| this solution re-uses function from p09 and the built-in 'map'
                                                  //| el  : List[(Int, Any)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)
                                                  //| )
  
  import lists.operations.p11
  p11.encodeModified(ls)                          //>  Modified run-length encoding of a list. Unique elements are singletons.
                                                  //| res9: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
  
  import lists.operations.p12
 	p12.decode(el)                            //> Decode a run-length encoded list.
                                                  //| res10: List[Any] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 
                                                  //| 'e)
 	
 	import lists.operations.p13
 	p13.encodeDirect(ls)                      //>  Run-length encoding of a list (direct solution).
                                                  //| res11: List[(Int, Any)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e
                                                  //| ))
 	import lists.operations.p14
 	p14.duplicate(ls)                         //> Duplicate the elements of a list.
                                                  //| res12: List[Any] = List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'b, 'b, 'c, 'c, 'c, 
                                                  //| 'c, 'a, 'a, 'a, 'a, 'd, 'd, 'e, 'e, 'e, 'e, 'e, 'e, 'e, 'e)
  import lists.operations.p15
  p15.duplicateN(3, List('a, 'b, 'b, 'c))         //> (**) Duplicate the elements of a list a given number of times.
                                                  //| res13: List[Any] = List('a, 'a, 'a, 'b, 'b, 'b, 'b, 'b, 'b, 'c, 'c, 'c)
 
 }