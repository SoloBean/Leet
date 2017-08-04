package largestRectangleHistogram;

import java.util.Stack;

public class LargestRectangle {
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        if (s.length() <= 1){
            return s;
        }
        for (int i = 1; i < s.length(); i++){
            int front = i-1, behind = i+1;
            if (s.charAt(i) == s.charAt(i-1)){
                front = i-2;
            }
            while (front >= 0 && behind <= s.length()-1 && s.charAt(front) == s.charAt(behind)){
                front--;
                behind++;
            }
            front++;
            behind--;
            if (behind - front + 1 >= max){
                max = behind - front + 1;
                res = s.substring(front, behind+1);
            }
        }
        return res;
    }

    public static void main(String[] arg){
        String tmp = "babad";
        LargestRectangle t = new LargestRectangle();
        String res = t.longestPalindrome(tmp);
        System.out.println(res);
    }
}
