package offer;

import java.util.*;

public class WordBreak2 {
    public ArrayList<String> wordBreak(String s, List<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        if(s==null || s.length()==0)
            return res;
        helper(s,dict,0,"",res);
        return res;
    }
    private void helper(String s, List<String> dict, int start, String item, ArrayList<String> res)
    {
        if(start>=s.length())
        {
            res.add(item);
            return;
        }
        StringBuilder str = new StringBuilder();
        for(int i=start;i<s.length();i++)
        {
            str.append(s.charAt(i));
            if(dict.contains(str.toString())){
                String newItem = new String();
                if(item.length()>0)
                    newItem = item + " " + str.toString();
                else
                    newItem = str.toString();
                helper(s,dict,i+1,newItem,res);
            }
        }
    }

    public static void main(String[] arg){
        WordBreak2 t = new WordBreak2();
        String s = "leetcode";
        List<String> dict = new ArrayList<>();
        dict.add("code");
        dict.add("Leet");
        dict.add("a");
        ArrayList<String> res = new ArrayList<>();
        res = t.wordBreak(s,dict);
        for (String tmp : res){
            System.out.println(tmp);
        }
    }
}
