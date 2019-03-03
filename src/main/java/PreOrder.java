import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PreOrder {

    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> preorder(Node root) {
        preOrderHelper(root);
        return ans;
    }
    public void preOrderHelper(Node root){
        if(root==null)return;
        else {
            ans.add(root.val);
            if(root.children==null || root.children.isEmpty())return;
            List<Node> children = root.children;
            for(Node child: children){
                preOrderHelper(child);
            }
        }

    }
}
