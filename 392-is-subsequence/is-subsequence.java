class Solution {
    public boolean isSubsequence(String str1, String str2) {
         int ptr1 = 0, ptr2 = 0;
  while (ptr1 < str1.length() && ptr2 < str2.length()) {
    if (str1.charAt(ptr1) == str2.charAt(ptr2)) {
        ptr1++;
    }
    ptr2++;
}
return ptr1 == str1.length();
    }
}