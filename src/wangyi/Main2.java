package wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    int sum = 0;
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        Main2 t = new Main2();
        t.helper(n, k, -1, 0);
        System.out.println(t.sum);
    }
    public void helper(int n, int k, int before, int num){
        if (num == n){
            sum++;
            return ;
        }
        for (int i = 1; i <= k; i++){
            if (before == -1){
                helper(n, k, i, num+1);
            }
            else {
                if (before <= i){
                    helper(n, k, i, num+1);
                }
                else if (before > i){
                    if (before % i != 0){
                        helper(n, k, i, num+1);
                    }
                }
                continue;
            }
        }

    }
}
