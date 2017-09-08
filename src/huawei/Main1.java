package huawei;

import java.util.Scanner;

public class Main1 {
    public static void cal(String str) {
        int max = 0;
        String resultStr = null;
        int count = 0;
        int startIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= '0' && c <= '9') {
                count++;
            } else {
                if (count >= max && count != 0) {
                    max = count;
                    resultStr = str.substring(startIndex, i);
                }
                count = 0;
                startIndex = i + 1;
            }
        }
        if (count >= max && count != 0) {
            max = count;
            resultStr = str.substring(startIndex);
        }
        if (resultStr == null){
            System.out.println("");
        }
        else{
            System.out.println(resultStr);
        }
        //System.out.println(resultStr == null ? "" : resultStr);
        System.out.print(max);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        cal(str);
    }
}
