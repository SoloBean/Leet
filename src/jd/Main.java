package jd;

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Long N = in.nextLong();
        if (N <= 2L){
            System.out.println(N);
            return;
        }
        Long i = 2L;
        Long before = 0L;
        Long tmp = cal(i);
        while (tmp <= N){
            before = tmp;
            i++;
            tmp = cal(i);
            if (tmp < before){
                break;
            }
        }
        if (cal(i-1) == N){
            System.out.println(i-1);
        }
        else {
            System.out.println(i);
        }
        //System.out.println(Integer.MAX_VALUE);
    }
    public static Long cal(Long num){
        if (num % 2 == 0){
            return (num>>1) * (num+1);
        }
        else {
            return ((num+1)>>1) * num;
        }
    }
}
