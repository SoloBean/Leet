package removeDuplicatesfromSortedListed;

public class RemoveDuplicates82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null ){
            return null;
        }
        if (head.next == null){
            return head;
        }
        int compareVal = head.val;
        ListNode res = null;
        ListNode cat = null;
        ListNode point = head.next;
        int count = 1;
        while (point != null){
            if (point.val == compareVal){
                point = point.next;
                count++;
                continue;
            }
            else {
                if (count == 1){
                    if (res == null){
                        res = new ListNode(compareVal);
                        cat = res;
                    }
                    else {
                        cat.next = new ListNode(compareVal);
                        cat = cat.next;
                    }
                }
                count = 1;
                compareVal = point.val;
                if (point.next == null){
                    break;
                }
                point = point.next;
            }
        }
        if (count == 1){
            if (res == null){
                res = new ListNode(compareVal);
                cat = res;
            }
            else {
                cat.next = new ListNode(compareVal);
                cat = cat.next;
            }
        }
        return res;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        a.next = b;
        b.next = c;
        RemoveDuplicates82 t = new RemoveDuplicates82();
        ListNode res = t.deleteDuplicates(a);
        ListNode point = res;
        while (point != null){
            System.out.println(point.val);
            point = point.next;
        }
    }
}
