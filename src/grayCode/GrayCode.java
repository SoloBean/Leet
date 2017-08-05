package grayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (n == 0){
            list.add(0);
            return list;
        }
        res.add("0");
        res.add("1");
        if (n >= 2){
            for (int i = 2; i <= n; i++){
                int start = res.size()-1;
                int length = res.size();
                while (start >= 0 ){
                    String middle = res.get(start);
                    int midLength = middle.length();
                    int k = i - midLength - 1;
                    String add = "";
                    while (k > 0){
                        add += "0";
                        k--;
                    }
                    String tmp = "1" + add + res.get(start);
                    res.add(tmp);
                    start--;
                }
            }
        }
        for (int i = 0; i < res.size(); i++){
            list.add(binaryCal(res.get(i)));
        }
        return list;
    }
    public int binaryCal(String t){
        int sum = 0;
        for (int i = t.length()-1; i >=0 ; i--){
            int a = 0;
            if (t.charAt(i) == '1'){
                a = 1;
            }
            int b = t.length() - 1 - i;
            sum += (1 << b)*a;
        }
        return sum;
    }

    public static void main(String[] arg){
        GrayCode t = new GrayCode();
        int a = t.binaryCal("101");
        System.out.println(a);
        String tmp = "adba";
    }
}
