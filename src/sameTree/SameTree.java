package sameTree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return front(p, q);
    }

    public boolean front(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        else if (p == null || q == null){
            return false;
        }
        int a = p.val;
        int b = q.val;
        if (a != b){
            return false;
        }
        if (front(p.left, q.left)){
            if (front(p.right, q.right)){
                return true;
            }
        }
        return false;
    }
    public boolean middle(TreeNode p, TreeNode q){
        if (p == null && q == null){
            return true;
        }
        else if (p == null || q == null){
            return false;
        }
        if (middle(p.left, q.left)){
            if (p.val == q.val){
                if (middle(p.right, q.right)){
                    return true;
                }
            }
        }
        return false;
    }
}
