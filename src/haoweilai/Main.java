package haoweilai;

import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int a){this.val = a;}
}

public class Main {
    public int Max(TreeNode root){
        int max = 0;
        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        while (root != null || !s.isEmpty()){
            while (root != null){
                s.push(root);
                sum += s.peek().val;
                root = root.left;
            }
            if (sum > max){
                max = sum;
            }
            root = s.peek();
            s.pop();
            sum -= root.val;
            root = root.right;
        }

        return max;
    }
}
