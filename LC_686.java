// 686. Repeated String Match - {M}

// Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for b​​​​​​ to be a substring of a after repeating it, return -1.

// Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".

class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder s=new StringBuilder(a);
        int count = 1;

        while (s.length() < b.length()) {
            s.append(a);
            count++;
        }

        if (check(s.toString(), b)) return count;
        s.append(a);
        count++;
        if (check(s.toString(), b)) return count;

        return -1;
    }

    private boolean check(String s,String pattern) {
        int m=s.length();
        int n=pattern.length();

        if (n > m) return false;

        int[]lps=kmp(pattern);

        int i=0;
        int j=0;

        while (i< m) {
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } 
            if (j == n) {
                return true;
            } else if (i < m && s.charAt(i) != pattern.charAt(j)) {
                if (j!= 0) {
                    j=lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    private int[] kmp(String pattern) {
        int m=pattern.length();
        int[] lps=new int[m];

        int len=0;
        int i=1;

        while (i < m) {
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