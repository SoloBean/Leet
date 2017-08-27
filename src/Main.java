import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in

        );
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            double second = y*1.0/c;
            double third = z*1.0/d;
            double first =  third*a/x + second*b/y;
            int max = 0;
            if(third >= second && third >= first){
                while(m >= d){
                    max += z;
                    m -= d;
                }
                if(first > second){
                    while(m >= a && n >= b){
                        max += x;
                        m -= a;
                        n -= b;
                    }
                    while(n >= c){
                        max += y;
                        n -= c;
                    }
                }else{
                    while(n >= c){
                        max += y;
                        n -= c;
                    }
                    while(m >= a && n >= b){
                        max += x;
                        m -= a;
                        n -= b;
                    }
                }
            }else if(second > third && second > first){
                while(n >= c){
                    max += y;
                    n -= c;
                }
                if(third > first){
                    while(m >= d){
                        max += z;
                        m -= d;
                    }
                    while(m >= a && n >= b){
                        max += x;
                        m -= a;
                        n -= b;
                    }
                }else{
                    while(m >= a && n >= b){
                        max += x;
                        m -= a;
                        n -= b;
                    }
                    while(m >= d){
                        max += z;
                        m -= d;
                    }
                }
            }else{
                while(m >= a && n >= b){
                    max += x;
                    m -= a;
                    n -= b;
                }
                if(third > second){
                    while(m >= d){
                        max += z;
                        m -= d;
                    }
                    while(n >= c){
                        max += y;
                        n -= c;
                    }
                }else{
                    while(n >= c){
                        max += y;
                        n -= c;
                    }
                    while(m >= d){
                        max += z;
                        m -= d;
                    }
                }
            }
            System.out.println(max);
        }
        sc.close();
    }
}
