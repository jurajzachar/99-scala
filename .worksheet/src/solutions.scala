object solutions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 
  println("Solutions to 99 Scala problems --> http://aperiodic.net/phil/scala/s-99/ ");$skip(34); 

  val l = List(1, 1, 2, 3, 5, 8);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(53); 
  val xxl = List(List(1, 1), 2, List(3, List(5, 8)));System.out.println("""xxl  : List[Any] = """ + $show(xxl ));$skip(72); 
  val ls = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  import lists.operations._;System.out.println("""ls  : List[Symbol] = """ + $show(ls ));$skip(43); val res$0 = 
  p01.last(l);System.out.println("""res0: Any = """ + $show(res$0));$skip(22); val res$1 = 

  p02.penultimate(l);System.out.println("""res1: Any = """ + $show(res$1));$skip(17); val res$2 = 

  p03.nth(2, l);System.out.println("""res2: Any = """ + $show(res$2));$skip(16); val res$3 = 
  p04.length(l);System.out.println("""res3: Int = """ + $show(res$3));$skip(18); val res$4 = 

  p05.reverse(l);System.out.println("""res4: List[Any] = """ + $show(res$4));$skip(40); val res$5 = 
  p06.isPalindrome(List(1, 2, 3, 2, 1));System.out.println("""res5: Boolean = """ + $show(res$5));$skip(19); val res$6 = 
  p07.flatten(xxl);System.out.println("""res6: List[Any] = """ + $show(res$6));$skip(19); val res$7 = 
  p08.compress(ls);System.out.println("""res7: List[Symbol] = """ + $show(res$7));$skip(15); val res$8 = 
  p09.pack(ls);System.out.println("""res8: List[List[Any]] = """ + $show(res$8));$skip(26); 
  val el = p10.encode(ls);System.out.println("""el  : List[(Int, Any)] = """ + $show(el ));$skip(25); val res$9 = 
  p11.encodeModified(ls);System.out.println("""res9: List[Any] = """ + $show(res$9));$skip(18); val res$10 = 

  p12.decode(el);System.out.println("""res10: List[Any] = """ + $show(res$10));$skip(24); val res$11 = 

  p13.encodeDirect(ls);System.out.println("""res11: List[(Int, Any)] = """ + $show(res$11));$skip(20); val res$12 = 
  p14.duplicate(ls);System.out.println("""res12: List[Any] = """ + $show(res$12));$skip(42); val res$13 = 
  p15.duplicateN(3, List('a, 'b, 'b, 'c));System.out.println("""res13: List[Any] = """ + $show(res$13));$skip(87); 
  //drop every 2nd element
  val dl = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k);System.out.println("""dl  : List[Symbol] = """ + $show(dl ));$skip(46); 
  val il = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);System.out.println("""il  : List[Int] = """ + $show(il ));$skip(18); val res$14 = 
  p16.drop(2, il);System.out.println("""res14: List[Any] = """ + $show(res$14));$skip(18); val res$15 = 
  p16.drop(3, dl);System.out.println("""res15: List[Any] = """ + $show(res$15));$skip(66); val res$16 = 

  p17.split(1, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k));System.out.println("""res16: (List[Any], List[Any]) = """ + $show(res$16));$skip(66); val res$17 = 
  p19.rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k));System.out.println("""res17: List[Any] = """ + $show(res$17));$skip(70); val res$18 = 

  p20.removeAt(4,  List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k));System.out.println("""res18: (List[Any], _$1) = """ + $show(res$18));$skip(22); val res$19 = 
  p20.removeAt(0, il);System.out.println("""res19: (List[Any], _$1) = """ + $show(res$19));$skip(22); val res$20 = 
  p20.removeAt(9, il);System.out.println("""res20: (List[Any], _$1) = """ + $show(res$20));$skip(40); val res$21 = 
  

  p21.insertAt('foo, il.size/2, il);System.out.println("""res21: List[Any] = """ + $show(res$21));$skip(18); val res$22 = 
  p22.range(1, 5);System.out.println("""res22: List[Int] = """ + $show(res$22));$skip(32); 
  val bigList = p22.range(0,25);System.out.println("""bigList  : List[Int] = """ + $show(bigList ));$skip(31); val res$23 = 
  p23.randomSelect(5, bigList);System.out.println("""res23: List[Any] = """ + $show(res$23));$skip(20); val res$24 = 
  p24.lotto(10, 25);System.out.println("""res24: List[Any] = """ + $show(res$24));$skip(29); val res$25 = 
  p25.randomPermute(bigList);System.out.println("""res25: List[Any] = """ + $show(res$25));$skip(74); 
  p26.combinations(5, Set('a, 'b, 'c, 'd, 'e, 'f)).foreach(x=>println(x))}
}
