package logic

import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue
import scala.collection.mutable.MapBuilder

/**
 * @author juri
 */
class HuffmanTree[T, K](private val elements: Seq[(T, K)] = List())(implicit ord: Ordering[K], addT: (T, T) => T, addK: (K, K) => K) {

  final case class Node[T, K](root: (T, K), left: Option[Node[T, K]], right: Option[Node[T, K]])

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

  def depth(n: Node[T, K] = huffmanTree) = {
    def wrapper(n: Node[T, K], levels: Int): Int = n match {
      case Node(root, None, None) => levels
      case Node(root, Some(left), None) => wrapper(left, levels)
      case Node(root, None, Some(right)) => wrapper(right, levels)
      case Node(root, Some(left), Some(right)) => wrapper(left, wrapper(right, levels+1))
    }
    wrapper(n, 0)
  }

  def prettyPrint: String = {
    val sb = new StringBuilder()
    //breadth-first traversal
    val q = new Queue[Node[T, K]]()
    if(huffmanTree != null){
      q.enqueue(huffmanTree)
      sb.append("\n")
      var counter: Int = 0
      while(q.size > 0) {
        sb.append(q.map(e => e.root))
        val n =  q.dequeue()
        if(n.left.isDefined){
          //sb.append(n.left.get.root.toString)
          q.enqueue(n.left.get)
        }
        if(n.right.isDefined){
          //sb.append(n.right.get.root.toString)
          q.enqueue(n.right.get)
        }
        counter = counter + 1
        sb.append(s"\ncounter: $counter\n")
      }
    }
    sb.toString
  }

  override def toString = {
    s"HuffmanTree: root = ${huffmanTree.root}"
  }
}

object HuffmanTree {
  def main(args: Array[String]): Unit = {
    type Pair = (String, Int)
    implicit def pairComparator(a: Pair, b: Pair) = a._2 < b._2
    implicit def addStrings(a: String, b: String) = a + b
    implicit def addInts(a: Int, b: Int) = a + b
    val elements = List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))
    val ht = new HuffmanTree[String, Int](elements)
    println(ht.prettyPrint)
  }
}