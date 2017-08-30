package distinctDistance;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (t.length() == 0 || s.length() < t.length()){
            return 0;
        }
        int slength = s.length();
        int tlength = t.length();
        int[][] dp = new int[tlength][slength];
        int[] count = new int[slength];
        Map<Character, Integer> map = new HashMap<>();
        int[] countT = new int[tlength];
        for (int i = 0; i < tlength; i++){
            char a = t.charAt(i);
            if (!map.containsKey(a)) {map.put(a, 0);count[i] = 0;}
            else {
                countT[i] = map.get(a)+1;
                map.put(a, count[i]);
            }
        }
        if (s.charAt(0) == t.charAt(0)){
            dp[0][0] = 1;
        }
        for (int j = 1; j < slength; j++){
            if (s.charAt(j) != t.charAt(0)){
                dp[0][j] = dp[0][j-1];
            }
            else {
                dp[0][j] = dp[0][j-1] + 1;
            }
        }
        for (int i = 1; i < tlength; i++){
            //int round = count[i];
            int number = countT[i];
            int k = -1;
            for (int j = 0; j < slength; j++){
                if (s.charAt(j) != t.charAt(i)){
                    if (j == 0){
                        continue;
                    }
                    dp[i][j] = dp[i][j-1];
                }
                else {
                    k++;
                    if (k >= number){
                        int sum = 0;
                        for (int m = k, n = j; m >= number && n > 0; n--){
                            if (s.charAt(n) != t.charAt(i)){
                                continue;
                            }
                            else {
                                sum += dp[i-1][n-1];
                                m--;
                            }
                        }
                        dp[i][j] = sum;
                    }
                }
            }
        }
        return dp[tlength-1][slength-1];
    }

    public static void main(String[] args){
        DistinctSubsequences cl = new DistinctSubsequences();
        String s = "aabb";
        String t = "aab";
        System.out.print(cl.numDistinct(s,t));
    }
}
