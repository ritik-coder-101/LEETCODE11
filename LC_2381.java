// 2381. Shifting Letters II -{M} 

// You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.

// Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').

// Return the final string after all such shifts to s are applied.

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] dif=new int[n+1];

        for (int[] i : shifts) {
            int l=i[0],r=i[1],d=i[2];
            dif[l]+=(d == 1 ? 1  : -1);
            dif[r+1]+=(d == 1 ? -1 : 1);
        }

        int[] move=new int[n];
        int count=0;

        for (int i=0;i<n;i++) {
            count+=dif[i];
            move[i]=count;
        }
        char[] s1=s.toCharArray();
        for (int i=0;i<s1.length;i++) {
            int a=(s1[i] -'a'+ move[i])%26;
            if (a < 0) a+=26;
            s1[i]=(char)('a'+a);
        }

        return new String(s1);
    }
}