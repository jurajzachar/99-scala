import scala.util.Random

object lists {

  object p01 {
    println("Find the last element of a list") //> Find the last element of a list
    val l = List(1, 2, 3, 4, 5, 8) //> l  : List[Int] = List(1, 2, 3, 4, 5, 8)

    def last(x: List[Any]): Any = {
      x match {
        case Nil      => Nil
        case x :: Nil => x
        case x :: xs  => last(xs)
      }
    }
    last(l)

  }

  object p02 {
    println("Find the last but one element of a list")
    //> Find the last but one element of a list
    //scala> penultimate(List(1, 1, 2, 3, 5, 8))
    //res0: Int = 5

    val l = List(1, 1, 2, 3, 5, 8) //> l  : List[Int] = List(1, 1, 2, 3, 5, 8)

    def penultimate(x: List[Any]): Any = {
      x match {
        case Nil            => Nil
        case x :: Nil       => x
        case x :: xs :: Nil => x
        case x :: xs        => penultimate(xs)

      }
    }
    penultimate(l)
  }

  object p03 {
    println("Find the Kth element of a list")

    val l = List(1, 1, 2, 3, 5, 8)

    def nth(a: Int, x: Iterable[Any]): Any = {
        def get(n: Int, k: Int, x: Iterable[Any]): Any = (k == n, x) match {
          case (true, Nil) =>
            println("Element index out of bounds!"); Nil
          case (true, x :: xs)  => x
          case (false, x :: xs) => get(a, k + 1, xs)
          case (_, _)           => println("Eeek!")
        }
      get(a, 0, x)
    }

    nth(2, l)
  }

  object p04 {

    def length(x: Iterable[Any]): Int = {
        def wrapper(s: Int, x: Iterable[Any]): Int = x match {
          case Nil      => 0
          case x :: Nil => s
          case x :: xs  => wrapper(s + 1, xs)
        }
      wrapper(1, x)
    } //> length: (x: Iterable[Any])Int

  }

  object p05 {
    println("Reverse a list") //> Reverse a list
    /** scala> reverse(List(1, 1, 2, 3, 5, 8))
      * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
      */

    val l = List(1, 1, 2, 3, 5, 8) //> l  : List[Int] = List(1, 1, 2, 3, 5, 8)

    def reverse(x: List[Any]): List[Any] = {
        def wrapper(n: List[Any], k: List[Any]): List[Any] = {
          (n, k) match {
            case (_, Nil)      => n
            case (_, x :: Nil) => x :: n
            case (_, x :: xs)  => wrapper(x :: n, xs)
          }
        }
      wrapper(Nil, x)
    } //> reverse: (x: List[Any])List[Any]

    reverse(l) //> res0: List[Any] = List(8, 5, 3, 2, 1, 1)
  }

  object p06 {
    println("Find out whether a list is a palindrome.")
    //> Find out whether a list is a palindrome
    /** scala> isPalindrome(List(1, 2, 3, 2, 1))
      * res0: Boolean = true
      */

    import p05.reverse

    def isPalindrome(x: Iterable[Any]): Boolean = {

        def wrapper(n: Iterable[Any], k: Iterable[Any]): Boolean = {
          (n, k) match {
            case (Nil, Nil) => true
            case (Nil, _)   => false
            case (_, Nil)   => false
            case (x :: xs, y :: ys) => {
              x == y match {
                case true => true && wrapper(xs, ys)
                case fals => false
              }
            }
          }
        }
      wrapper(x, reverse(x.toList))
    }
  }

  object p07 {

    println("Flatten a nested list structure.")

    /** scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
      * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
      */

    def flatten(l: List[Any]): List[Any] = l match {
      case Nil => Nil
      case x :: xs => (x match {
        case x: List[Any] => flatten(x)
        case i            => List(i)
      }) ++ flatten(xs)
    }

  }

  object p08 {

    println("Eliminate consecutive duplicates of list elements.")

    /** scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
      */

    def compress(list: List[Symbol]): List[Symbol] = {
      list match {
        case Nil      => Nil
        case x :: Nil => List(x)
        case x :: xs  => list.head :: compress(list.dropWhile(x => list.head.equals(x)))

      }
    }

  }

