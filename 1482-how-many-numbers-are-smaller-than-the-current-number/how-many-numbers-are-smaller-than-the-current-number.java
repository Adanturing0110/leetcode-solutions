class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
          int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int cn = 0;

            for (int j = 0; j < nums.length; j++) {

                if (nums[j] < nums[i]) {
                    cn++;
                }
            }

            count[i] = cn;
        }

        return count;
    }
}