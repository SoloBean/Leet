package longestValidParentheses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class longestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s.length() <= 1){
            return 0;
        }
        int length = s.length();
        Stack<Integer> stack = new Stack<>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < length; i++){
            if (stack.empty() && s.charAt(i) == ')'){
                start = i+1;
                continue;
            }
            if (s.charAt(i) == '('){
                stack.push(i);
            }
            else {
                stack.pop();
                if (stack.empty()){
                    result = Math.max(result, i - start + 1);
                }
                else {
                    result = Math.max(result, i - stack.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        longestValidParentheses t = new longestValidParentheses();
        String s = ")()())()()(";
        int a = t.longestValidParentheses(s);
        System.out.print(a);
    }
}
