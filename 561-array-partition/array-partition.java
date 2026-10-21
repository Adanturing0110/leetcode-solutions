class Solution {
    public int arrayPairSum(int[] nums) {
        int OFFSET = 10000;
        int[] count = new int[20001];
        for (int x : nums) count[x + OFFSET]++;

        int sum = 0;
        boolean take = true;   // true = this element sits at an even index
        for (int v = 0; v < count.length; v++) {
            while (count[v] > 0) {
                if (take) sum += v - OFFSET;
                take = !take;
                count[v]--;
            }
        }
        return sum;
    }
}