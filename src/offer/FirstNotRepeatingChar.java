package offer;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] isIn = new int[60];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++){
            int position = str.charAt(i) - 'A';
            isIn[position]++;
            if (isIn[position] == 1){
                q.offer(i);
            }
            else {
                if (q.isEmpty()){
                    continue;
                }
                int pos = q.peek();
                position = str.charAt(pos) - 'A';
                while (isIn[position] > 1){
                    q.poll();
                    if (q.isEmpty()){
                        break;
                    }
                    pos = q.peek();
                    position = str.charAt(pos) - 'A';
                }
            }
        }
        return q.peek();
    }
    public int FirstNotRepeatingChar2(String str) {
        int[] chars = new int[128];
        for(int i = 0; i < str.length(); i ++){
            chars[str.charAt(i)] += 1;
        }

        for(int i = 0; i < str.length(); i ++){
            if (chars[str.charAt(i)] == 1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args){
        FirstNotRepeatingChar t = new FirstNotRepeatingChar();
        String str = "ccba";
        System.out.println(t.FirstNotRepeatingChar2(str));
    }
}
