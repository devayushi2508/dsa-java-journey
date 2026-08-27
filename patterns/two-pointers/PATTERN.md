# Two Pointers

## When to recognize this pattern
Look for these signals in a problem statement:
- The array/list is sorted, or can be sorted without losing needed info
- You need to find a **pair or triplet** with some sum/difference relationship
- You need to compare **positions relative to each other**, not just isolated values
- You need an **in-place** solution with O(1) extra space (can't afford a hash set)
- Keywords: "pair that sums to X", "closest to X", "palindrome check",
  "remove duplicates in place", "container with most water"

## The core idea
Instead of comparing every element to every other element (O(n²)), use two
pointers that start at opposite ends (or same end, moving at different
speeds) and move **inward based on a decision rule** derived from the
current sum/comparison. Each step eliminates a whole set of pairs from
consideration, not just one.

## Template

```java
Arrays.sort(arr); // only if order doesn't matter for the answer
int left = 0, right = arr.length - 1;

while (left < right) {
    int sum = arr[left] + arr[right];

    if (sum == target) {
        // found it — handle result
        break;
    } else if (sum < target) {
        left++;  // need a bigger sum
    } else {
        right--; // need a smaller sum
    }
}
```

## Common mistakes
- **Sorting when you shouldn't** — if the problem needs original indices
  (like the classic Two Sum), sorting destroys that info unless you track
  indices alongside values.
- **Off-by-one on the loop condition** — `left < right` vs `left <= right`
  matters depending on whether a pointer can pair with itself.
- **Forgetting the "disqualified" case** — twisted problems (see
  `TwistedTwoSum`) often have a condition that *rules out* the naive match,
  and it's easy to accidentally `return` on that case instead of continuing
  the search.
- **Assuming only one valid pointer movement per step** — sometimes both
  pointers need to move (e.g., skipping duplicates in 3Sum variants).

## Problems in this folder

| Problem | Twist | Difficulty | Status |
|---|---|---|---|
| ClassicTwoSum | — (baseline) | Easy | ✅ |
| TwistedTwoSum | Closest sum, exact match disqualified | Medium | ✅ |

See `NOTES.md` for the reasoning/decision log behind each solution.
