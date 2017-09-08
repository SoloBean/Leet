package sogou;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        double[] angles = new double[N];
        int count = 0;
        for (int i = 0; i < N; i++){
            angles[i] = in.nextDouble();
            if (angles[i] <= 180){
                count++;
            }
        }
        if (count == angles.length || count == 0){
            System.out.println(String.format("%.8f", angles[angles.length-1] - angles[0]));
            return;
        }
        Main t = new Main();
        double max = 0;
        for (int i = 0; i < count; i++){
            double optize = t.optizeAngle(angles[i]);
            int j = count;
            while (j < angles.length && angles[j] < optize){
                j++;
            }
            if (j == angles.length || optize == 0.0){
                double first = angles[j-1] - angles[i];
                if (first > 180.0){
                    first = 360.0 - first;
                }
                double second = angles[i] - angles[0];
                max = t.Max(first, second, max);
            }
            else if (angles[j] == optize){
                System.out.println("180.00000000");
                return;
            }
            else {
                double first = angles[j-1] - angles[i];
                double second = 360.0 - angles[j] + angles[i];
                if (second > 180.0) second = 360.0 - second;
                max = t.Max(first, second, max);
            }
        }
        System.out.println(String.format("%.8f", max));
    }

    public double optizeAngle(double angle){
        return (angle + 180.0) % 360.0;
    }

    public double Max(double first, double second, double third){
        if (first >= second && first >= third){
            return first;
        }
        else if (second >= first && second >= third){
            return second;
        }
        return third;
    }
}
