package offer;

public class SIngleNunber2 {
    public int singleNumber(int[] A) {
        int[] digits = new int[32];
        for (int i = 0; i < 32; i++){
            for (int j = 0; j < A.length; j++){
                digits[i] += (A[j]>>i)&1;
            }
        }
        int sum = 0;
        for (int i = 0; i < 32; i++){
            sum += (digits[i]%2)<<i;
        }
        return sum;
    }
}
