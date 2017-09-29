package shenzhou;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if (map.containsKey(tmp)){
                map.put(tmp, map.get(tmp)+1);
            }
            else{
                map.put(tmp, 1);
            }
        }
        List<Character> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (char key : map.keySet()){
            if (map.get(key) == min){
                list.add(key);
            }
            else if (map.get(key) < min){
                list.clear();
                list.add(key);
                min = map.get(key);
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            char tmp = str.charAt(i);
            if (list.indexOf(tmp) == -1){
                res.append(tmp);
            }
        }
        System.out.println(res.toString());
    }
}
