package offer;

import java.util.ArrayList;

public class PostOrder {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        postOrder(root, res);
        return res;
    }
    public void postOrder(TreeNode root, ArrayList<Integer> res){
        if (root == null){
            return ;
        }
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
