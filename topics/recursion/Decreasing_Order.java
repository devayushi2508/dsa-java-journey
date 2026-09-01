/**
 * Problem: Print numbers from N down to 1 using recursion
 *
 * Example:
 * Input: n = 10
 * Output: 10 9 8 7 6 5 4 3 2 1
 *
 * Approach: Simple recursion
 * - Base case: when n == 1, print it and stop.
 * - Recursive case: print n, then call the function with (n - 1).
 *
 * Time Complexity: O(n)  -- one call per number from n down to 1
 * Space Complexity: O(n) -- recursion call stack depth
 */
public class Decreasing_Order {

    public static void printDec(int n) {
        // Base case: stop recursion once we hit 1
        if (n <= 1) {
            System.out.print(n);
            return;
        }

        // Print current number, then recurse for the next smaller one
        System.out.print(n + " ");
        printDec(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        printDec(n);
    }
}
