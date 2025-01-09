// 2185. Counting Words With a Given Prefix - {E}

// You are given an array of strings words and a string pref.

// Return the number of strings in words that contain pref as a prefix.

// A prefix of a string s is any leading contiguous substring of s.

class Solution {
    public int prefixCount(String[] words, String pref) {
        // int count=0;
        // for (String s :words) {
        //     if (pref.length() > s.length()) continue;
        //     String k=s.substring(0,pref.length());
        //     if (k.equals(pref)) count++;
        // }
        // return count;

        int count=0;

        for (String s : words) {
            if (check(pref,s)) count++;
        }
        return count;
    }

    private boolean check(String s,String pattern) {
        int m=pattern.length();
        int n=s.length();
        if (n > m) return false;

        int[] lps=kmp(pattern);

        int i=0;
        int j=0;

        while (i < m) {
            if (pattern.charAt(i) == s.charAt(j)) {
                i++;
                j++;
            }

            if (j == n) {
                return true;
            } else if (i < m && pattern.charAt(i) != s.charAt(j)) {
                if (j != 0) {
                    j=lps[j-1];
                } else {
                    return false;
                }
            }

        }
        return false;
    }

    private int[] kmp(String pattern) {
        int l=pattern.length();

        int[] lps=new int[l];

        int len=0;
        int i=1;

        while (i < l) {
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