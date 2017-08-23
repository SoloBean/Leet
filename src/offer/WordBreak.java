package offer;

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (dict.contains(s.substring(0,i+1))){
                flag[i] = true;
                continue;
            }
            for (int j = 0; j <= i; j++){
                if (flag[j]){
                    String cmp = s.substring(j+1, i+1);
                    if (dict.contains(cmp)){
                        flag[i] = true;
                        continue;
                    }
                }
            }
        }
        return flag[s.length()-1];
    }
    public boolean[] Flag(String s, List<String> dict){
        boolean[] flag = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++){
            if (i == 0){
                if (dict.contains(s.substring(0,1))){
                    flag[0] = true;
                    continue;
                }
            }
            else {
                if (dict.contains(s.substring(0, i+1))){
                    flag[i] = true;
                    continue;
                }
                else {
                    for (int j = 0; j <= i; j++){
                        if (flag[j]){
                            if (dict.contains(s.substring(j+1,i+1))){
                                flag[i] =true;
                                continue;
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public static void main(String[] arg){
        WordBreak t = new WordBreak();
        String s = "a";
        List<String> dict = new ArrayList<>();
        dict.add("a");
        dict.add("b");
        ArrayList<String> res = new ArrayList<>();
        t.Flag(s, dict);
    }
}
