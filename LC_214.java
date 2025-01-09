// 214. Shortest Palindrome -{H}

// You are given a string s. You can convert s to a 
// palindrome
//  by adding characters in front of it.

// Return the shortest palindrome you can find by performing this transformation.

class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0 || s == null ) return s;

        String s1=new StringBuilder(s).reverse().toString();
        String s2=s+'#'+s1;

        int[] lps=kmp(s2);

        int val=lps[s2.length()-1];

        String pre=s1.substring(0,s.length() - val);
        return pre+s;
    }

    private int[] kmp(String pattern) {
        int l=pattern.length();

        int[] lps=new int[l+1];

        int len=0;
        int i=1;

        while (i < l ){
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