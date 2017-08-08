package sameTree;

public class ValidateBinarySearchTree {
    int cmp = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return middle(root);
    }
    public boolean middle(TreeNode root){
        if (root == null){
            return true;
        }
        if (middle(root.left)){
            if (root.val > cmp) {
                cmp = root.val;
                if (middle(root.right)){
                    return true;
                }
            }
        }
        return false;
    }
}
