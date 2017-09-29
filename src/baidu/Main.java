package baidu;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int sum = 0;
        int res[] = new int[k];
        PriorityQueue<Integer> list= new PriorityQueue<>();
        for (int i = 0;  i< k; i++){
            sum += arr[i];
            list.add(arr[i]);
        }
        System.out.print(sum + " ");
        for (int i = k; i < n; i++){
            if (arr[i] > list.peek()){
                sum = sum - list.poll() + arr[i];
                list.add(arr[i]);
            }
            System.out.print(sum + " ");
        }
        System.out.println();
    }

}
