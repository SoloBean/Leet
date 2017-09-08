package offer;

import extendLab.Print;

import java.util.*;

public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++){
            list.add(numbers[i]);
        }
        MyCompatator cmp = new MyCompatator();
        Collections.sort(list, cmp);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++){
            res.append(list.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args){
        PrintMinNumber t = new PrintMinNumber();
        int[] numbers = {1,11,111};
        System.out.println(t.PrintMinNumber(numbers));
    }

}

class MyCompatator implements Comparator<Integer> {
    public int compare(Integer a, Integer b){
        String first = String.valueOf(a);
        String second = String.valueOf(b);
        String firstSecond = first + second;
        String secondFirst = second + first;
        return compareString(firstSecond, secondFirst);
    }

    public int compareString(String first, String second){
        int i = 0;
        while (i < first.length() && first.charAt(i) == second.charAt(i)){
            i++;
        }
        if (i == first.length()){
            return 0;
        }
        else {
            if ((int) first.charAt(i) > (int) second.charAt(i)){
                return 1;
            }
            else {
                return -1;
            }
        }
    }
}
