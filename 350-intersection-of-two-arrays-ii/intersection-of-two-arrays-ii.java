import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1); 
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums1) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int[] result = new int[nums1.length];
        int k = 0;
        for (int n : nums2) {
            int count = freq.getOrDefault(n, 0);
            if (count > 0) {
                result[k++] = n;
                freq.put(n, count - 1);
            }
        }
        return Arrays.copyOf(result, k);
    }
}