package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.length() == 0){
            return res;
        }
        char[] arrays = str.toCharArray();
        Arrays.sort(arrays);
        boolean[] used = new boolean[str.length()];
        helper(0, arrays, "", res, used);
        return res;
    }
    public void helper(int length, char[] arrays, String tmp, ArrayList<String> res, boolean[] used){
        if (length >= arrays.length){
            res.add(tmp);
            return ;
        }
        for (int i = 0; i < arrays.length; i++){
            if (!used[i]){
                if (i > 0 && arrays[i] == arrays[i-1]){
                    if (!used[i-1]) {
                        continue;
                    }
                }
                StringBuilder sb = new StringBuilder(tmp);
                sb.append(arrays[i]);
                used[i] = true;
                helper(length+1, arrays, sb.toString(), res, used);
                sb.deleteCharAt(sb.length()-1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args){
        Permutation t = new Permutation();
        String srt = "aa";
        t.Permutation(srt);
    }
}
