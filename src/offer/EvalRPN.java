package offer;

import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-")){
                int y = stack.pop();
                int x = stack.pop();
                if (tokens[i].equals("*")){
                    res = x * y;
                }
                else if (tokens[i].equals("/")){
                    res = x / y;
                }
                else if (tokens[i].equals("+")){
                    res = x + y;
                }
                else {
                    res = x - y;
                }
            }
            else {
                String a = tokens[i];
                res = Integer.valueOf(a);
            }
            stack.push(res);
        }
        return stack.peek();
    }

    public static void main(String[] arg){
        EvalRPN t = new EvalRPN();
        String[] tokens = new String[]{"0", "3", "/"};
        int res = t.evalRPN(tokens);
        System.out.println(res);
    }
}
