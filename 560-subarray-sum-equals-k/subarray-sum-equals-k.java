import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1); // empty prefix sum occurs once

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;

            // Check how many times (currentSum - k) has occurred before
            if (prefixCount.containsKey(currentSum - k)) {
                count += prefixCount.get(currentSum - k);
            }

            // Record current prefix sum
            prefixCount.put(currentSum, prefixCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}