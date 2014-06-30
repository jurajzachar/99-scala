object solutions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
  println("Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ ");$skip(34); 

  val l = List(1, 1, 2, 3, 5, 8);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(53); 
  val xxl = List(List(1, 1), 2, List(3, List(5, 8)));System.out.println("""xxl  : List[Any] = """ + $show(xxl ));$skip(72); 
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  import lists.operations.p01;System.out.println("""ls  : List[Symbol] = """ + $show(ls ));$skip(45); val res$0 = 
  p01.last(l)

  import lists.operations.p02;System.out.println("""res0: Any = """ + $show(res$0));$skip(52); val res$1 = 
  p02.penultimate(l)

  import lists.operations.p03;System.out.println("""res1: Any = """ + $show(res$1));$skip(47); val res$2 = 
  p03.nth(2, l)

  import lists.operations.p04;System.out.println("""res2: Any = """ + $show(res$2));$skip(47); val res$3 = 
  p04.length(l)

  import lists.operations.p05;System.out.println("""res3: Int = """ + $show(res$3));$skip(48); val res$4 = 
  p05.reverse(l)

  import lists.operations.p06;System.out.println("""res4: List[Any] = """ + $show(res$4));$skip(71); val res$5 = 
  p06.isPalindrome(List(1, 2, 3, 2, 1))

  import lists.operations.p07;System.out.println("""res5: Boolean = """ + $show(res$5));$skip(50); val res$6 = 
  p07.flatten(xxl)

  import lists.operations.p08;System.out.println("""res6: List[Any] = """ + $show(res$6));$skip(50); val res$7 = 
  p08.compress(ls)

  import lists.operations.p09;System.out.println("""res7: List[Symbol] = """ + $show(res$7));$skip(46); val res$8 = 
  p09.pack(ls)
  
  import lists.operations.p10;System.out.println("""res8: List[List[Any]] = """ + $show(res$8));$skip(59); 
  val el = p10.encode(ls)
  
  import lists.operations.p11;System.out.println("""el  : List[(Int, Any)] = """ + $show(el ));$skip(58); val res$9 = 
  p11.encodeModified(ls)
  
  import lists.operations.p12;System.out.println("""res9: List[Any] = """ + $show(res$9));$skip(50); val res$10 = 
 	p12.decode(el)
 	
 	import lists.operations.p13;System.out.println("""res10: List[Any] = """ + $show(res$10));$skip(56); val res$11 = 
 	p13.encodeDirect(ls)
 	import lists.operations.p14;System.out.println("""res11: List[(Int, Any)] = """ + $show(res$11));$skip(50); val res$12 = 
 	p14.duplicate(ls)
  import lists.operations.p15;System.out.println("""res12: List[Any] = """ + $show(res$12));$skip(72); val res$13 = 
  p15.duplicateN(3, List('a, 'b, 'b, 'c))
  
  import lists.operations.p16;System.out.println("""res13: List[Any] = """ + $show(res$13));$skip(97); val res$14 = 
  p16.drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  import lists.operations.p17;System.out.println("""res14: List[Any] = """ + $show(res$14));$skip(95); val res$15 = 
  p17.split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  import lists.operations.p18;System.out.println("""res15: (List[Any], List[Any]) = """ + $show(res$15));$skip(98); val res$16 = 
  p18.slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k));System.out.println("""res16: List[Any] = """ + $show(res$16))}
  
  
 }
