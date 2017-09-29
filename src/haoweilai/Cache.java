package haoweilai;

import java.util.LinkedList;
class Link{
    char val;
    Link prior;
    Link next;
}

public class Cache {
    Link cache = new Link();
    Link head = cache;
    Link tail = null;
    int length;
    int N = 2;
    int max_length = N;

    public void insert(char a){
        if (length == 0){
            cache.val = a;
            head = cache;
            tail = head;
            return;
        }
        int i = 0;
        Link p = new Link();
        p.val = a;
        p.next = head;
        length++;
        Link point = p.next;
        while (i < length){
            if (p.next.val == a){
                deleteAndPutHead(p);
            }
            i++;
            p = p.next;
        }
        if (length > max_length){
            tail.next = null;
            tail = tail.prior;
        }
    }

    public void deleteAndPutHead(Link node){
        Link point = node.next;
        node.next = point.next;
        point.prior = node;
        point.next = head.next;
        point.prior = head;
        point.next.prior = point;
    }
}
