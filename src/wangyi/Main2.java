package wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public int findKthLargest(int[] nums, int k){
        if(k < 1 || nums == null)
            return 0;
        return getKth(nums.length - k + 1, nums, 0, nums.length-1);
    }

    private int getKth(int k, int[] nums, int start, int end) {
        // TODO Auto-generated method stub

        int pivot = nums[end];

        int left = start;
        int right = end;

        while(true){

            while(nums[left] < pivot && left < right){
                left++;
            }

            while(nums[right] >= pivot && right > left){
                right--;
            }

            if(left == right)
                break;

            swap(nums, left, right);
        }

        swap(nums, left, end);

        if(k == left + 1){
            return pivot;
        }else if(k < left + 1){
            return getKth(k, nums, start, left - 1);
        }else{
            return getKth(k, nums, left + 1, end);
        }
    }

    private void swap(int[] nums, int left, int right) {
        // TODO Auto-generated method stub
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int K = in.nextInt();
        String[] tmp = str.split(" ");
        int[] nums = new int[tmp.length];
        for (int i = 0; i < nums.length; i++){
            nums[i] = Integer.valueOf(tmp[i]);
        }
        Main2 t = new Main2();
        System.out.println(t.findKthLargest(nums, K));
    }
}
