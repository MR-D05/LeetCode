package problems;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return x;
        }
        int left = 1;
        int right = x;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            int squared = mid*mid;
            if (squared == x) {
                return mid;
            } else if (squared > x) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (left*left < x && (left+1)*(left+1) > x) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {

        /*
        Implement int sqrt(int x).

        Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

        Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

        Example 1:

        Input: 4
        Output: 2

        Example 2:

        Input: 8
        Output: 2

        Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
         */

        /*
        Plan:

        1. I suppose this approach is binary search?
        2. We will create a while loop, but before we will create two in variables: right and left.
        3. Corner case will be if x == 0, return 0.
        4. Left will be equal to 1, and right will be equal to x.
        5. While left < right, we set a mid variable that is equal to 1 + (right-left)/2.
        6. Now a couple conditions: if mid*mid == x, return mid, else if it is > x, right becomes mid, else, left
           becomes mid.
        7. After this process, we return left if left squared is less than x and left +1 squared is greater otherwise
           we return right.
         */

        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.mySqrt(8));
    }

}

/*
Answer:

 */
