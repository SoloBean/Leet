package TrapWater;

import java.util.Stack;

public class TrapWater {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        if (height.length == 1 || height.length == 0){
            return 0;
        }
        int start = 0;
        if (height[0] == 0){
            while (height[start] == 0){
                start++;
            }
        }
        while (start+1 < height.length && height[start] <= height[start+1]){
            start++;
        }
        start++;
        if (start >= height.length){
            return 0;
        }
        int sum = 0;
        for (int i = start; i < height.length; i++){
            if (height[i] < height[i-1]){
                while (i < height.length && height[i] <= height[i-1]){
                    stack.push(i-1);
                    i++;
                }
                stack.push(i-1);
                if (i == height.length){
                    return sum;
                }
                while (i < height.length && height[i] >= height[i-1]){
                    i++;
                }
                int maxHeight = height[i-1];
                while (stack.size() > 1 && height[stack.peek()] <= maxHeight){
                    stack.pop();
                }
                if (stack.size() == 1){
                    if (height[stack.peek()] <= maxHeight){
                        maxHeight = height[stack.peek()];
                        stack.pop();
                    }
                    for (int j = stack.peek(); j <= i-1; j++){
                        if (maxHeight - height[j] >= 0){
                            sum += maxHeight - height[j];
                        }
                    }
                }
                else {
                    for (int j = stack.peek(); j <= i-1; j++){
                        if (maxHeight - height[j] >= 0){
                            sum += maxHeight - height[j];
                        }
                    }
                }
                i--;
                continue;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        TrapWater t = new TrapWater();
        int[] height = new int[]{5,2,1,2,1,5};
        System.out.println(t.trap(height));
    }
}
