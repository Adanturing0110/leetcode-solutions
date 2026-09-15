import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0, windowSum = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int n = nums.length;

        for (int right = 0; right < n; right++) {
            // add current element
            windowSum += nums[right];
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            // if window exceeds size k, remove leftmost element
            if (right >= k) {
                int leftVal = nums[right - k];
                windowSum -= leftVal;
                freq.put(leftVal, freq.get(leftVal) - 1);
                if (freq.get(leftVal) == 0) {
                    freq.remove(leftVal);
                }
            }

            // check window of size k with all distinct elements
            if (right >= k - 1 && freq.size() == k) {
                maxSum = Math.max(maxSum, windowSum);
            }
        }

        return maxSum;
    }
}