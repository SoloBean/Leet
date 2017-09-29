package mrsa;

import java.util.*;

public class Solution {
    public List<String> answerQueries(int numWords, String[] words, int numQuestion, int[] question){
        List<String> res = new ArrayList<>();
        String[] words_t = new String[numWords];
        for (int i = 0; i < numWords; i++){
            words_t[i] = reverse(words[i]);
        }
        Arrays.sort(words, new MyCompatator());
        Arrays.sort(words_t, new MyCompatator());
        for (int i = 0; i < numQuestion; i++){
            switch (question[i]){
                case 1:
                    res.add(words[0]);
                    break;
                case 2:
                    res.add(words[numWords-1]);
                    break;
                case 3:
                    if (numWords >= 2){
                        res.add(words[numWords-2]);
                    }
                    else {
                        res.add(null);
                    }
                    break;
                case 4:
                    if (numWords >= 2){
                        res.add(words[1]);
                    }
                    else {
                        res.add(null);
                    }
                    break;
                case 5:
                    res.add(words_t[0]);
                    words_t[0] = reverse(words_t[0]);
                    String tmp = words_t[0];
                    Arrays.sort(words_t, new MyCompatator());
                    for (int j = 0; j < numWords; j++){
                        if (words[j].equals(tmp)){
                            words[j] = reverse(words[j]);
                            Arrays.sort(words, new MyCompatator());
                            break;
                        }
                    }
                    break;
            }
        }

        return res;
    }
    public  String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    public class MyCompatator implements Comparator<String>{
        public int compare(String a, String b){
            if (a.equals(b)){
                return 0;
            }
            int i = 0;
            char first = a.charAt(i), second = b.charAt(i);
            while ( i < a.length() && i < b.length() && first == second){
                i++;
                first = a.charAt(i); second = b.charAt(i);
            }
            if (first == second){
                return a.length() < b.length() ? 1:0;
            }
            else if (first < second){
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public static void main(String[] args){
        String[] words = new String[]{"ah", "cb", "ef", "gd"};
        int[] question = new int[]{1,2,3,4,5,1,2,3,4};
        Solution t = new Solution();
        List<String> res = t.answerQueries(4, words, 9, question);
        for (String tmp : res){
            System.out.print(tmp + " ");
        }
    }
}
