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
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(2);
        c.left = a;
        c.right=b;
        a = new TreeNode(9);
        b = new TreeNode(8);
        b.left = a;
        b.right = c;
        a = new TreeNode(8);
        c = new TreeNode(7);
        a.left = b;
        a.right = c;
        SubTree t = new SubTree();
        TreeNode tmp = new TreeNode(8);
        tmp.left = new TreeNode(9);
        tmp.right = new TreeNode(2);
        t.HasSubtree(a,tmp);
    }
}
