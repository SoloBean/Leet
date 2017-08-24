package offer;

import huawei.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JumpStep {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        JumpStep t = new JumpStep();
        System.out.println(t.helper(N, M));
    }
    public int helper(int N, int M){
        int[] dp = new int[M+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;
        for (int i = N; i <= M ; i++){
            if (dp[i] == Integer.MAX_VALUE){
                dp[i] = 0;
                continue;
            }
            List<Integer> yue = yue(i);
            if (yue == null){
                continue;
            }
            for (int step : yue){
                if (i + step > M){
                    break;
                }
                dp[i+step] = Math.min(dp[i+step], dp[i]+1);
            }
        }
        if (dp[M] == 0){
            return -1;
        }
        return dp[M];
    }
    public List<Integer> yue(int num){
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i*i <= num; i++){
            if (num%i == 0){
                res.add(i);
                if (i != num/i){
                    res.add(num/i);
                }
            }
        }
        return res;
    }
}
