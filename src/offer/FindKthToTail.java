package offer;

import java.util.ArrayList;
import java.util.List;

public class FindKthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        List<ListNode> res = new ArrayList<>();
        ListNode point = head;
        if (head == null){
            return null;
        }
        while (point != null){
            res.add(point);
            point = point.next;
        }
        if (k > res.size() || k == 0){
            return null;
        }
        return res.get(res.size()-k);
    }
}
