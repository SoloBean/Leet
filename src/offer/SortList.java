package offer;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        ListNode right = sortList(p1.next);
        p1.next  = null;
        ListNode left = sortList(head);
        head = merge(left, right);
        return head;
    }
    public ListNode merge(ListNode left, ListNode right){
        ListNode head = new ListNode(-1);
        ListNode point = head;
        while (left != null && right != null){
            if (left.val <= right.val){
                point.next = left;
                left = left.next;
            }
            else {
                point.next = right;
                right = right.next;
            }
            point = point.next;
        }
        if (left == null){
            point.next = right;
        }
        else if (right == null){
            point.next = left;
        }
        return head.next;
    }
    public static void main(String[] args){
        SortList t = new SortList();
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);
        a.next = b;
        b.next = c;
        t.sortList(a);
    }
}
