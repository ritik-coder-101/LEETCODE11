// 848. Shifting Letters -{M} 

// You are given a string s of lowercase English letters and an integer array shifts of the same length.

// Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').

// For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
// Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.

// Return the final string after all such shifts to s are applied.


// difference array algo
class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int l=s.length();
        long[] suff=new long[l+1];

        for (int i=l-1;i>= 0 ;i--) {
            suff[i]=(suff[i+1]+shifts[i])%26;
        }

        char[] ch=s.toCharArray();
        for (int i=0;i<ch.length;i++) {
            int c=(ch[i] - 'a'+(int)suff[i])%26;
            if (c < 0) c+=26;
            ch[i]=(char)('a'+c);
        }
        return new String(ch);
    }
}