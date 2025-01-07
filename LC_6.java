// 6. Zigzag Conversion -{M} 

// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"

// Write the code that will take a string and make this conversion given a number of rows:

class Solution {
    public String convert(String s, int r) {
        char[] c=s.toCharArray();
        int len=s.length();
        StringBuffer[] s1=new StringBuffer[r];
        for (int i=0;i<s1.length;i++) s1[i]=new StringBuffer();

        int i=0;

        while (i<len) {
            for (int j=0;j<r && i< len ;j++) {
                s1[j].append(c[i++]);
            }

            for (int j=r-2;j>=1 && i <len;j--) {
                s1[j].append(c[i++]);
            }
        }

        for (int j=1;j<s1.length;j++) {
            s1[0].append(s1[j]);
        }
        return s1[0].toString();
    }
}