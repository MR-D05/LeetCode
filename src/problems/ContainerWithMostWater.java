package problems;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int maxLength = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                maxLength = Math.max(maxLength, (Math.min(height[i], height[j]) * (j - i)));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {

        /*
        Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical
        lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with
        x-axis forms a container, such that the container contains the most water.

        Example:

        Input: [1,8,6,2,5,4,8,3,7]
        Output: 49
         */

        /*
        Plan:

        1. We will return a maxArea variable as our result.
        2. We need a distance variable that represents the distance between two indices.
        3. We will have two loops over the array and the maxArea variable will be Math.max of Math.min of the two considered
           indices multiplied by the distance between them.
         */
        System.out.print(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

/*
Answer:

    public static int maxArea(int[] height) {

        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                maxArea = Math.max(maxArea, (Math.min(height[i], height[j]) * (j - i)));
            }
        }

        return maxArea;
    }
 */
