package kedaxunfei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String tmp = in.nextLine();
        int N = Integer.valueOf(tmp);
        List[] course = new List[50];
        int[] res = new int[50];
        boolean flag = false;
        for (int i = 0; i < N; i++){
            String[] str = in.nextLine().split(" ");
            int a = Integer.valueOf(str[0]);
            if (course[a] == null){
                course[a] = new ArrayList();
                course[a].add(str[1]);
            }else {
                course[a].add(str[1]);
                flag = true;
                res[a] = 1;
            }
        }
        if (flag){
            for (int i = 0; i < 50; i++){
                if (res[i] == 1 ){
                    if (i < 10){
                        System.out.print("0" + i);
                    }
                    else{
                        System.out.print(i);
                    }
                    for (int j = 0; j < course[i].size(); j++){
                        System.out.print(" " + course[i].get(j));
                    }
                    System.out.println();
                }
            }
        }
        else {
            System.out.println("YES");
        }
    }
}
