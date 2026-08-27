import java.util.HashMap;
import java.util.Map;

/**
 * Problem: Two Sum
 * Given an array of integers `nums` and an integer `target`,
 * return indices of the two numbers such that they add up to target.
 *
 * Example:
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]   because nums[0] + nums[1] == 9
 *
 * Assumption: exactly one valid answer exists, and you may not use
 * the same element twice.
 */
public class ClassicTwoSum {

    /**
     * Approach 1: Brute Force
     * Check every pair.
     * Time: O(n^2)
     * Space: O(1)
     */
    public static int[] bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution found");
    }

    /**
     * Approach 2: HashMap (one-pass)
     * For each number, check if its complement (target - num) was
     * already seen. If yes, we've found our pair.
     * Time: O(n)
     * Space: O(n)
     */
    public static int[] withHashMap(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }

            seen.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result1 = bruteForce(nums, target);
        System.out.println("Brute force result: [" + result1[0] + ", " + result1[1] + "]");

        int[] result2 = withHashMap(nums, target);
        System.out.println("HashMap result: [" + result2[0] + ", " + result2[1] + "]");
    }
}
