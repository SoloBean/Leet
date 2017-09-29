package souhu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getSum(nums));
    }
    public static int getSum (int []nums){

        int len = nums.length;
        int [][]dp = new int [len][len];
        for(int i=0;i<len;i++) dp[i][i]=nums[i];
        for(int l =len-2;l>=0;l-- ){

            for(int i=l+1;i<len;i++){
//				j=i+l-1;
//				if(nums[i]==nums[j]){
//					dp[i][j] =dp[i+1][j-1];
//				}else{
//					dp[i][j] = Math.min(nums[i], nums[j])+Math.min(dp[i+1][j], dp[i][j-1]);
//				}

                if(nums[l]==nums[i]) dp[l][i]=2*nums[l]+dp[l+1][i-1];
                else dp[l][i]=Math.min(2*nums[l]+dp[l+1][i], 2*nums[i]+dp[l][i-1]);
            }
        }
        return dp[0][len-1];
    }
}
