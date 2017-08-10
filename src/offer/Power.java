package offer;

public class Power {
    public double Power(double base, int exponent) {
        if (base == 0){
            return 0;
        }
        if (exponent == 0){
            return 1;
        }
        if (exponent < 0){
            return myPower(1/base, -1*exponent);
        }
        else {
            return myPower(base, exponent);
        }
    }
    public double myPower(double base, int exponent){
        if (exponent == 1){
            return base;
        }
        double v = myPower(base, exponent/2);
        if (exponent % 2 == 0){
            return v*v;
        }
        else {
            return v*v*base;
        }
    }
}
