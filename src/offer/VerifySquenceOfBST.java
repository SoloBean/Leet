package offer;

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        return helper(sequence, 0, sequence.length-1);
    }
    public boolean helper(int[] nums, int start, int end){
        if (end - start <= 1){
            return true;
        }
        int i = end-1;
        int cmp = nums[end];
        //遍历的是右子树
        while (i >= start && nums[i] > cmp){
            i--;
        }
        if (!helper(nums, i+1, end-1)){
            return false;
        }
        int j = i;
        //遍历左子树
        while (i >= start && nums[i] < cmp){
            i--;
        }
        //如果没有到头，即在左子树中出现了比根节点大的数字，返回false
        if (i < start){
            return helper(nums, start, j);
        }
        return false;
    }
    public static void main(String[] arg){
        VerifySquenceOfBST t = new VerifySquenceOfBST();
        int[] nums = new int[]{4,8,6,12,16,14,10};
        if (t.VerifySquenceOfBST(nums)){
            System.out.println("yes");
        }
    }
}
