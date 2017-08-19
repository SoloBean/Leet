package offer;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] arg){
        HasCycle t = new HasCycle();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode f = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        f.next = c;
        if (t.hasCycle(a)){
            System.out.print("true");
        }
    }
}
