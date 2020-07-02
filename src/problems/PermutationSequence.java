package problems;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            digits.add(i);
        }
        return recur(n, k, digits, new StringBuilder());
    }

    public String recur(int n, int k, List<Integer> digits, StringBuilder returnString) {
        if (n == 1) {
            returnString.append(digits.get(n - 1));
            return returnString.toString();
        }
        int blockSize = factorial(n - 1);
        int index = k / blockSize;
        if (k % blockSize == 0) {
            index -= 1;
        }
        returnString.append(digits.get(index));
        digits.remove(index);
        k -= (blockSize * index);
        return recur(n - 1, k, digits, returnString);
    }

    public int factorial(int n) {
        int total = n;
        for (int i = n-1; i > 0; i--) {
            total *= i;
        }
        return total;
    }

    public static void main(String[] args) {

        /*
        The set [1,2,3,...,n] contains a total of n! unique permutations.

        By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

        "123"
        "132"
        "213"
        "231"
        "312"
        "321"

        Given n and k, return the kth permutation sequence.

        Note:

        Given n will be between 1 and 9 inclusive.
        Given k will be between 1 and n! inclusive.

        Example 1:

        Input: n = 3, k = 3
        Output: "213"

        Example 2:

        Input: n = 4, k = 9
        Output: "2314"
         */

        /*
        Plan:

        1. We have a recursive function, a list of Strings containing our permutations, and a boolean[][]
           to track what chars we've added.
        2. Our base case is if the size of our list is k-1 and if the currentString is of length n, and our list does
           not contain it, we return the String.


         */

        /*
        Problems:

        1. The above plan is not tenable and exceeds time limit.
        2. We need to implement this math trick strategy.

           blockSize = n-1!
           int Index = k/((n-1)!)
           ans += char[digits[index]]
           erase used digit
           update k value = k = factorial[n-1] * index

        3. So we get the blockSize with n-1 factorial. We see that there are n-1 factorial number of permutations where
           the first digit is the same.
        4. Now, we have an answer variable that has n indicies.
        5. The most significant digit in this array is calculated by index = k/((n-1)!).
        6. Now we have a digits array with all the possible digits that can be part of the permutations, and we choose
           the value at the index we calculated and add it to our return variable.
        7. Then we update the digits array by removing that value, maybe we have a List<Integer> instead so we can update
           the list more easily.
        8. Now we update k by subtracting this iterations number of blocks * the size of each block = index * blockSize.
        9. We are  done with that iteration, so we decrement n by 1, but we need something else: a boundary check.
        10. We need to update the index, and when we updated k, in the example where k-14, we subtracted index * blockSize
            to get rid of those possibilities, and we are now in the possibility space of block at index 2, and we need
            to update the most significant digit.
        11. So to do this we have a boundary check that says, if k modulo 2 == 0, index-=1.
        12. The other base case is if n == 1, and in that case you just add digitsArray[n-1] and return your answer.
         */

        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(3, 1));
    }
}

/*
Answer:

 */
