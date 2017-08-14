package offer;

public class InsertSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode flag = new ListNode(-1);
        flag.next = head;
        ListNode point = head.next;
        ListNode cmp = head;
        while (point != null){
            if (point.val >= cmp.val){
                point = point.next;
                cmp = cmp.next;
            }
            else {
                ListNode insert = flag;
                while (insert.next.val <= point.val){
                    insert = insert.next;
                }
                cmp.next = point.next;
                point.next = insert.next;
                insert.next = point;
                point = cmp.next;
            }
        }
        return flag.next;
    }
}
