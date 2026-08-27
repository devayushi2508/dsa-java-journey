# Notes & Decision Log — Two Pointers

### ClassicTwoSum
- Brute force is the obvious starting point, but it's worth writing anyway
  as a baseline to reason about the speed-up later.
- The HashMap approach only works in one pass because we check for the
  *complement* before inserting the current number — this avoids using
  the same index twice by construction, not by an extra check.
- Tradeoff: O(n) time for O(n) space. Worth stating explicitly in an
  interview — brute force is O(1) space, so this is a real tradeoff,
  not a strictly better solution.

### TwistedTwoSum (closest sum, exact match disqualified)
- **Why HashMap breaks down here:** the standard trick is "does the
  complement exist in what I've seen?" — but here, finding the exact
  complement is a *disqualifying* event, not a success event. That
  inverts the whole design of the one-pass HashMap approach, so I moved
  to sort + two pointers instead.
- **Aha moment:** two pointers give you a *monotonic* way to explore sums
  — moving `left` up only increases the sum, moving `right` down only
  decreases it. That means you can deliberately steer away from the
  disqualified exact match without losing track of "closeness," which a
  HashMap can't easily give you (it just tells you existence, not
  direction).
- **Edge case I initially missed:** what if *every* pair in the array
  sums to exactly the target? Then there's no valid answer at all. Added
  a `foundAny` flag to catch this instead of silently returning a
  default pair.
- **Open question for later:** could this be extended to "closest sum
  within a max allowed distance" instead of just "closest sum overall"?
  That would need an early-exit condition once `bestDistance` hits some
  threshold — worth revisiting once I do the Sliding Window folder.
