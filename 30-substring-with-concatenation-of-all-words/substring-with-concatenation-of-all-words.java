class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = words.length, w = words[0].length();
        if (n < m * w) return res;

        Map<String, Integer> need = new HashMap<>();
        for (String x : words) need.merge(x, 1, Integer::sum);

        for (int off = 0; off < w; off++) {
            int left = off, count = 0;
            Map<String, Integer> win = new HashMap<>();

            for (int right = off; right + w <= n; right += w) {
                String word = s.substring(right, right + w);

                if (need.containsKey(word)) {
                    win.merge(word, 1, Integer::sum);
                    count++;
                    while (win.get(word) > need.get(word)) {
                        String l = s.substring(left, left + w);
                        win.merge(l, -1, Integer::sum);
                        left += w;
                        count--;
                    }
                    if (count == m) {
                        res.add(left);
                        String l = s.substring(left, left + w);
                        win.merge(l, -1, Integer::sum);
                        left += w;
                        count--;
                    }
                } else {
                  
                    win.clear();
                    count = 0;
                    left = right + w;
                }
            }
        }
        return res;
    }
}