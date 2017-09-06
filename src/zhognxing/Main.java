package zhognxing;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int length = in.nextInt();
        int[] nums = new int[length];
        for (int i = 0; i < length; i++){
            nums[i] = in.nextInt();
        }
        int K = in.nextInt();
//        int max = 0;
//        for (int i = 0; i < length; i++){
//            int sum = 0;
//            for (int j = i; j < length; j++){
//                sum += nums[j];
//                if (sum % K == 0){
//                    max = Math.max(j - i + 1, max);
//                }
//            }
//        }
//        System.out.print(max);
        Max(nums, K);
    }

    public static  void Max(int[] nums, int K){
        int length = nums.length;
        int[][] dp = new int[length][length];
        int sum = 0;
        int max = 0;
        for (int j = 0; j < length; j++){
            sum += nums[j];
            dp[0][j] = sum;
            if (dp[0][j] % K == 0){
                max = Math.max(j + 1, max);
            }
        }

        for (int i = 1; i < length; i++){
            for (int j = i; j < length; j++){
                dp[i][j] = dp[i-1][j] - dp[i-1][i-1];
                if (dp[i][j] % K == 0){
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        System.out.print(max);
    }
}
