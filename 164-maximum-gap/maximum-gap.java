class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }
        if (min == max) return 0;               

        int range = max - min;
        int size = (range + n - 2) / (n - 1);   
        int bucketCount = range / size + 1;

        int[] bMin = new int[bucketCount];
        int[] bMax = new int[bucketCount];
        java.util.Arrays.fill(bMin, Integer.MAX_VALUE);
        java.util.Arrays.fill(bMax, Integer.MIN_VALUE);

        for (int x : nums) {
            int idx = (x - min) / size;
            bMin[idx] = Math.min(bMin[idx], x);
            bMax[idx] = Math.max(bMax[idx], x);
        }

        int maxGap = 0;
        int prevMax = min;                      
        for (int i = 0; i < bucketCount; i++) {
            if (bMin[i] == Integer.MAX_VALUE) continue;   
            maxGap = Math.max(maxGap, bMin[i] - prevMax);
            prevMax = bMax[i];
        }
        return maxGap;
    }
}