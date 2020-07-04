package problems;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Codility {


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

    static class Solution {
        public int solution(int[] A) {
            List<Integer> integerList = new ArrayList<>();
            for (int ints : A) {
                integerList.add(ints);
            }
            BigDecimal product = new BigDecimal(integerList.stream().reduce(1, (x, y) -> x * y));
            return product.signum();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, -2}));
    }

}
