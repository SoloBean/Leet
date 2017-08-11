package offer;

public class MergeSortedList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        if (list1 == null){
            return list2;
        }
        else if (list2 == null){
            return list1;
        }
        else {
            ListNode point1 = list1;
            ListNode point2 = list2;
            while (point1 != null && point2 != null){
                ListNode tmp = null;
                if (point1.val <= point2.val){
                    tmp = new ListNode(point1.val);
                    point1 = point1.next;
                }
                else {
                    tmp = new ListNode(point2.val);
                    point2 = point2.next;
                }
                cur.next = tmp;
                cur = cur.next;
            }
            if (point1 == null){
                cur.next = point2;
            }
            else {
                cur.next = point1;
            }
        }
        return head.next;
    }
}
