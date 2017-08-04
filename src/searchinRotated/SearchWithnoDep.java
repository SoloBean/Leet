package searchinRotated;

public class SearchWithnoDep {
    public int search(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int l = 0, r = nums.length-1;
        while (l < r-1){
            int middle = (l+r)/2;
            if(nums[l] == target) return l;
            else if(nums[r] == target) return r;
            else if(nums[middle] == target) return middle;
            else {
                if (nums[middle] > nums[l]){
                    if (nums[l] < target && target < nums[middle]){
                        r = middle;
                    }
                    else {
                        l = middle;
                    }
                }
                else {
                    if (nums[middle] < target && nums[r] > target){
                        l = middle;
                    }
                    else {
                        r = middle;
                    }
                }
            }
        }
        if (l >= r-1){
            if(nums[l] != target && nums[r] != target){
                return -1;
            }
            else if (nums[l] == target){
                return l;
            }
            else{
                return r;
            }
        }
        return -1;
    }

    public static void main(String[] arg){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        SearchWithnoDep t = new SearchWithnoDep();
        int res = t.search(nums, 6);
        System.out.println(res);
    }
}
