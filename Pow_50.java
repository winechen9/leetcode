public class Pow_50 {
    /*
    注意corner case，当n == 1时，不管怎么样都是1.
     */
    public double myPow(double x, int n) {
        if(x == 0 || x == 1 || n == 1) return x;
        if(n == 0) return 1;
        if(n < 0) return 1 / (x * myPow(x, -(n + 1)));//防溢出，因为MIN_VALUE的绝对值比MAX_VALUE大1
        double res = 1;
        //System.out.println("n: " + n);
        while(n > 1){
            if(n % 2 == 1){
                res *= x;
                n--;
            }
            x *= x;
            n /= 2;
            //System.out.println("num: " + num + "n: " + n);
        }
        //System.out.println("res * num: "+ res);
        return res * x;
    }
}
