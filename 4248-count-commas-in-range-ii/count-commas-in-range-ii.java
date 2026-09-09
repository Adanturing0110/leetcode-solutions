class Solution {
    public long countCommas(long n) {
        long total = 0;
        long start = 1; // first number with current digit length
        int d = 1;      // current digit length
        
        while (start <= n) {
            long end;
            if (start > (Long.MAX_VALUE - 9) / 10) {
                // start * 10 would overflow; since n <= Long.MAX_VALUE,
                // the true end of this digit-length group is beyond n anyway
                end = n;
            } else {
                end = start * 10 - 1;
                if (end > n) end = n;
            }
            
            long count = end - start + 1;
            int commas = (d - 1) / 3;
            total += count * commas;
            
            if (end == n) break;
            start = end + 1; // avoids overflow vs. start * 10
            d++;
        }
        
        return total;
    }
}