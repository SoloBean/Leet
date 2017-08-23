package offer;

import java.util.*;

public class WordBreak2 {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
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

    public void helper(String s, List<String> dict, boolean[] flag, String item, ArrayList<String> res, int start){
        if (start >= s.length()){
            res.add(item);
            return ;
        }
        for (int i = start; i < s.length(); i++){
            if (flag[i]){
                if (dict.contains(s.substring(start, i+1))){
                    String cmp = s.substring(start, i+1);
                    String tmp = "";
                    if (start != 0){
                        tmp = " ";
                    }
                    tmp = tmp + cmp;
                    helper(s,dict, flag, item + tmp, res, i+1);
                }
            }
        }
    }

    public ArrayList<String> wordBreak2(String s, List<String> dict){
        ArrayList<String> res = new ArrayList<>();
        if(s==null || s.length()==0)
            return res;
        boolean[] flag = Flag(s, dict);
        if (flag[s.length()-1]){
            helper(s, dict, flag,"",res, 0);
        }
        return res;
    }

    public static void main(String[] arg){
        WordBreak2 t = new WordBreak2();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaa" +
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> dict = new ArrayList<>();
        dict.add("a");
        dict.add("aa");
        dict.add("aaa");
        dict.add("aaaa");
        dict.add("aaaaa");
        dict.add("aaaaaa");
        dict.add("aaaaaaa");
        dict.add("aaaaaaaa");
        dict.add("aaaaaaaaa");
        dict.add("aaaaaaaaaa");
        ArrayList<String> res = new ArrayList<>();
        res = t.wordBreak2(s,dict);
        for (String tmp : res){
            System.out.println(tmp);
        }
    }
}
class Solution {

    List[] c = null;
    int maxs = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> d = new HashSet<>();
        for(String w:wordDict){
            d.add(w);
            maxs = Math.max(maxs,w.length());
        }
        c = new List[s.length()+1];
        return f(s,0,d);
    }


    public List<String> f (String s, int b ,HashSet<String> d){
        if(c[b]!=null){
            return (List<String>)c[b];
        }

        List<String> l =  new ArrayList<>();
        if(d.contains(s.substring(b))){
            l.add(s.substring(b));
        }
        for(int i=b;i<s.length()-1;i++){
            //长度剪枝
            if(i-b+1>maxs){
                break;
            }
            String cur = s.substring(b,i+1);
            if(!d.contains(cur)){
                continue;
            }
            List<String>  l2 = f(s,i+1,d);
            if(l2.size()>0){
                for(String str2:l2){
                    l.add(cur+" "+ str2);
                }
            }
        }

        c[b] = l;
        return l;
    }
}
