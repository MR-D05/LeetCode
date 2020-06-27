package problems;

public class Pow {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return n % 2 == 1 ? x * myPow(x * x, (n - 1) / 2) : myPow(x * x, n / 2);

    }

    public static void main(String[] args) {

        /*
        Implement pow(x, n), which calculates x raised to the power n (xn).

        Example 1:

        Input: 2.00000, 10
        Output: 1024.00000

        Example 2:

        Input: 2.10000, 3
        Output: 9.26100

        Example 3:

        Input: 2.00000, -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25

        Note:

        -100.0 < x < 100.0
        n is a 32-bit signed integer, within the range [−231, 231 − 1]
         */

        /*
        Plan:

        1. If n is negative, we feed into our recursive function 1/x and -n.
        2. If n == 0, return 1.
        3. If n == 1, return x.
        4. Else, if n is odd, return recursive function with x(x*x) and (n-1)/2.
        5. Else, return recursive function with x*x and n/2.
         */

        Pow pow = new Pow();
        System.out.println(pow.myPow(1.00000, -2147483648));
    }
}

/*
Answer:


    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        if (n < 0) {
            x = 1 / x;
            n = -n;
        }

        return n % 2 == 1 ? x * myPow(x * x, (n - 1) / 2) : myPow(x * x, n / 2);

    }
 */
