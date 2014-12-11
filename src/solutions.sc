object solutions {
  println("Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ ")
                                                  //> Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ 

  val l = List(1, 1, 2, 3, 5, 8)                  //> l  : List[Int] = List(1, 1, 2, 3, 5, 8)
  val xxl = List(List(1, 1), 2, List(3, List(5, 8)))
                                                  //> xxl  : List[Any] = List(List(1, 1), 2, List(3, List(5, 8)))
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
                                                  //> ls  : List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e
                                                  //| , 'e)

  import lists.operations._
  p01.last(l)                                     //> Find the last element of a list
                                                  //| res0: Any = 8

  p02.penultimate(l)                              //> Find the last but one element of a list
                                                  //| res1: Any = 5

  p03.nth(2, l)                                   //> Find the Kth element of a list
                                                  //| res2: Any = 2
  p04.length(l)                                   //> Find the number of elements of a list.
                                                  //| res3: Int = 6

  p05.reverse(l)                                  //> Reverse a list
                                                  //| res4: List[Any] = List(8, 5, 3, 2, 1, 1)
  p06.isPalindrome(List(1, 2, 3, 2, 1))           //> Find out whether a list is a palindrome.
                                                  //| res5: Boolean = true
  p07.flatten(xxl)                                //> Flatten a nested list structure.
                                                  //| res6: List[Any] = List(1, 1, 2, 3, 5, 8)
  p08.compress(ls)                                //> Eliminate consecutive duplicates of list elements.
                                                  //| res7: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  p09.pack(ls)                                    //> Pack consecutive duplicates of list elements into sublists.
                                                  //| res8: List[List[Any]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), L
                                                  //| ist('a, 'a), List('d), List('e, 'e, 'e, 'e))
  val el = p10.encode(ls)                         //>  Run-length encoding of a list.
                                                  //| this solution re-uses function from p09 and the built-in 'map'
                                                  //| el  : List[(Int, Any)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)
                                                  //| )
  p11.encodeModified(ls)                          //>  Modified run-length encoding of a list. Unique elements are singletons.
                                                  //| res9: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

  p12.decode(el)                                  //> Decode a run-length encoded list.
                                                  //| res10: List[Any] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 
                                                  //| 'e)

  p13.encodeDirect(ls)                            //>  Run-length encoding of a list (direct solution).
                                                  //| res11: List[(Int, Any)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e
                                                  //| ))
  p14.duplicate(ls)                               //> Duplicate the elements of a list.
                                                  //| res12: List[Any] = List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'b, 'b, 'c, 'c, 'c, 
                                                  //| 'c, 'a, 'a, 'a, 'a, 'd, 'd, 'e, 'e, 'e, 'e, 'e, 'e, 'e, 'e)
  p15.duplicateN(3, List('a, 'b, 'b, 'c))         //> (**) Duplicate the elements of a list a given number of times.
                                                  //| res13: List[Any] = List('a, 'a, 'a, 'b, 'b, 'b, 'b, 'b, 'b, 'c, 'c, 'c)
  //drop every 2nd element
  val dl = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
                                                  //> dl  : List[Symbol] = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
  val il = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)     //> il  : List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
  p16.drop(2, il)                                 //> (**) Drop every Nth element from a list.
                                                  //| res14: List[Any] = List(0, 2, 4, 6, 8)
  p16.drop(3, dl)                                 //> res15: List[Any] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

  p17.split(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> (*) Split a list into two parts. The length of the first part is given. Use 
                                                  //| a Tuple for your result.
                                                  //| res16: (List[Any], List[Any]) = (List('a),List('b, 'c, 'd, 'e, 'f, 'g, 'h, '
                                                  //| i, 'j, 'k))
  p19.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> (**) Rotate a list N places to the left.
                                                  //| res17: List[Any] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

  p20.removeAt(4,  List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
                                                  //> (*) Remove the Kth element from a list.
                                                  //| res18: (List[Any], _$1) = (List('a, 'b, 'c, 'd, 'f, 'g, 'h, 'i, 'j, 'k),'e)
  p20.removeAt(0, il)                             //> res19: (List[Any], _$1) = (List(1, 2, 3, 4, 5, 6, 7, 8, 9),0)
  p20.removeAt(9, il)                             //> res20: (List[Any], _$1) = (List(0, 1, 2, 3, 4, 5, 6, 7, 8),9)
  

  p21.insertAt('foo, il.size/2, il)               //> (*) Insert an element at a given position into a list.
                                                  //| res21: List[Any] = List(0, 1, 2, 3, 4, 'foo, 5, 6, 7, 8, 9)
  p22.range(1, 5)                                 //> (*) Create a list containing all integers within a given range.
                                                  //| res22: List[Int] = List(1, 2, 3, 4, 5)
  val bigList = p22.range(0,25)                   //> bigList  : List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1
                                                  //| 4, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
  p23.randomSelect(5, bigList)                    //> (**) Extract a given number of randomly selected elements from a list.
                                                  //| res23: List[Any] = List(16, 2, 1, 5, 0)
  p24.lotto(10, 25)                               //> (*) Lotto: Draw N different random numbers from the set 1..M.
                                                  //| res24: List[Any] = List(11, 21, 12, 6, 25, 16, 7, 1, 17, 2)
  p25.randomPermute(bigList)                      //> P25 (*) Generate a random permutation of the elements of a list.
                                                  //| res25: List[Any] = List(16, 5, 1, 22, 3, 7, 17, 19, 12, 20, 10, 9, 15, 0, 8
                                                  //| , 18, 6, 24, 11, 23, 4, 21, 25, 14, 13, 2)
  p26.combinations(5, Set('a, 'b, 'c, 'd, 'e, 'f)).foreach(x=>println(x))
                                                  //> Set('e, 'f, 'a, 'b, 'd)
                                                  //| Set('e, 'f, 'b, 'c, 'd)
                                                  //| Set('f, 'a, 'b, 'c, 'd)
                                                  //| Set('e, 'f, 'a, 'b, 'c)
                                                  //| Set('e, 'a, 'b, 'c, 'd)
                                                  //| Set('e, 'f, 'a, 'c, 'd)
}