// 459. Repeated Substring Pattern - {E}

// Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        int[] lps=kmp(s);
        int len=lps[n-1];
        return len > 0 && n% (n - len) == 0;
    }

    private int[] kmp(String pattern) {
        int m=pattern.length();

        int[]lps=new int[m];

        int len=0;
        int i=1;

        while (i < m){ 
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i]=len;
                i++;
            } else {
                if (len != 0) {
                    len=lps[len-1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}