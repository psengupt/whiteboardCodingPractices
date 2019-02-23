class MyLinkedList() {

    /** Initialize your data structure here. */
    trait List[+A]

    case object Nil extends List[Nothing]
    case class Cons[A](hd: A, rest:List[A]) extends List[A]
    private var head: List[Int] = Nil
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    def get(index: Int): Int = {
      def iter(head: List[Int], index: Int) : Int = head match {
        case Nil => -1
        case Cons(hd, t) =>
          if(index == 0) hd
          else iter(t, index-1)
      }
      iter(head, index)
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    def addAtHead(`val`: Int) {
      head = Cons(`val` , head)

    }

    /** Append a node of value val to the last element of the linked list. */
    def addAtTail(`val`: Int) {
      def iter(hd: List[Int], `val` : Int): List[Int] = hd match {
        case Cons(hd, Nil) => Cons(hd, Cons(`val`, Nil))
        case Cons(hd, tail) => Cons(hd, iter(tail, `val`))
      }
      head = iter(head, `val`)
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    def addAtIndex(index: Int, `val`: Int) {
      def iter(hd: List[Int], index: Int, `val`:Int): List[Int] = hd match {
        case Nil =>
          if (index == 0) Cons(`val`, Nil)
          else Nil
        case Cons(h, t) =>
          if(index == 1) Cons(h, Cons(`val`, t))
          else Cons(h, iter(t, index -1, `val`))
      }
      head = iter(head, index, `val`)
    }

  /** Delete the index-th node in the linked list, if the index is valid. */
  def deleteAtIndex(index: Int) {
    def iter(hd: List[Int], index: Int): List[Int] = {
      (hd, index) match {
        case (Nil, _) => Nil
        case (Cons(h, t), 0) => t
        case (Cons(h, Cons(d1, d2)), 1) => Cons(h, d2)
        case (Cons(h, d), k) => Cons(h, iter(d, k - 1))
      }

    }
    head = iter(head, index)
  }
    def mkString(sep: String) : String = {
      def iter(hd: List[Int], sep: String, res: String): String = hd match {
        case Nil => res
        case Cons(h, t) =>
          if(t == Nil) iter(t, sep, res + h.toString)
          else iter(t, sep, res + h.toString + sep)
      }
      iter(head, sep, "")
    }
  }



  /**
    * Your MyLinkedList object will be instantiated and called as such:
    * var obj = new MyLinkedList()
    * var param_1 = obj.get(index)
    * obj.addAtHead(`val`)
    * obj.addAtTail(`val`)
    * obj.addAtIndex(index,`val`)
    * obj.deleteAtIndex(index)
    */
  object LinkedListImplementation {
    def main(args: Array[String]): Unit = {
      var linkedList = new MyLinkedList()

      linkedList.addAtHead(1)
      println(s"the list after adding 1 : ${linkedList.mkString(", ")}")
      linkedList.addAtHead(2)
      println(s"the list after adding 2 : ${linkedList.mkString(", ")}")
      linkedList.addAtTail(3)
      println(s"the list after adding 3 at the tail : ${linkedList.mkString(", ")}")
      linkedList.addAtIndex(1, 4)
      println(s"the list after adding 4 at 1 : ${linkedList.mkString(", ")}")
      println(s"getting element at 1 : ${linkedList.get(1)}")
      linkedList.deleteAtIndex(1)
      println(s"the list after deleting the element at 1 : ${linkedList.mkString(", ")}")

    }

}
