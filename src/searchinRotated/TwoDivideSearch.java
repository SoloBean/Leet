package searchinRotated;

public class TwoDivideSearch {
    public int search(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while (l <= r){
            int middle = (l + r)/2;
            if (nums[middle] == target){
                return middle;
            }
            if (nums[middle] < target){
                l = middle+1;
            }
            else {
                r = middle-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,7,9};
        TwoDivideSearch t = new TwoDivideSearch();
        int res = t.search(nums, 7);
        System.out.println(res);
    }
}
