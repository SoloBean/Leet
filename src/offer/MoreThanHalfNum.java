package offer;

import java.util.HashMap;
import java.util.Map;

public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = helper(0, array.length-1, array);
        for (int k : map.keySet()){
            if (k != 0){
                return k;
            }
        }
        return 0;
    }
    public Map<Integer, Integer> helper(int begin, int end, int[] array){
        if (end - begin == 0){
            Map<Integer, Integer> map = new HashMap<>();
            map.put(array[begin], 1);
            return map;
        }
        if (end - begin == 1){
            Map<Integer, Integer> map = new HashMap<>();
            if (array[end] == array[begin]){
                map.put(array[end], 2);
            }
            else {
                map.put(0, 0);
            }
            return map;
        }
        int middle = (begin + end)/2;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> left = helper(begin, middle, array);
        Map<Integer, Integer> right = helper(middle+1, end, array);
        if (left.containsKey(0) && right.containsKey(0)){
            map.put(0,0);
            return map;
        }
        else if(left.containsKey(0)){
            int count = 0;
            int key = 0;
            for (int k : right.keySet()){
                key = k;
                for (int i = begin; i <= middle; i++){
                    if (array[i] == k){
                        count++;
                    }
                }
            }
            if (count + right.get(key) <= (end - begin + 1)/2){
                map.put(0,0);
                return map;
            }
            else {
                map.put(key, count + right.get(key));
            }
            return map;
        }
        else if(right.containsKey(0)){
            int count = 0;
            int key = 0;
            for (int k : left.keySet()){
                key = k;
                for (int i = middle+1; i <= end; i++){
                    if (array[i] == k){
                        count++;
                    }
                }
            }
            if (count + left.get(key) <= (end - begin + 1)/2){
                map.put(0,0);
                return map;
            }
            else {
                map.put(key, count + left.get(key));
            }
            return map;
        }
        else {
            int count = 0;
            int key = 0;
            for (int k : right.keySet()){
                key = k;
                for (int i = begin; i <= middle; i++){
                    if (array[i] == k){
                        count++;
                    }
                }
            }
            if (count + right.get(key) > (end - begin + 1)/2){
                map.put(key,count + right.get(key));
                return map;
            }
            for (int k : left.keySet()){
                for (int i = middle + 1; i <= end; i++){
                    if (array[i] == k){
                        count++;
                    }
                }
            }
            if (count + left.get(key)  > (end - begin + 1)/2){
                map.put(key,count + left.get(key));
                return map;
            }
            map.put(0,0);
            return map;
        }
    }
    public int MoreThanHalf(int [] array){
        return partition((array.length)/2, 0, array.length-1, array);
    }
    public int partition(int middle, int begin, int end, int[] array){
        int i = begin;
        int j = end;
        int cmp = array[begin];
        while (i < j){
            while (array[j] >= cmp && j > i){
                j--;
            }
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            while (array[i] < cmp && i < j){
                i++;
            }
            tmp = array[j];
            array[j] = array[i];
            array[i] = cmp;
        }
        if (array[i] == array[middle]){
            int count = 0;
            for (int k = 0; k < array.length; k++){
                if (cmp == array[k]){
                    count++;
                }
            }
            if (count > (array.length)/2){
                return cmp;
            }
            else {
                return 0;
            }
        }
        else if (array[i] > array[middle]){
            return partition(middle, begin, i-1, array);
        }
        else {
            return partition(middle, i+1, end, array);
        }
    }
    public static void main(String[] args){
        MoreThanHalfNum t = new MoreThanHalfNum();
        int[] nums = new int[]{4,2,1,4,2,4};
        int a = t.MoreThanHalf(nums);
        System.out.println(a);
    }
}
