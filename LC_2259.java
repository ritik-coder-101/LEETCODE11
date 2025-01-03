// 2559. Count Vowel Strings in Ranges -{M}
// You are given a 0-indexed array of strings words and a 2D array of integers queries.
// Each query queries[i] = [li, ri] asks us to find the number of strings present in the range li to ri (both inclusive) of words that start and end with a vowel.
// Return an array ans of size queries.length, where ans[i] is the answer to the ith query.
// Note that the vowel letters are 'a', 'e', 'i', 'o', and 'u'.

class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
         int count=0;
         int[] prefix=new int[words.length+1];
         prefix[0]=count;

         for (int i=0;i<words.length;i++) {
            if (isvowelstring(words[i])) count++;
            prefix[i+1]=count;
         }

         int[] res=new int[queries.length];
         int i=0;

         for (int[] val : queries) {
            res[i++]=prefix[val[1]+1] - prefix[val[0]];
         }
         return res;
    }

    private boolean isvowelstring(String s) {
        return isvowel(s.charAt(0)) && isvowel(s.charAt(s.length()-1));
    }

    private boolean isvowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}