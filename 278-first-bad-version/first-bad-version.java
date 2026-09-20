/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2; // avoids integer overflow

            if (isBadVersion(mid)) {
                right = mid; // mid could be the answer, keep it in range
            } else {
                left = mid + 1; // mid is good, answer is after it
            }
        }

        return left; // left == right, this is the first bad version
    }
}