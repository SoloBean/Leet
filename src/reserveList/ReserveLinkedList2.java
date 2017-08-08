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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1){
            return head;
        }
        ListNode prehead = new ListNode(0);
        prehead.next = head;
        ListNode point = prehead;
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        ListNode hong = head;
        int i = 0;
        while (hong != null){
            hong = hong.next;
            i++;
            if (i == k){
                i = 0;
                pre = hong;
                for (int j = 0; j < k; j++){
                    next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                ListNode tmp = point.next;
                point.next = pre;
                point = tmp;
            }
        }
        return prehead.next;
    }
    public static void main(String[] args){
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        a.next = b;
        ReserveLinkedList2 t = new ReserveLinkedList2();
        t.reverseBetween(a, 1, 2);
    }
}
