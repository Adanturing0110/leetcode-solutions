class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m)
            return false;

        int[] need = new int[26];
        int[] window = new int[26];

        for (int i = 0; i < n; i++) {
            need[s1.charAt(i) - 'a']++;
            window[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] == window[i])
                matches++;
        }

        if (matches == 26)
            return true;

        for (int i = n; i < m; i++) {
            int addChar = s2.charAt(i) - 'a';
            int removeChar = s2.charAt(i - n) - 'a';

            // Add new right character
            window[addChar]++;
            if (window[addChar] == need[addChar])
                matches++;
            else if (window[addChar] == need[addChar] + 1)
                matches--;

            // Remove left character
            window[removeChar]--;
            if (window[removeChar] == need[removeChar])
                matches++;
            else if (window[removeChar] == need[removeChar] - 1)
                matches--;

            if (matches == 26)
                return true;
        }

        return false;
    }
}