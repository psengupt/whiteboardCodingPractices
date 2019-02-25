import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    @Override
    public String toString() {
        String res = val + "";
        for(Node n: children){
            res += "(" +n.toString() + ")";
        }
        return res;
    }
}
public class MaxDepth {
    static int maxDepth(Node root) {
        if(root==null)return 0;
        int max = 0;
        if(root.children != null) {
            for (Node n : root.children) {
                int child = maxDepth(n);
                max = Math.max(child, max);
            }
        }
        return max+1;
    }

    public static void main(String[] args){
        List<Node> children = new ArrayList<>();
        List<Node>grandChildren = new ArrayList<>();
        Node c1 = new Node(); c1.val = 3;children.add(c1);
        Node c2 = new Node(); c2.val = 7;children.add(c2);
        Node c3 = new Node(); c3.val = 5;children.add(c3);
        Node c4 = new Node(); c4.val = 4;grandChildren.add(c3);
        Node c5 = new Node(100, grandChildren); children.add(c5);
        Node head = new Node(1, children);
        System.out.println("The maxHt is : " + maxDepth(head));
    }

}
