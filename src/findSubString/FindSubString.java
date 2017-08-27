package findSubString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int size = words[0].length();
        int length = words.length;
        if (s.length() < size * length){
            return res;
        }
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tmp = new HashMap<>();
        for (int i = 0; i < words.length; i++){
            if (map.containsKey(words[i])){
                map.put(words[i], map.get(words[i]) + 1);
            }
            else {
                map.put(words[i], 1);
            }
        }
        for (int i = 0; i <= s.length() - size * length; i++){
            tmp.clear();
            int j = 0;
            for (; j < length; j++){
                String cmp = s.substring(i + j*size, i + j*size+size);
                if (!map.containsKey(cmp)){
                    break;
                }
                if (tmp.containsKey(cmp)){
                    tmp.put(cmp, tmp.get(cmp) + 1);
                }
                else {
                    tmp.put(cmp, 1);
                }
                if (tmp.get(cmp) > map.get(cmp)){
                    break;
                }
            }
            if (j == length){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args){
        FindSubString t = new FindSubString();
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        t.findSubstring(s, words);
    }
}