  object p09 {

    println("Pack consecutive duplicates of list elements into sublists.")

    def pack(list: List[Any]): List[List[Any]] = {
        def pack_wrapper(subl: List[Any], orig: List[Any]): List[List[Any]] = {
          orig match {
            case Nil      => Nil
            case x :: Nil => List(x :: subl)
            case x :: xs => orig.head.equals(xs.head) match {
              case true  => pack_wrapper(x :: subl, xs)
              case false => (x :: subl) :: pack_wrapper(Nil, xs)
            }
          }
        }
      pack_wrapper(Nil, list)
    }
  }

  object p10 {

    println(" Run-length encoding of a list.")

    def encode(list: List[Any]): List[(Int, Any)] = {
      println("this solution re-uses function from p09 and the built-in 'map'")
      import p09.pack
      p09.pack(list).map(x => (x.size, x.head))
    }

  }

  object p11 {

    println(" Modified run-length encoding of a list. Unique elements are singletons.")

    def encodeModified(list: List[Any]): List[Any] = {
        def encode_wrapper(i: Int, list: List[Any]): List[Any] = {
          list match {
            case Nil      => Nil
            case x :: Nil => List((i, x))
            case x :: xs => list.head.equals(xs.head) match {
              case true => encode_wrapper(i + 1, xs)
              case false => i match {
                case 1 => x :: encode_wrapper(1, xs)
                case _ => (i, x) :: encode_wrapper(1, xs)
              }
            }
          }
        }
      encode_wrapper(1, list)
    }
  }

  object p12 {

    println("Decode a run-length encoded list.")

    def fill(i: Int, e: Any): List[Any] = {
      i match {
        case 0 => Nil
        case 1 => e :: Nil
        case _ => e :: fill(i - 1, e)
      }
    }

    def decode(ls: List[(Int, Any)]): List[Any] = {
      (for (e <- ls) yield fill(e._1, e._2)) flatten
    }
  }

  object p13 {

    println(" Run-length encoding of a list (direct solution).")

    def encodeDirect(list: List[Any]): List[(Int, Any)] = {
        def encode_wrapper(i: Int, list: List[Any]): List[(Int, Any)] = {
          list match {
            case Nil      => Nil
            case x :: Nil => List((i, x))
            case x :: xs => list.head.equals(xs.head) match {
              case true  => encode_wrapper(i + 1, xs)
              case false => (i, x) :: encode_wrapper(1, xs)
            }
          }
        }
      encode_wrapper(1, list)
    }
  }

  object p14 {

    println("Duplicate the elements of a list.");
    //we borrow the implementation of fill
    import p12.fill;

    def duplicate(l: List[Any]): List[Any] = {
      l match {
        case Nil     => Nil
        case x :: xs => fill(2, x) ::: duplicate(xs)
      }

    }
  }

  object p15 {

    println("(**) Duplicate the elements of a list a given number of times.")

    //we borrow the implementation of fill
    import p12.fill;

    def duplicateN(k: Int, l: List[Any]): List[Any] = {
      l match {
        case Nil     => Nil
        case x :: xs => fill(k, x) ::: duplicateN(k, xs)
      }
    }
  }

  object p16 {

    println("(**) Drop every Nth element from a list.")

    def drop(n: Int, l: List[Any]): List[Any] = {
        def wrapper(index: Int, l: List[Any]): List[Any] = {
          n match {
            case 0 => l
            case _ => {
              l match {
                case Nil => Nil
                case x :: xs => index % n == 0 match {
                  case true  => wrapper(index + 1, xs)
                  case false => x :: wrapper(index + 1, xs)
                }
              }
            }

          }
        }
      wrapper(1, l)
    }
  }

  object p17 {

    println("(*) Split a list into two parts. The length of the first part is given. Use a Tuple for your result.")

    def split(size: Int, l: List[Any]): (List[Any], List[Any]) = {
      l match {
        case Nil => (Nil, l)
        case x :: xs => size > 0 match {
          case true  => (x :: split(size - 1, xs)._1, split(size - 1, xs)._2)
          case false => (split(size, xs)._1, l)
        }
      }
    }
  }

