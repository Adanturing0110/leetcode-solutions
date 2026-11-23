class Solution {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int h : heights) {
            count[h]++;
        }

        int ans = 0;
        int curr = 1;

        for (int i = 0; i < heights.length; i++) {
            while (count[curr] == 0) {
                curr++;
            }
            if (heights[i] != curr) {
                ans++;
            }
            count[curr]--;
        }
        return ans;
    }
}