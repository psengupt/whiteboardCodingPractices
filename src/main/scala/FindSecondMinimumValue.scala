/*
Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
 */
class TreeNode(var _value: Int) {
   var value : Int = _value
   var left: TreeNode = null
   var right: TreeNode = null

  override def toString: String = {
    val lStr = if(left==null)"" else left.toString
    val rStr = if(right==null)""else right.toString
    value + "(" + lStr + ")" +"("+rStr+")"
  }
}
object  FindSecondMinimumValue {
  var intMax = -1
  var nextMax = -1
  def findSecondMinimumValue(root: TreeNode): Int = {
    (root, intMax, nextMax) match {
      case (null, _, n: Int) => nextMax
      case (t: TreeNode, -1, _) => {
        intMax = t.value
        findSecondMinimumValue(t.right)
      }
      case (t: TreeNode, i: Int, _) => {
        if (i < t.value) {
          nextMax = intMax
          intMax = t.value
          findSecondMinimumValue(t.right)
        } else {
          findSecondMinimumValue(t.right)
        }
      }

    }
  }

    def main(args: Array[String]): Unit = {
      val head = new TreeNode(2)
      val headLeft = new TreeNode(2)
      val headRight = new TreeNode(2)
      val t1 = new TreeNode(7)
      val t1Right = new TreeNode(10)
      val left = new TreeNode(10)
      val right = new TreeNode(10)
      head.left = headLeft
      head.right = headRight
      headRight.left = t1
      headRight.right = t1Right
      t1Right.left = left
      t1Right.right = right

      println(s"The result: ${findSecondMinimumValue(head)}")
    }


}
