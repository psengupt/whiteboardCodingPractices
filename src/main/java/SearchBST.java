/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value.
Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
*/
public class SearchBST {
    static TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        if(root.value == val)return root;
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);
        if(left!=null)return left;
        else if(right!=null)return right;
        return null;
    }

    public static void main(String[] args){
        TreeNode t3 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode head = new TreeNode(1);
        head.right = t2;
        t2.right = t3;
        TreeNode res = searchBST(head, 2);
        System.out.println("Extracting the subtree of 2: "+ res.toString());

    }
}
