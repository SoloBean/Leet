package offer;

import java.util.ArrayList;

public class PreOrder {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        preOrder(root, res);
        return res;
    }
    public void preOrder(TreeNode root, ArrayList<Integer> res){
        if (root == null) {
            return ;
        }
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }
}
