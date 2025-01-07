// 1023. Camelcase Matching - {M}

// Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.

// A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.

class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res=new ArrayList<>();
        for (String s : queries) {
            boolean flag=check(s,pattern);
            res.add(flag);
        }
        return res;
    }

    private boolean check(String s,String s1) {
        int i=0;

        for (int j=0;j<s.length();j++) {
            char c=s.charAt(j);
            if (i < s1.length() && s1.charAt(i) == c) {
                i++;
            } else if (Character.isUpperCase(c)) return false;
        }
        return i == s1.length();
    }
}