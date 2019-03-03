import scala.collection.mutable

object FlipMatchVoyage {

  def flipMatchVoyage(root: TreeNode, voyage: Array[Int]): List[Int] = {
    val res = if(root==null){if(voyage.length != 0)  List(-1); else List()}
      else{
      val answerList = mutable.ListBuffer[Int]()
      val stack = mutable.Stack[TreeNode]()
      stack.push(root)
      var voyageIdx = 0
      var continue = true
      while(!stack.isEmpty && voyageIdx<voyage.length && true){
        val node : TreeNode = stack.pop()
        if(node.value==voyage(voyageIdx)){
          voyageIdx = voyageIdx +1
          if(node.left!= null && node.left.value!=voyage(voyageIdx)){
            answerList.+=(node.value)
            stack.push(node.left)
            if(node.right != null) stack.push(node.right)

          }else{
            if(node.right != null) stack.push(node.right)
            if(node.left != null) stack.push(node.left)
          }
        }else continue=false;
      }
      if(voyageIdx!=voyage.length)List(-1)
      else answerList.toList
    }
    return res
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    val left = new TreeNode(2)
    val right = new TreeNode(3)
    root.left = left
    root.right = right

    System.out.println(s"the answer is : ${flipMatchVoyage(root, Array(1, 3, 2)).mkString(", ")}")
  }
}
