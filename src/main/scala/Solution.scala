class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
object Solution {
  def middleNode(head: ListNode): ListNode = {
    def iter(res: ListNode, lookAhead: ListNode) : ListNode = lookAhead match {
      case x : ListNode => if(x.next == null) res else iter(res.next, x.next.next)
      case null => res
    }
    iter(head, head)
  }
  def mkString(head: ListNode): String = {
    def iter(ln: ListNode, res : String) : String = {
      ln match {
        case t: ListNode => if( t.next == null) res + t.x.toString else iter(t.next, res + t.x.toString+", ")

      }
    }
    iter(head, "")
  }


  def main(args: Array[String]): Unit = {
    val t5 = new ListNode(5)
    val t4 = new ListNode(4)
    val t3 = new ListNode(3)
    val t2 = new ListNode(2)
    val t1 = new ListNode(1)
    val head = new ListNode(0)
//    head.next = t1
//    t1.next = t2
//    t2.next = t3
//    t3.next = t4
//    t4.next = t5

    println(s"the list is : ${mkString(head)}")
    println(s"The middle node: ${middleNode(head).x}")
  }
}
