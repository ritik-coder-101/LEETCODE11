// 1392. Longest Happy Prefix -{H} 

// A string is called a happy prefix if is a non-empty prefix which is also a suffix (excluding itself).

// Given a string s, return the longest happy prefix of s. Return an empty string "" if no such prefix exists.

class Solution {
    public String longestPrefix(String s) {
        int l=s.length();
        int[] lps=new int[l];

        int len=0;
        int i=1;

        while (i < l) {
            if (s.charAt(i) == s.charAt(len) ) {
                len++;
                lps[i]=len;
                i++;
            } else {
                if(len != 0) {
                    len=lps[len-1];
                } else {
                    i++;
                }
            }
        }

        // for (int k : lps) System.out.print(k+" ");

        int a=lps[l-1];

        return a > 0 ? s.substring(0,a) : "";
    }
}