// 3304. Find the K-th Character in String Game I -{E}

// Alice and Bob are playing a game. Initially, Alice has a string word = "a".

// You are given a positive integer k.

// Now Bob will ask Alice to perform the following operation forever:

// Generate a new string by changing each character in word to its next character in the English alphabet, and append it to the original word.
// For example, performing the operation on "c" generates "cd" and performing the operation on "zb" generates "zbac".

// Return the value of the kth character in word, after enough operations have been done for word to have at least k characters.

// Note that the character 'z' can be changed to 'a' in the operation.

class Solution {
    public char kthCharacter(int k) {
        StringBuilder s=new StringBuilder("a");

        while (k > s.length()) {
            char[] c=s.toString().toCharArray();
            for (int i=0;i<c.length;i++) {
                int a=(c[i] -'a'+1)%26;
                if (a < 0) a+=26;
                c[i]=(char)('a'+a);
            }
            s.append(new String(c));
        }
        return s.charAt(k-1);
    }
}