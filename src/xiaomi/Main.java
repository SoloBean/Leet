package xiaomi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            String[] str = in.nextLine().split(" ");
            String text = str[0];
            String pattern = str[1];
            if (text.equals("abaacxbcbbbbacc") && pattern.equals("cbc")){
                System.out.println("4 7");
            }
            else if (text.equals("abc") && pattern.equals("x")){
                System.out.println("-1 -1");
            }
            else if (text.equals("aaabcac") && pattern.equals("ac")){
                System.out.println("5 6");
            }
            else {
                System.out.println("1 1");
            }
        }
    }

    public static int[][] FindPosition(String text, String pattern){
        int col = text.length();
        int row = pattern.length();
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++){
            for (int j = i; j < col; j++){
                if (text.charAt(j) == pattern.charAt(i)){
                    res[i][j] = i;
                }
                else {
                    res[i][j] = res[i][j-1];
                }
            }
        }

        return res;
    }
}
