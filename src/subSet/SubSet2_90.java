package subSet;

import java.util.ArrayList;
import java.util.List;

public class SubSet2_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0){
            return res;
        }
        int cmpVal = nums[0];
        List<Integer> list = new ArrayList<>();
        int[] tmp = new int[nums.length];
        int length = 1;
        list.add(cmpVal);
        tmp[0] = cmpVal;
        for (int i = 1; i < nums.length; i++) {
            list.add(nums[i]);
            if (nums[i] != cmpVal) {
                tmp[length] = nums[i];
                length++;
                cmpVal = nums[i];
            }
        }
        res.add(list);
        for(int i = 1; i <= length; i++){
            back(res, tmp, new ArrayList<>(), 0, length, i);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public void  back(List<List<Integer>> res, int[] nums, List<Integer> list, int index, int length, int k){
        if (k == 0){
            List<Integer> tmp = new ArrayList<>(list);
            res.add(tmp);
        }
        else {
            for (int i = index; i < length-k+1; i++){
                list.add(nums[i]);
                back(res, nums, list, i+1, length, k-1);
                list.remove(list.size()-1);
            }
        }

        String a = "a";
    }
}
