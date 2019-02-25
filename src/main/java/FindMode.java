import java.util.HashSet;
import java.util.Set;

/*Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
Given BST [1,null,2,2],

   1
    \
     2
    /
   2
   return [2]*/
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; left = null; right=null;}

      public String toString() {

        String res = val+"";
        String lStr = (left==null)? "()": left.toString();
        String rStr = (right==null)? "()": right.toString();
        return res + lStr + rStr;

    }
  }
 public class FindMode {
     static int maxFreq = 0;
     static Set<Integer> s = new HashSet<Integer>();
     public static Set<Integer> findMode(TreeNode root) { //return new int[0];
         if(root==null)return s;
         else {
             getFromBranches(root, null);
             return s;
         }
     }
     static int getFromBranches(TreeNode root, TreeNode prev){
         if(root==null)return 0;
         else {
             int left = getFromBranches(root.left, root);
             int right = getFromBranches(root.right, root);
             int freq = left+right+1;
             if(freq>maxFreq) {
                 s = new HashSet<Integer>();
                 s.add(root.val);
                 maxFreq = freq;
             } else if(freq==maxFreq){
                 s.add(root.val);
             }
             if(prev != null){
                 if(prev.val==root.val){
                     return freq;
                 } else {
                     return 0;
                 }
             } else {
                 return 0;
             }
         }
     }

     public static void main(String[] args){
         TreeNode t3 = new TreeNode(2);
         TreeNode t2 = new TreeNode(2);
         TreeNode head = new TreeNode(1);
         head.right = t2;
         //t2.left = t3;

         System.out.print("The modes are: " );
         findMode(head).forEach(x -> System.out.println(x));
     }
}
