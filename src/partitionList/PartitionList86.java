package partitionList;

public class PartitionList86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return null;
        }
        ListNode h1 = null, h2 = null, p1 = null, p2 = null;
        ListNode point = head;
        while (point != null){
            if (point.val < x){
                if (h1 == null){
                    h1 = new ListNode(point.val);
                    p1 = h1;
                }
                else {
                    p1.next = new ListNode(point.val);
                    p1 = p1.next;
                }
            }
            else {
                if (h2 == null){
                    h2 = new ListNode(point.val);
                    p2 = h2;
                }
                else {
                    p2.next = new ListNode(point.val);
                    p2 = p2.next;
                }
            }
            point = point.next;
        }
        if (p1 != null){
            p1.next = h2;
        }
        else {
            h1 = h2;
        }
        return h1;
    }
}
