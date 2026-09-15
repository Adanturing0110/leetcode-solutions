class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] avgs = new int[n];

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int window = 2 * k + 1;

        for (int i = 0; i < n; i++) {
            if (i - k < 0 || i + k >= n) {
                avgs[i] = -1;
            } else {
                long sum = prefix[i + k + 1] - prefix[i - k];
                avgs[i] = (int) (sum / window);
            }
        }
        return avgs;
    }
}