package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CopyRandomList {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode point = head;
        List<RandomListNode> list = new ArrayList<>();
        while (point != null){
            list.add(point);
            point = point.next;
        }
        RandomListNode[] headTmp = new RandomListNode[list.size()];
        point = head;
        int i = 0;
        while (point != null){
            headTmp[i] = new RandomListNode(point.label);
            point = point.next;
            i++;
        }
        point = head;
        int[] position = new int[list.size()];
        i = 0;
        while (point != null){
            int random = list.indexOf(point.random);
            position[i] = random;
            point = point.next;
            i++;
        }
        RandomListNode p = new RandomListNode(-1);
        point = p;
        for (int k = 0; k < headTmp.length; k++){
            point.next = headTmp[k];
            point = point.next;
            int random = position[k];
            if (random == -1){
                headTmp[k].random = null;
                continue;
            }
            headTmp[k].random = headTmp[position[k]];
        }
        return p.next;
    }
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        RandomListNode point = pHead;
        while (point != null){
            RandomListNode tmp = new RandomListNode(point.label);
            tmp.next = point.next;
            point.next = tmp;
            point = point.next.next;
        }
        point = pHead;
        while (point != null){
            RandomListNode tmp = point.next;
            if (point.random == null){
                point = point.next.next;
                continue;
            }
            tmp.random = point.random.next;
            point = point.next.next;
        }
        RandomListNode head = new RandomListNode(-1);
        head.next = pHead.next;
        point = pHead.next;
        while (point.next != null){
            RandomListNode tmp = point.next.next;
            point.next = tmp;
            point = tmp;
        }
        return head.next;
    }
    public static void main(String[] arg){
        CopyRandomList t = new CopyRandomList();
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        a.random = c;
        b.random = e;
        d.random = b;
        RandomListNode head = t.Clone(a);
        RandomListNode point = head;
        while (point != null){
            System.out.print(point.label + " ");
            point = point.next;
        }
        point = head;
        while (point != null){
            if (point.random == null){
                System.out.print("# ");
            }
            else {
                System.out.print(point.random.label + " ");
            }
            point = point.next;
        }
        Stack<Integer> stack = new Stack<>();
    }
}
