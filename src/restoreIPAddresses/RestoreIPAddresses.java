package restoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0){
            return res;
        }
        helper(4, s, "", 0, res);
        return res;
    }
    public void helper(int k, String t, String res, int begin, List<String> list){
        if (k == 1){
            if (begin >= t.length() || (t.charAt(begin) == '0' && begin != t.length()-1) || begin < t.length()-3){
                return ;
            }
            String tmp = t.substring(begin, t.length());
            int a = Integer.parseInt(tmp);
            if (a > 255){
                return;
            }
            res += tmp;
            list.add(res);
        }
        else {
            if (begin >= t.length()){
                return;
            }
            for (int i = 3; i >= 1; i--){
                if (begin + i > t.length()){
                    continue;
                }
                char start = t.charAt(begin);
                if ((start > '2' && i == 3) || (start == '0' && i != 1)){
                    continue;
                }
                String tmp = t.substring(begin, begin + i);
                if (tmp.length()==3){
                    int a = Integer.parseInt(tmp);
                    if (a > 255){
                        continue;
                    }
                }
                String next = res + tmp + ".";
                helper(k-1, t, next, begin+i, list);
                if (tmp.equals("255")){
                    break;
                }
            }
        }
    }

    public static void main(String[] arg){
        RestoreIPAddresses t = new RestoreIPAddresses();
        t.restoreIpAddresses("0000");
        List<Integer>[] hash =  new List[26];
    }
}
