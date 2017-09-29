package didi;
import java.util.Scanner;

public class FindK{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int K = in.nextInt();
        K--;
        int[] num = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
        }
        int begin = 0, end = str.length-1;
        int tmp = partition(num, begin, end);
        while (tmp != K){
            if (tmp < K) {
                begin = tmp + 1;
                tmp = partition(num, begin, end);
            }
            else{
                end = tmp - 1;
                tmp = partition(num, begin, end);
            }
        }
        System.out.println(num[tmp]);
    }
    public static int partition(int[] num, int begin, int end){
        int cmp = num[begin];
        int i = begin, j = end;
        while (i < j){
            while (i < j && num[j] <= cmp){
                j--;
            }
            num[i] = num[j];
            while (i < j && num[i] > cmp){
                i++;
            }
            num[j] = num[i];
        }
        num[i] = cmp;
        return i;
    }
}
