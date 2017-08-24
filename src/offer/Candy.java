package offer;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        if (ratings.length == 1){
            return 1;
        }
        int[] res = new int[ratings.length];
        res[0] = 1;
        for (int i = 1 ; i < ratings.length; i++){
            if (ratings[i] > ratings[i-1]){
                int k = 1;
                while (i < ratings.length && ratings[i] > ratings[i-1]){
                    res[i-1] = k;
                    k++;
                    i++;
                }
                i--;
                res[i] = k;
                continue;
            }
            if (ratings[i] < ratings[i-1]){
                int k = 1;
                int start = i-1;
                while (i < ratings.length && ratings[i] < ratings[i-1]){
                    i++;
                }
                for (int j = i-1; j > start; j--){
                    res[j] = k;
                    k++;
                }
                res[start] = Math.max(res[start], k);
                i--;
                continue;
            }
            if (ratings[i] == ratings[i-1]){
                while (i < ratings.length && ratings[i] == ratings[i-1]){
                    res[i] = 1;
                    i++;
                }
            }
            i--;
            continue;
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++){
            sum += res[i];
        }
        return sum;
    }

    public static void main(String[] args){
        Candy t = new Candy();
        int[] ratings = new int[]{3,2,2,1,2};

        System.out.println(t.candy(ratings));
    }
}
