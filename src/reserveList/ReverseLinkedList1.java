package reserveList;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList1 {
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head == null){
            return head;
        }
        ListNode point = head;
        while (point != null){
            list.add(point.val);
            point = point.next;
        }
        ListNode res = new ListNode(list.get(list.size()-1));
        point = res;
        if (list.size() >= 2){
            for (int i = list.size()-2; i >= 0; i--){
                int a = list.get(i);
                point.next = new ListNode(a);
                point = point.next;
            }
        }
        return res;
    }
    public ListNode reverseList1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
