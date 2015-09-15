package logic

import scala.annotation.tailrec

/**
 * @author juri
 */
class HuffmanTree[T, K](private val elements: Seq[(T, K)] = List())(implicit ord: Ordering[K], addT: (T, T) => T, addK: (K, K) => K) {

  final case class Node[T, K](root: (T, K), left: Option[Node[T, K]], right: Option[Node[T, K]]) {
    override def toString() = {
      s"[root: $root${left.map(p => ", left: " + p.root).getOrElse("")}${right.map(p => ", right: " + p.root).getOrElse("")}]"
    }
  }

  private def sortByFrequency(xl: Seq[Node[T, K]]) = xl.sortWith((a: Node[T, K], b: Node[T, K]) => ord.lt(a.root._2, b.root._2))
  
  val huffmanTree = huffman(elements.flatMap(e => List(Node((e._1, e._2), None, None))))
      
  @tailrec
  private def huffman(nodes: Seq[Node[T, K]]): Node[T, K] = {
    sortByFrequency(nodes) match {
      case Nil      => null
      case x :: Nil => x
      case x :: xs => {
        val left = xs.head
        val root = Node((addT(x.root._1, left.root._1), addK(x.root._2, left.root._2)), Some(x), Some(left))
        huffman(root :: xs.tail)
      }
    }
  }
  
  override def toString = {
   def wrapper(n: Node[T, K]): String = {
     n match {
       case Node(root, Some(left), Some(right)) =>  n.toString + "\n" + wrapper(left) + "\n" + wrapper(right)
       case Node(root, Some(left), None) =>  n.toString + "\n" + wrapper(left)
       case Node(root, None, Some(right)) =>  n.toString + "\n" + wrapper(right)
       case Node(root, None, None) => n.toString
     }
   }
   wrapper(huffmanTree)
  }
  
}