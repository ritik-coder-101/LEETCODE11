// 28. Find the Index of the First Occurrence in a String -{E}

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;

        int m=haystack.length();
        int n=needle.length();

        int[] lps=kmp(needle);

        int i=0;
        int j=0;

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                return i-j;
            } else if (i < m && haystack.charAt(i) != needle.charAt(j)) {
                if (j != 0) {
                    j=lps[j-1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    private int[] kmp(String pattern) {
        int l=pattern.length();

        int[] lps=new int[l];

        int i=0;
        int j=1;

        while (j < l) {
            if (pattern.charAt(j) == pattern.charAt(i)) {
                i++;
                lps[j]=i;
                j++;
            } else {
                if (i != 0) {
                    i=lps[i-1];
                } else {
                    lps[j]=0;
                    j++;
                }
            }
        }
        return lps;
    }
}