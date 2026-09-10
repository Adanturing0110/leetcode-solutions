class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        if (matches(need, window)) return true;

        for (int i = n; i < m; i++) {
            window[s2.charAt(i) - 'a']++;              // add new right char
            window[s2.charAt(i - n) - 'a']--;           // remove left char that fell off

            if (matches(need, window)) return true;
        }

        return false;
    }

    private boolean matches(int[] need, int[] window) {
        for (int i = 0; i < 26; i++) {
            if (need[i] != window[i]) return false;
        }
        return true;
    }
}