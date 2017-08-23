package offer;

import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] arg){
        CopyRandomList t = new CopyRandomList();
        RandomListNode a = new RandomListNode(-1);
        RandomListNode b = new RandomListNode(1);
        a.next = b;
        t.copyRandomList(a);
    }
}
