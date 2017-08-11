package offer;

public class FindMInInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int start = 0;
        int end = array.length - 1;
        int middle = start;
        while (start < end - 1){
            if (array[start] >= array[end]){
                middle = (start + end)/2;
            }
            else {
                return array[start];
            }
            if (array[middle] == array[start] && array[middle] == array[end]){
                int min = Integer.MAX_VALUE;
                for (int i = start; i <= end; i++ ){
                    if (array[i] < min){
                        min = array[i];
                    }
                }
                return min;
            }
            if (array[middle] >= array[start]){
                start = middle;
            }
            else if (array[middle] <= array[end]){
                end = middle;
            }
        }
        return array[end];
    }
}
