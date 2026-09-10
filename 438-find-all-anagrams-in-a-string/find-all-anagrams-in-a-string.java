import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int c = 0; c < 26; c++) {
            if (sCount[c] == pCount[c]) {
                matches++;
            }
        }

        if (matches == 26) {
            result.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            int addChar = s.charAt(i) - 'a';
            int removeChar = s.charAt(i - pLen) - 'a';

            sCount[addChar]++;
            if (sCount[addChar] == pCount[addChar]) {
                matches++;
            } else if (sCount[addChar] == pCount[addChar] + 1) {
                matches--;
            }

            sCount[removeChar]--;
            if (sCount[removeChar] == pCount[removeChar]) {
                matches++;
            } else if (sCount[removeChar] == pCount[removeChar] - 1) {
                matches--;
            }

            if (matches == 26) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}