package offer;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            int j = 0;
            for (; j < i; j++){
                if (flag[j]){
                    String cmp = s.substring(j+1, i+1);
                    if (wordDict.contains(s.substring(j+1, i+1))){
                        flag[i] = true;
                        break;
                    }
                }
            }
            if (j >= i){
                String cmp = s.substring(0, i+1);
                if (wordDict.contains(s.substring(0, i+1))){
                    flag[i] = true;
                }
            }
        }
        return flag[s.length()-1];
    }

    public static void main(String[] arg){
        WordBreak t = new WordBreak();
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        ArrayList<String> res = new ArrayList<>();
        if (t.wordBreak(s,dict)){
            System.out.println("yes");
        }
    }
}
