package offer;

public class SubTree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return searchInTree(root1, root2);
    }
    public boolean searchInTree(TreeNode root1, TreeNode root2){
        if (root1 == null){
            return false;
        }
        if (root1.val == root2.val){
            if (isEqual(root1, root2)){
                return true;
            }
        }
        if (searchInTree(root1.left, root2) || searchInTree(root1.right, root2)){
            return true;
        }
        return false;
    }
    public boolean isEqual(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null){
            return true;
        }
        else if (root2 == null){
            return true;
        }
        else if (root1 == null && root2 != null){
            return false;
        }
        if (root1.val == root2.val){
            if (isEqual(root1.left, root2.left)){
                if (isEqual(root1.right, root2.right)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(2^1<<2);
    }
}
