package problems;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        long result = divideLong(Math.abs((long) dividend), Math.abs((long) divisor));
        result = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) result;
    }

    private long divideLong(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor, divideTimes = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            divideTimes += divideTimes;
        }
        return divideTimes + divideLong(dividend - sum, divisor);
    }

    public static void main(String[] args) {

        /*
        Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

        Return the quotient after dividing dividend by divisor.

        The integer division should truncate toward zero, which means losing its fractional part. For example,
        truncate(8.345) = 8 and truncate(-2.7335) = -2.

        Example 1:

        Input: dividend = 10, divisor = 3
        Output: 3
        Explanation: 10/3 = truncate(3.33333..) = 3.

        Example 2:

        Input: dividend = 7, divisor = -3
        Output: -2
        Explanation: 7/-3 = truncate(-2.33333..) = -2.

        Note:

        Both dividend and divisor will be 32-bit signed integers.
        The divisor will never be 0.
        Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
        range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
         */

        /*
        Plan:

        1. Create an int counter variable.
        2. Taking the absolute value of both dividend and divisor, keep subtracting the divisor until the value is less
           than or equal to zero (while (sum > 0)), incrementing the counter after every operation.
        3. Condition will be: if dividend and divisor are both negative, or dividend and divisor are both positive, then
           return counter untouched, else, make counter negative and return that and do that by subtracting counter + counter.
         */

        /*
        Problems:

        1. Trying to take the absolute value of Integer.MAX/MIN does not work and returns as if it did nothing.
        2. The solution is not something we arrived at intuitively, and had to look for it in the discussion thread.
        3. It involves a recursive function.
        4. What we just didn't know is this algorithm that goes like while a sum (initialized to the divisor) plus itself
           is less than or equal to the dividend, sum += sum, and another int varaible, numberOfTimesDivided, is += itself.
        5. Then, we call return numberOfTimesDivided + the recursive function with arguments dividend - sum, and divisor.
        6. The base case is if dividend is less than divisor, return 0, which actually does intuitively make sense to me now.
        7. Now, back in our main function, we say, we take the result from our recursive function, we analyze the conditions
           of whether the dividend is positive and divisor is negative or vice versa to obtain whether the result should be
           positive or negative, and then we say if the dividend is greater than Integer.MAX or less the Integer.MIN, return
           Integer.MAX value.
        8. Finally, cast the result to an int and return it.
         */

        /*
        -2147483648
        -1
         */

        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        //System.out.print(divideTwoIntegers.divide(-2147483648, -1));
        System.out.print(divideTwoIntegers.divide(10, 3));
    }
}

/*
Answer:

    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        long result = divideLong(Math.abs((long) dividend), Math.abs((long) divisor));
        result = (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) ? -result : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) result;
    }

    private long divideLong(long dividend, long divisor) {
        if (dividend < divisor) return 0;
        long sum = divisor, divideTimes = 1;
        while (sum + sum <= dividend) {
            sum += sum;
            divideTimes += divideTimes;
        }
        return divideTimes + divideLong(dividend - sum, divisor);
    }
 */
