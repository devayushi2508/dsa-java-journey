/**
 * Problem: Find the factorial of n using recursion
 *
 * Example:
 * Input: n = 5
 * Output: 120
 *
 * Approach: Simple recursion
 * - Base case: when n == 0, return 1 (0! = 1 by definition)
 * - Recursive case: return n * factorial(n - 1)
 *
 * Time Complexity: O(n)  -- one recursive call per number from n down to 0
 * Space Complexity: O(n) -- recursion call stack depth
 */
 public class FactorialOfN{
    public static int f (int n ){
        if (n == 0){
            return 1;
        }
       
        int fn = n * f(n -1);
        return fn;
    }
    public static void main(String args[]){
        int n = 5;
        System.out.println(f(n));
    }
 }