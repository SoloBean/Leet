package xiaomi;

import java.sql.Statement;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in  = new Scanner(System.in);
        while (in.hasNext()){
            int N = in.nextInt();
            System.out.println(Station(N));
        }
        in.close();
    }

    public static int Station(int N){
        if(N <= 0)
            return 1;
        if(N == 1)
            return 1;
        if(N == 2)
            return 2;
        return Station(N-1)+Station(N-2);
    }
}
