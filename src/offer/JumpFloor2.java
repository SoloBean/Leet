package offer;

public class JumpFloor2 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        if (target == 0){
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i <= target; i++){
            for (int j = 0; j < i; j++){
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }
}
