package kedaxunfei;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        if (str.length() == 1){
            System.out.print("1");
            return ;
        }
        else if (str.length() == 2){
            if (str.equals("RL")){
                System.out.print("1");
            }
            else {
                System.out.print("2");
            }
            return;
        }
        else{
            int i = 0;
            char tmp = str.charAt(i);
            while (tmp == 'L'){
                i++;
                if (i >= str.length()) break;
                tmp = str.charAt(i);
            }
            if (i >= str.length()){
                System.out.print(str.length());
                return;
            }
            int j = str.length()-1;
            tmp = str.charAt(j);
            while (tmp == 'R' && j > i){
                j--;
                tmp = str.charAt(j);
            }
            System.out.print(str.length() - j + i);
        }
    }
}
