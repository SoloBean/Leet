package didi;

import java.util.*;

class Range{
    int l;
    int r;
    public Range(int left, int right){
        this.l = left;
        this.r = right;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            List<Range> ranges = new ArrayList<Range>();
            for(int i = 0; i < n; i++){
                int number = arr[i];
                if(number == 0){
                    ranges.add(new Range(i, i));
                }else{
                    for(int j = i+1; j < n; j++){
                        number ^= arr[j];
                        if(number == 0){
                            ranges.add(new Range(i, j));
                            break;
                        }
                    }
                }
            }
            MyComparator cmp = new MyComparator();
            Collections.sort(ranges, cmp);
            int count = 0;
            int right = 0;
            for(int i = 0; i < ranges.size(); i++){
                Range a = ranges.get(i);
                if(a.l >= right){
                    count++;
                    right = a.r+1;
                }
            }
            System.out.println(count);
        sc.close();
    }
}

class  MyComparator implements Comparator<Range>{
    public int compare(Range first, Range second){
        return first.r - second.r;
    }
}


