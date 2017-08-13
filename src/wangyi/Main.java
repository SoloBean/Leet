package wangyi;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++){
            x[i] = in.nextInt();
        }
        for (int i = 0; i < N; i++){
            y[i] = in.nextInt();
        }
    }
}
