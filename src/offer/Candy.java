package offer;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int size = ratings.length;
        if (size == 0){
            return 0;
        }
        if (size == 1){
            return 1;
        }
        int[] res = new int[size];
        res[0] = 1;
        for (int i = 1; i < size; i++){
            if (ratings[i] > ratings[i-1]){
                res[i] = res[i-1] + 1;
            }
            else {
                res[i] = 1;
            }
        }
        for (int i = size-2; i >= 0; i--){
            if (ratings[i] > ratings[i+1]){
                res[i] = Math.max(res[i], res[i+1] + 1);
            }
        }
        int sum = 0;
        for (int i = 0; i < size; i++){
            sum += res[i];
        }
        return sum;
    }

//    public static void main(String[] args){
//        Candy t = new Candy();
//        int[] ratings = new int[]{3,2,1,3,1};
//
//        System.out.println(t.candy(ratings));
//    }
}
