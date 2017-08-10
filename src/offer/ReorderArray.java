package offer;

import java.util.ArrayList;
import java.util.List;

public class ReorderArray {
    public void reOrderArray(int [] array) {
        List<Integer> j = new ArrayList<>();
        List<Integer> o = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0){
                o.add(array[i]);
            }
            else {
                j.add(array[i]);
            }
        }
        for (int i = 0; i < j.size(); i++){
            array[i] = j.get(i);
        }
        for (int i = 0; i < o.size(); i++){
            array[i+j.size()] = o.get(i);
        }
    }
}
