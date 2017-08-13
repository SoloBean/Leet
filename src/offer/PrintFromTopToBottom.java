package offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode tmp = q.poll();
            if (tmp != null){
                q.offer(tmp.left);
                q.offer(tmp.right);
                res.add(tmp.val);
            }
        }
        return res;
    }
    public static void main(String[] args){
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        PrintFromTopToBottom t = new PrintFromTopToBottom();
        t.PrintFromTopToBottom(a);
    }
}
