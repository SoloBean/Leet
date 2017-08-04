package mergeSortedArray;

public class MergeSortArray88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0){
            return;
        }
        int insert = m+n-1;
        int p1 = m-1;
        int p2 = n-1;
        while (p1 >= 0 && p2 >= 0){
            if (nums1[p1] >= nums2[p2]){
                nums1[insert] = nums1[p1];
                insert--;
                p1--;
            }
            else {
                nums1[insert] = nums2[p2];
                insert--;
                p2--;
            }
        }
        if (p1 < 0){
            while (p2 >= 0){
                nums1[insert] = nums2[p2];
                insert--;
                p2--;
            }
        }
    }

    public static void main(String[] arg){
        int[] nums1 = new int[]{2,0};
        int[] nums2 = new int[]{1};
        MergeSortArray88 t = new MergeSortArray88();
        t.merge(nums1,1, nums2, 1);
    }
}
