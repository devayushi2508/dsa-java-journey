import java.util.Arrays;

/**
 * TWISTED Problem: "Two Sum, Closest Not Equal"
 *
 * Given an array of integers `nums` and an integer `target`,
 * find the pair of numbers whose sum is as CLOSE to target as possible,
 * but the sum is NOT ALLOWED to equal target exactly.
 *
 * If multiple pairs are equally close, return any one of them.
 *
 * Example:
 * Input: nums = [5, 1, 9, 3], target = 10
 * A pair summing to exactly 10 (1 + 9) is DISQUALIFIED.
 * Among the remaining pairs, the closest valid sum has distance 2
 * (e.g. 3 + 9 = 12, or 3 + 5 = 8 -- both are distance 2 from target).
 * Output (one valid answer): [3, 5]  sum = 8, distance = 2
 *
 * Why this is a genuine twist, not just Two Sum:
 * The standard HashMap "does complement exist?" trick breaks down here
 * because finding the *exact* complement is now a disqualifying case,
 * not a success case. You need to track the closest valid sum while
 * still being able to skip the exact match.
 *
 * This pushes you toward a sort + two-pointer approach instead,
 * since two pointers naturally let you move toward or away from
 * the target sum in a controlled way, and easily skip the exact-match
 * case without abandoning the whole search.
 */
public class TwistedTwoSum {

    /**
     * Approach: Sort + Two Pointers
     * 1. Sort the array (we only need VALUES, not original indices,
     *    since the twist is about the sum itself).
     * 2. Use left/right pointers. Compute sum.
     *    - If sum == target: this pair is disqualified. We still need
     *      to move a pointer to explore other pairs, so nudge right
     *      pointer inward (arbitrary choice, must not stall).
     *    - Else, compare |sum - target| to the best distance found so far.
     *    - Move left pointer up if sum < target (increase sum),
     *      move right pointer down if sum > target (decrease sum).
     *
     * Time: O(n log n)  -- dominated by the sort
     * Space: O(1) extra (ignoring the sort's internal space)
     */
    public static int[] closestNotEqual(int[] nums, int target) {
        if (nums.length < 2) {
            throw new IllegalArgumentException("Need at least two numbers");
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = 0, right = sorted.length - 1;
        int bestLeftVal = sorted[0], bestRightVal = sorted[1];
        int bestDistance = Integer.MAX_VALUE;
        boolean foundAny = false;

        while (left < right) {
            int sum = sorted[left] + sorted[right];

            if (sum == target) {
                // Disqualified: exact match not allowed.
                // Shrink the window from the right to try a different sum.
                right--;
                continue;
            }

            int distance = Math.abs(sum - target);
            if (distance < bestDistance) {
                bestDistance = distance;
                bestLeftVal = sorted[left];
                bestRightVal = sorted[right];
                foundAny = true;
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        if (!foundAny) {
            throw new IllegalArgumentException("No valid pair found (all sums equal target)");
        }

        return new int[] { bestLeftVal, bestRightVal };
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 9, 3 };
        int target = 10;

        int[] result = closestNotEqual(nums, target);
        int sum = result[0] + result[1];
        System.out.println("Closest valid pair: [" + result[0] + ", " + result[1] + "]"
                + " -> sum = " + sum + ", distance = " + Math.abs(sum - target));
    }
}
