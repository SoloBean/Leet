package offer;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Stack;

public class ConvertTree {
    public TreeNode Convert(TreeNode root){
        convert(root);
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null){
            return pRootOfTree;
        }
        TreeNode left = pRootOfTree.left;
        TreeNode right = pRootOfTree.right;
        //if (left != null){
            TreeNode tmpLeft = convert(left);
            if (tmpLeft != null){
                while (tmpLeft.right != null){
                    tmpLeft = tmpLeft.right;
                }
                tmpLeft.right = pRootOfTree;
            }
            pRootOfTree.left = tmpLeft;
        //}
        //if (right != null){
            TreeNode tmpRight = convert(right);
            if (tmpRight != null){
                while (tmpRight.left != null){
                    tmpRight = tmpRight.left;
                }
                tmpRight.left = pRootOfTree;
            }
            pRootOfTree.right = tmpRight;
        //}
        return pRootOfTree;
    }

    public TreeNode Convert2(TreeNode root){
        if (root == null){
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode point = null;
        point = root;
        TreeNode pre = null, begin = null;
        boolean flag = true;
        while (point != null || !stack.empty()){
            while (point != null){
                stack.push(point);
                point = point.left;
            }
            if (!stack.empty()){
                point = stack.pop();
                if (flag){
                    begin = point;
                    flag = false;
                }
                point.left = pre;
                if (pre != null){
                    pre.right = point;
                }
                pre = point;
                point = point.right;
            }
        }
        return begin;
    }

    public static void main(String[] args){
        TreeNode a = new TreeNode(10);
        TreeNode root = a;
        a = new TreeNode(6);
        root.left = a;
        a = new TreeNode(4);
        root.left.left = a;
        a = new TreeNode(8);
        root.left.right = a;
        a = new TreeNode(14);
        root.right = a;
        a = new TreeNode(12);
        root.right.left = a;
        a = new TreeNode(16);
        root.right.right = a;
        ConvertTree t = new ConvertTree();
        TreeNode tmp = t.Convert2(root);
        while (tmp.right != null){
            System.out.print(tmp.val + " ");
            tmp = tmp.right;
        }
        System.out.println(tmp.val);
        while (tmp.left != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.left;
        }
        System.out.print(tmp.val);
    }
}
