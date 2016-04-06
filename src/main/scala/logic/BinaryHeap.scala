package logic

import scala.collection.mutable.ArrayBuffer
import scala.annotation.tailrec
/*
 * inspired by {@link https://github.com/garyaiki/Scala-Algorithms/blob/master/src/main/scala/org/gs/queue/PriorityQueue.scala}
*/
class BinaryHeap[T](private val elements: Seq[T] = Seq())(implicit comparator: (T, T) => Boolean) {
  val heap = new ArrayBuffer[T]()
  //add a null root pointer
  heap.append(null.asInstanceOf[T])
  elements.foreach(insert(_))

  /** number of elements in the heap */
  def size: Int = {
    heap.size match {
      case i if i > 0 => i - 1
      case _          => 0
    }
  }

  def isEmpty: Boolean = size <= 1

  private def _comparator(a: Int, b: Int): Boolean = comparator(heap(a), heap(b))

  private def swap(child: Int, parent: Int) {
    val parentVal = heap(parent)
    heap.update(parent, heap(child))
    heap.update(child, parentVal)
  }

  /** move k above its parents while its value is larger */
  private def percolateUp(k: Int) {
      @tailrec
      def loop(i: Int, j: Int) {
        if (i > 1 && _comparator(j, i)) {
          swap(i, j)
          loop(j, j / (2))
        }
      }
    loop(k, k / (2))
  }

  /** move k below the larger of its two children until its value is smaller */
  private def percolateDown(k: Int) {
      @tailrec
      def loop(k: Int): Unit = {
          def calcJ(): Int = {
            val j = k * 2
            val j1 = j + 1
            if ((j1 <= size) && _comparator(j, j1)) j1 else j
          }
        val j = calcJ
        if (j <= size && _comparator(k, j)) {
          swap(k, j)
          loop(j)
        }
      }
    loop(k)
  }

  /** Add key to end of array then percolateUp to ordered position
    *
    * @param key generic element
    */
  def insert(element: T): Unit = {
    heap.append(element)
    percolateUp(size)
  }

  /** Remove max or min element */
  def pop: Option[T] = if (isEmpty) None else {
    swap(1, size)
    val top = heap.remove(size)
    percolateDown(1)
    Some(top)
  }

  /** check parent in position has left child at k * 2, right child at k * 2 + 1 */
  def checkHeap: Boolean = {
      def loop(k: Int): Boolean = {
        val n = size
        if (k > n) true else {
          val left = 2 * k
          val right = 2 * k + 1
          if ((left <= n && _comparator(k, left)) || (right <= n && _comparator(k, right))) false
          else loop(left) && loop(right)
        }
      }
    loop(1)
  }

  /** returns string of keys */
  override def toString: String = {
    val sb = new StringBuilder()
    sb.append(s"BinaryHeap[")
    heap foreach (e => if (e != null) sb append (s"$e"))
    sb.append("]")
    sb.toString
  }

}