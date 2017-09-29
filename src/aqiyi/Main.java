package aqiyi;
import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int A = in.nextInt();
        int B = in.nextInt();
        if (A > B){
            int tmp = B;
            B = A;
            A = tmp;
        }
        int count = 0;
        for (int i = 1; i <= A; i++){
            for (int j = i; j <= B; j++){
                if (isSqrt(i, j)){
                    count++;
                }
            }
        }
        for (int i = 2; i <= A; i++){
            for (int j = 1; j < i; j++){
                if (isSqrt(j,i)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean isSqrt(int a, int b){
        //b >= a
        int first = (int) Math.sqrt(a);
        int second = (int)Math.sqrt(b);
        if (first * first == a && second * second == b){
            return true;
        }
        if (b / a * a != b) {
            return false;
        }
        else {
            int tmp = (int)Math.sqrt(b/a);
            tmp *= tmp;
            if (tmp == b/a){
                return true;
            }
            else {
                return false;
            }
        }
    }
}