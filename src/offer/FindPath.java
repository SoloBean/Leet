package offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        LinkedList<TreeNode> road = new LinkedList<>();
        LinkedList<Integer> sum = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        sum.addFirst(0);
        ArrayList<Integer> list = new ArrayList<>();
        DFS(root, target, sum, list, res);
        return res;
    }
    public void DFS(TreeNode root, int target, LinkedList<Integer> sum, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> res){
        int a = sum.getFirst();
        int b = a + root.val;
        if (root.left == null && root.right == null){
            if (b == target){
                sum.addFirst(b);
                list.add(root.val);
                ArrayList<Integer> tmp = new ArrayList<>(list);
                res.add(tmp);
            }
            else {
                sum.addFirst(0);
                list.add(0);
            }
            return ;
        }
        if (b > target){
            return ;
        }
        list.add(root.val);
        sum.addFirst(b);
        if (root.left != null){
            DFS(root.left, target, sum, list, res);
            list.remove(list.size()-1);
            sum.removeFirst();
        }
        if (root.right != null){
            DFS(root.right, target, sum, list, res);
            list.remove(list.size()-1);
            sum.removeFirst();
        }
    }
}
