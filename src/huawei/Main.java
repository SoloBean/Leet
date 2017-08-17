package huawei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        String[] str = tmp.split(" ");
        String str1 = str[0];
        String str2 = str[1];
        if (str1.length() != str2.length()){
            System.out.println("-1");
            return;
        }
        Main t = new Main();
        System.out.print(t.MaxSame(str1, str2));
    }

    public int MaxSame(String a, String b){
        int max = 1;
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            if (i == 0){
                if (a.charAt(i) == '0' || b.charAt(i) == '0'){
                    return -1;
                }
            }
            if (isVaild(a.charAt(i)) && isVaild(b.charAt(i))){
                if (a.charAt(i) == b.charAt(i)){
                    count++;
                }
                else {
                    if (count > max){
                        max = count;
                    }
                    count = 0;
                }
            }
            else {
                return -1;
            }
        }
        if (count > max){
            max = count;
        }
        return max;
    }
    public boolean isVaild(char c){
        if (c >= '0' && c <= '9'){
            return true;
        }
        return false;
    }
}
