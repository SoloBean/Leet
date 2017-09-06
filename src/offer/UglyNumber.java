package offer;

import java.util.ArrayList;
import java.util.List;

public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {
        int[] res = new int[index];
        if (index == 1){
            return 1;
        }
        int position_2 = 0;
        int position_3 = 0;
        int position_5 = 0;
        int num = 1;
        res[0] = 1;
        while (num < index){
            int tmp = min(res[position_2] * 2, res[position_3] * 3, res[position_5]*5);
            res[num] = tmp;
            while (res[position_2]*2 <= res[num]){
                position_2++;
            }
            while (res[position_3] * 3 <= res[num]){
                position_3++;
            }
            while (res[position_5] * 5 <= res[num]){
                position_5++;
            }
            num++;
        }
        return res[index-1];
    }
    public int min(int num1, int num2, int num3){
        if (num1 <= num2 && num1 <= num3){
            return num1;
        }
        else if (num2 <= num1 && num2 <= num3){
            return num2;
        }
        else {
            return num3;
        }
    }

    public static void main(String[] args){
        UglyNumber t = new UglyNumber();
        System.out.print(t.GetUglyNumber_Solution(11));
        System.out.println((int) 'a');
    }
}
