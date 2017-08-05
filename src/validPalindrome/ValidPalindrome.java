package validPalindrome;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.length() == 0){
            return true;
        }
        int front = 0, end = s.length()-1;
        while (front <= end){
            while (front <= end && !isValid(s.charAt(front))){
                front++;
            }
            if (front > end){
                return true;
            }
            while (end >= front && !isValid(s.charAt(end))){
                end--;
            }
            if (end < front){
                return false;
            }
            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))){
                return false;
            }
            front++;
            end--;
        }
        return true;
    }

    public boolean isValid(char a){
        if (Character.isLetter(a) || Character.isDigit(a)){
            return true;
        }
        return false;
    }
}