  object p18 {

    /** Given two indices, I and K, the slice is the list containing the elements from and including the
      * I-th element up to but not including the Kth element of the original list. Start counting the elements with 0.
      * Example:
      *
      * scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      * res0: List[Symbol] = List('d, 'e, 'f, 'g)
      *
      */
    println("(**) Extract a slice from a list.")
    //we just use the implementation of split defined earlier...
    import p17.split

    def slice(i: Int, k: Int, l: List[Any]): List[Any] = {
      split(k - i, split(i, l)._2)._1
    }

  }

  object p19 {

    println("(**) Rotate a list N places to the left.")

    /** scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      * res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
      * scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
      * res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
      */

    // we use the existing implementation of split 
    import p17.split
    def rotate(n: Int, l: List[Any]): List[Any] = {
      split(n, l)._2 ++ split(n, l)._1
    }
  }

  object p20 {

    println("(*) Remove the Kth element from a list.")

    /** scala> removeAt(1, List('a, 'b, 'c, 'd))
      * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
      */
    import p17.split
    import p05.reverse

    def removeAt(i: Int, l: List[Any]): (List[Any], _) = {
      if (i > l.length - 1) throw new IllegalArgumentException
      i match {
        case 0 => (l.tail, l.head)
        case x => {
          val sl = split(x, l)
          val removed = sl._2.head
          (sl._1 ++ sl._2.tail, removed)
        }
      }
    }
  }

  object p21 {

    println("(*) Insert an element at a given position into a list.")

    /** scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
      * res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
      */
    import p17.split
    import p05.reverse
    def insertAt(elem: Any, i: Int, l: List[Any]): List[Any] = {
      i match {
        case 0 => elem :: l
        case x => {
          val sl = split(i, l)
          sl._1 ++ List(elem) ++ sl._2
        }
      }
    }
  }

  object p22 {

    println("(*) Create a list containing all integers within a given range.")

    def range(from: Int, to: Int): List[Int] = {
      if (from < Integer.MIN_VALUE ||
        from > Integer.MAX_VALUE ||
        to < Integer.MIN_VALUE ||
        to > Integer.MAX_VALUE) throw new IllegalArgumentException();
      from < to match {
        case false => List(to)
        case true  => List(from) ++ range(from + 1, to)
      }
    }
  }

  object p23 {
    println("(**) Extract a given number of randomly selected elements from a list.")

    import p20.removeAt
    import p19.rotate

    def randomSelect(size: Int, l: List[Any]): List[Any] = {
      if (size > l.length) {
        throw new IllegalArgumentException("Number of extracted elements cannot " +
          "be greater than the length of the list")
      }
      size == 1 match {
        case true => List(l.head)
        case false => {
          val rand = new Random(System.nanoTime())
          val extracted = removeAt(rand.nextInt(l.length), l)
          extracted._2 :: randomSelect(size - 1, extracted._1)
        }
      }
    }
  }

  object p24 {
    println("(*) Lotto: Draw N different random numbers from the set 1..M.")

    import p22.range
    import p23.randomSelect

    def lotto(size: Int, m: Int): List[Any] = {
      randomSelect(size, range(1, m))
    }
  }

  object p25 {

    println("P25 (*) Generate a random permutation of the elements of a list.")
    import p23.randomSelect
    def randomPermute(l: List[Any]): List[Any] = {
      randomSelect(l.length, l)
    }
  }

  object p26 extends App {

    println("(**) Generate the combinations of K distinct objects chosen from the N elements of a list.")

    /** scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
      * res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
      */

    //to-do: implement with lists signature as per above example

    def combinations(k: Int, nSet: Set[Any]): Set[Set[Any]] = {
        def enumerate(outSet: Set[Any], k: Int, inSet: Set[Any]): Set[Set[Any]] = {
          if (k == 0) {
            Set(outSet)
          } else {
            { for (x <- inSet) yield enumerate(outSet + x, k - 1, inSet - x) }.flatten
          }
        }
      enumerate(Set(), k, nSet)
    }

  }
}