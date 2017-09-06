package zhognxing;

import java.util.Arrays;
import java.util.Scanner;

public class Next {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int count = 0;

        count = in.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++){
            nums[i] = in.nextInt();
        }
        Next t = new Next();
        t.getResult(nums);

//        while (in.hasNext()) {
//            count = in.nextInt();
//            int[] num = new int[count];
//            for (int i = 0; i < count; i++) {
//                num[i] = in.nextInt();
//            }
//            // printArray(num);
//            getResult(num);
//
//        }
    }

    public  void getResult(int[] num) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int len = num.length;
        for (int i = 0; i < len; i++) {
            sum = sum + num[i];
            max = Math.max(max, num[i]);
        }
        max = max << 1;
        if (max <= sum) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

}
