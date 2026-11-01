class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] rowOf = new int[26];

        for (int i = 0; i < 3; i++) {
            for (char c : rows[i].toCharArray()) {
                rowOf[c - 'a'] = i;
            }
        }

        List<String> res = new ArrayList<>();
        for (String w : words) {
            int row = rowOf[Character.toLowerCase(w.charAt(0)) - 'a'];
            boolean ok = true;
            for (char c : w.toCharArray()) {
                if (rowOf[Character.toLowerCase(c) - 'a'] != row) {
                    ok = false;
                    break;
                }
            }
            if (ok) res.add(w);
        }
        return res.toArray(new String[0]);
    }
}