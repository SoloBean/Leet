package removeDuplicatesfromSortedListed;

public class RemoveDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode res = new ListNode(head.val);
        ListNode cat = res;
        ListNode point = head.next;
        int cmpVal = head.val;
        while (point != null){
            if (point.val == cmpVal){
                point = point.next;
                continue;
            }
            else {
                cmpVal = point.val;
                cat.next = new ListNode(point.val);
                cat = cat.next;
                point = point.next;
            }
        }

        return res;
    }
}
