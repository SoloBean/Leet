package shenzhou;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] str = in.nextLine().split(",");
        int[] num = new int[str.length];
        for (int i = 0; i < num.length; i++){
            num[i] = Integer.valueOf(str[i]);
        }
        Main2 t = new Main2();
        t.quickSort(num);
        for (int i = 0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
    }

    public void quickSort(int[] num){
        sort(num, 0, num.length-1);
    }
    public void sort(int[] num, int start, int end){
        if (start >= end){
            return;
        }
        int middle = partition(num, start, end);
        sort(num, start, middle-1);
        sort(num, middle + 1 , end);
    }
    public int partition(int[] num, int start, int end){
        int cmp = num[start];
        int i = start, j = end;
        while (i < j){
            while (i < j && num[j] >= cmp){
                j--;
            }
            num[i] = num[j];
            while (i < j && num[i] < cmp){
                i++;
            }
            num[j] = num[i];
        }
        num[i] = cmp;
        return i;
    }
}
