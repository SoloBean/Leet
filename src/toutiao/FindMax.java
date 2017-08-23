package toutiao;

import java.lang.reflect.Array;
import java.util.*;

class Node {
    int x;
    int y;
    double angle;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class MyCompatator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        if (o1.x > o2.x){
            return -1;
        }
        else if (o1.x < o2.x){
            return 1;
        }
        else {
            return 0;
        }
    }
}

public class FindMax {
    int maxY = 0;


    public List<Node> Input(){
        Scanner in = new Scanner(System.in

        );
        int line = in.nextInt();
        List<Node> node = new ArrayList<>();
        for (int i = 0; i < line; i++){
            int x = in.nextInt();
            int y = in.nextInt();
            if (y > maxY){
                maxY = y;
            }
            node.add(new Node(x,y));
        }
        return node;
    }

    public void SortbyAngle(List<Node> nodes){
        MyCompatator t = new MyCompatator();
        nodes.sort(t);
    }

    public static void main(String[] args){
        FindMax t = new FindMax();
        List<Node> nodes = t.Input();
        t.SortbyAngle(nodes);
        int i = 0;
        int y = Integer.MIN_VALUE;
        for (Node tmp : nodes){
            if (tmp.y > y){
                System.out.println(tmp.x + " " + tmp.y);
                y = tmp.y;
            }
            if (tmp.y == t.maxY){
                break;
            }
        }
    }
}

