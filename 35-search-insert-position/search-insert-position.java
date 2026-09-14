class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int index = n;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return index;
    }
}