package wangyi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt();
        if (N == 0){
            System.out.println("0");
            return;
        }
        int[] a = new int[N];
        for (int i = 0; i < N; i++){
            a[i] = in.nextInt();
        }
        int start = 0;
        int count = 0;
        int cmp = 0;
        if (a[0] == 0){
            count++;
            start = 1;
        }
        for (int i = 1; i < N; i++){
            if (a[i] == a[i-1] || a[i] == 0){
                start = i+1;
                count++;
            }
            else {
                int res = a[i];
                for (int j = i-1; j >= start; j--){
                    res = res ^ a[j];
                    if (res == 0){
                        count++;
                        start = i+1;
                        continue;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
