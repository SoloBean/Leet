package offer;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length != cost.length){
            return -1;
        }
        if (gas.length == 0 || cost.length == 0){
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < gas.length; i++){
            sum += (gas[i] - cost[i]);
        }
        if (sum < 0 ){
            return -1;
        }
        sum = 0;
        int begin = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += (gas[i] - cost[i]);
            if (sum < 0){
                begin = i+1;
                if (begin >= gas.length){
                    return -1;
                }
                sum = 0;
            }
        }
        return begin;
    }
}
