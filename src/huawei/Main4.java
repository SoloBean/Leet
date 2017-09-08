package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        int N = in.nextInt(); //people
        int M = in.nextInt(); //wine
        int [] W = new int[N];
        for (int i = 0; i < N; i++){
            W[i] = in.nextInt();
        }
        int [] heap = new int[M];
        Arrays.fill(heap, Integer.MAX_VALUE);
        Main4 main4 = new Main4();
        if (M >= N){
            int max = 0;
            for (int i = 0; i < N; i++){
                max = Math.max(max, W[i]);
            }
            System.out.println(max);
            return ;
        }
        else {
            for (int i = 0 ; i < M; i++){
                heap[i] = W[i];
            }
            Arrays.sort(heap);
            for (int i = M; i < N; i++){
                main4.insert(heap, W[i]);
            }
        }
        int max = 0;
        for (int i = 0; i < M; i++){
            max = Math.max(max, heap[i]);
        }
        System.out.println(max);
    }
    public void insert(int [] heap, int number){
        if (heap[0] == Integer.MAX_VALUE){
            heap[0] = number;
            move(heap, 0);
        }
        else {
            heap[0] += number;
            move(heap, 0);
        }
    }
    public void move(int[] heap, int root){
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        if (left > heap.length && right > heap.length){
            return;
        }
        if (heap[root] <= heap[left] && heap[root] <= heap[right]){
            return;
        }
        else if (left < heap.length && right < heap.length){
            if (heap[left] < heap[right]){
                swap(heap, root, left);
                move(heap, left);
            }
            else {
                swap(heap, root, right);
                move(heap, right);
            }
        }
        else if (left < heap.length && right >= heap.length){
            if (heap[root] > heap[left]){
                swap(heap, root, left);
            }
            return;
        }
        return;
    }
    public void swap(int[] heap, int first, int second){
        int t = heap[first];
        heap[first] = heap[second];
        heap[second] = t;
    }
}
