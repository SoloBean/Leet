package offer;

public class ReOrderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return ;
        }
        ListNode point1 = head;
        ListNode point2 = head.next;
        while (point2 != null && point2.next != null) {
            point1 = point1.next;
            point2 = point2.next.next;
        }
        ListNode head2 = point1.next;
        point1.next = null;
        head2 = reserve(head2);
        head = merge(head, head2);
    }

    public ListNode reserve(ListNode head){
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

    public ListNode merge(ListNode left, ListNode right){
        ListNode head = left;
        while (left != null && right != null){
            ListNode tmp = right.next;
            right.next = left.next;
            left.next = right;
            right = tmp;
            left = left.next.next;
        }
        return head;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        ReOrderList t = new ReOrderList();
        t.reorderList(a);
        ListNode point = a;
        while (point != null){
            System.out.print(point.val + ",");
            point = point.next;
        }
    }
}
