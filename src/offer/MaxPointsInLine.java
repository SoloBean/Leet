package offer;

public class MaxPointsInLine {
    public int maxPoints(Point[] points) {
        if (points.length <= 1){
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length-1; i++){
            for (int j = i+1; j < points.length; j++){
                int sum = 0;
                int xdis = (points[i].x - points[j].x);
                int ydis = (points[i].y - points[j].y);
                for (int k = 0; k < points.length; k++){
                    if (points[k].x == points[i].x && points[k].y == points[i].y){
                        sum++;
                        continue;
                    }
                    if (points[k].x == points[j].x && points[k].y == points[j].y){
                        sum++;
                        continue;
                    }
                    if (isLine(points[i], points[k], xdis, ydis)){
                        sum++;
                    }
                }
                if (sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }
    public boolean isLine(Point base, Point cmp, int lam, int bei){
        int ymore = cmp.y - base.y;
        int xmore = cmp.x - base.x;
        if (xmore == lam && xmore == 0){
            return true;
        }
        else if ((double)ymore/xmore == (double)bei/lam){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Point a= new Point(0, 0);
        Point b = new Point(-1, -1);
        Point c = new Point(2,2);
        Point[] points = new Point[]{a,b,c};
        MaxPointsInLine t = new MaxPointsInLine();
        int res = t.maxPoints(points);
        System.out.println(res);
    }
}
