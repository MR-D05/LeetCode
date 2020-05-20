package problems;

import java.util.Arrays;

public class ThreeSumClosest {
    int result = 0;

    public int threeSumClosest(int[] nums, int target) {

        /*
        The idea here is to first sort the nums array.
        Then, loop over the array.

        The algorithm we implement is a sliding window.

        We set 3 variables: first, second, and last.

        First will be position i in the for loop. Second will be i + 1; Last is the last element in the
        array.

        From here we set up a while loop with the condition that while second is less than last we

        create a sum variable that sums our three variables.

        Conditions from here: if the sum equals the target? we set result as the target as we've found that
        there exists 3 elements in the array that sum to the target itself and nothing else can be closer than that!

        next condition is based on the concept of distance.

        distance is the absolute value of the target - sum. We want to set our result tentatively as the
        Math.min of the result's distance and the currently considered sum's distance.

        next condition to progress the while loop is that if the current sum is less than the target we
        increment our "second" variable, as with our sorted array, the leftmost elements are less than the rightmost
        elements.

        Similarly, if the current sum is greater than the target, we decrement the last variable, removing the largest value
        element from the pool.
         */


        Arrays.sort(nums);
        this.result = nums[0] + nums[1] + nums[2];
        recurse(nums, target);
        return this.result;
    }

    public void recurse(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int second = i+1;
            int last = length-1;
            while(second < last) {
                int sum = nums[i] + nums[second] + nums[last];
                if (sum == target) {
                    this.result = target;
                    return;
                }
                if (Math.abs(target - sum) < Math.abs(target - this.result)) {
                    this.result = sum;
                }
                if (sum < target) {
                    second++;
                } else {
                    last--;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
        Example:

        Given array nums = [-1, 2, 1, -4], and target = 1.

        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

        [1,1,1,0]
        -100

        [85,17,99,58,76,-80,68,-38,-74,-75,-88,-31,17,-2,-40,-57,29,-84,-16,-31,-80,-39,58,-33,67,11,38,2,-31,-48,-29,28,-11,-52,86,-86,59,45,68,15,-17,56,34,8,29,69,-93,84,-76,-98,85,59,40,-93,-47,-9,100,51,55,31,-47,-9,-63,-9,-94,32,21,88,60,36,-54,2,42,86,-44,-81,-82,-29,-48,49,77,-19,3,26,-53,35,39,92,-56,77,-59,56,-13,18,-56,-70,81,31,-28,-13,-51,19,86,36,20,7,-2,-52,-14,-10,-70,3,-34,100,90,75,-27,-62,-37,-19,42,68,-56,-94,22,-6,49,-74,76,-11,-18,-71,-46,23,62,-72,35,82,92,27,-10,-38,-9,7,-18,-83,-37,48,-18,98,-80,16,6,-72,-4,45,-99,39,27,-24,31,-48,26,16,32,-56,-14,94,-36,86,30,-21,45,-68,-74,50,-65,39,-25,67,1,-36,61,-2,60,71,-16]
67
         */

        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] nums = {85,17,99,58,76,-80,68,-38,-74,-75,-88,-31,17,-2,-40,-57,29,-84,-16,-31,-80,-39,58,-33,67,11,38,2,-31,-48,-29,28,-11,-52,86,-86,59,45,68,15,-17,56,34,8,29,69,-93,84,-76,-98,85,59,40,-93,-47,-9,100,51,55,31,-47,-9,-63,-9,-94,32,21,88,60,36,-54,2,42,86,-44,-81,-82,-29,-48,49,77,-19,3,26,-53,35,39,92,-56,77,-59,56,-13,18,-56,-70,81,31,-28,-13,-51,19,86,36,20,7,-2,-52,-14,-10,-70,3,-34,100,90,75,-27,-62,-37,-19,42,68,-56,-94,22,-6,49,-74,76,-11,-18,-71,-46,23,62,-72,35,82,92,27,-10,-38,-9,7,-18,-83,-37,48,-18,98,-80,16,6,-72,-4,45,-99,39,27,-24,31,-48,26,16,32,-56,-14,94,-36,86,30,-21,45,-68,-74,50,-65,39,-25,67,1,-36,61,-2,60,71,-16};
        System.out.println(threeSumClosest.threeSumClosest(nums, 67));
    }
}
