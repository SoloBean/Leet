import java.util.Scanner;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in

        );
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[m];
            for(int i = 0; i < m; i++){
                a[i] = sc.nextInt();
            }
            int[] re = new int[n];
            int j = 0;
            int i = 0;
            int u = 0;
            re[0] = a[0];
            while(i < n){
//        		System.out.println(i +" " + j);
                int k = re[j] > 0 ? re[j] : a[u];
//        		System.out.println(i +" " + j + " " + k);
                while(k > 0 && i < n){
                    re[i] = a[u];
                    i++;
                    k--;
                }
                u++;
                j++;
                u %= m;
            }
            for(i = 0; i < n; i++){
                System.out.print(re[i]+" ");
            }
        }
        sc.close();
    }

}
