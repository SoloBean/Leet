package TrapWater;

import java.util.Stack;

public class TrapWater {
    public int trap(int[] height) {
        int size = height.length;
        if (height.length == 1 || height.length == 0){
            return 0;
        }
        int first = 0;
        int end = 0;
        int sum = 0;
        while (first < size){
            first = firstPosition(height, first);
            if (first >= size - 1){
                break;
            }
            end = first + 1;
            end = endPosition(height, first, end);
            if (end >= size){
                break;
            }
            int minHeight = Math.min(height[first], height[end]);
            for (int i = first+1; i < end; i++){
                sum += minHeight - height[i];
            }
            first = end;
        }
        if (first < size - 1){
            int STOP = first;
            first = size-1;
            while (first > STOP){
                while (first > STOP && height[first] <= height[first-1]){
                    first--;
                }
                if (first <= STOP){
                    break;
                }
                end = first-1;
                while (end > STOP && height[end] < height[first]){
                    end--;
                }
                int minHeight = Math.min(height[end] , height[first]);
                for (int i = end+1; i < first; i++){
                    sum += minHeight - height[i];
                }
                first = end;
            }
        }
        return sum;
    }

    public int firstPosition(int[] height, int begin){
        int size = height.length;
        while (begin+1 < size && height[begin] <= height[begin+1]){
            begin++;
        }
        return begin;
    }
    public int endPosition(int[] height, int first, int end){
        int size = height.length;
        while (end < size && height[end] < height[first]){
            end++;
        }
        return end;
    }
    public static void main(String[] args){
        TrapWater t = new TrapWater();
        int[] height = new int[]{2,6,3,8,2,7,2,5,0};
        System.out.println(t.trap(height));
    }
}
