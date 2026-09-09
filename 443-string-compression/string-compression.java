class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;
        int write = 0;
        while (i < n) {
            char current = chars[i];
            int j = i;
            while (j < n && chars[j] == current) {
                j++;
            }
            int count = j - i;
            chars[write] = current;
            write++;
            if (count > 1) {
                String countString = String.valueOf(count);
                for (int k = 0; k < countString.length(); k++) {
                    chars[write] = countString.charAt(k);
                    write++;
                }
            }
            i = j;
        }
        return write;
    }
}
