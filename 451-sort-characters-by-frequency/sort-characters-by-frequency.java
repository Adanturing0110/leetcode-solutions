class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[] freq = new int[128];

        // Step 1: count frequencies
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        // Step 2: bucket characters by frequency
        List<Character>[] buckets = new List[n + 1];
        for (int c = 0; c < 128; c++) {
            if (freq[c] > 0) {
                if (buckets[freq[c]] == null) {
                    buckets[freq[c]] = new ArrayList<>();
                }
                buckets[freq[c]].add((char) c);
            }
        }

        // Step 3: build result from highest frequency to lowest
        StringBuilder sb = new StringBuilder();
        for (int f = n; f >= 1; f--) {
            if (buckets[f] == null) continue;
            for (char c : buckets[f]) {
                for (int i = 0; i < f; i++) {
                    sb.append(c);
                }
            }
        }

        return sb.toString();
    }
}