package reserveList;

import java.util.List;

public class ReserveLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode point1= head;
        ListNode point2 = head;
        ListNode flag = null;
        if (head == null || m == n){
            return head;
        }
        for (int i = 0; i < m-1; i++){
            flag = point1;
            point1 = point1.next;
        }
        point2 = point1;
        if (point1 == null){
            return head;
        }
        for (int i = 0; i < n-m; i++){
            point2 = point2.next;
        }
        ListNode pre = point2.next;
        ListNode end = point2.next;
        ListNode cur = point1;
        ListNode next = null;
        while (cur != end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (flag == null){
            return pre;
        }
        else {
            flag.next = pre;
            return head;
        }
    }
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode point1= head;
        ListNode point2 = head;
        ListNode flag = null;
        if (head == null || m == n){
            return head;
        }
        for (int i = 0; i < m-1; i++){
            flag = point1;
            point1 = point1.next;
        }
        point2 = point1;
        if (point1 == null){
            return head;
        }
        for (int i = 0; i < n-m; i++){
            point2 = point2.next;
        }
        ListNode pre = point2.next;
        ListNode end = point2.next;
        ListNode cur = point1;
        ListNode next = null;
        while (cur != end){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (flag == null){
            return pre;
        }
        else {
            flag.next = pre;
            return head;
        }
    }
    public static void main(String[] args){
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        a.next = b;
        ReserveLinkedList2 t = new ReserveLinkedList2();
        t.reverseBetween(a, 1, 2);
    }
}
