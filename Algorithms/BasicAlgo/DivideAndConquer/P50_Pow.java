package BasicAlgo.DivideAndConquer;

public class P50_Pow {
    //o(logn)
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        } 
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = helper(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }  
}