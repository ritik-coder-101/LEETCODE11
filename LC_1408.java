// 1408. String Matching in an Array - {E}

// Given an array of string words, return all strings in words that is a substring of another word. You can return the answer in any order.

// A substring is a contiguous sequence of characters within a string

class Solution {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, (a,b) -> a.length() - b.length());
        List<String> list=new ArrayList<>();

        for (int i=0;i<words.length;i++) {
            for (int j=i+1;j<words.length;j++) {
                if (words[j].contains(words[i])) {
                    list.add(words[i]);
                    break;
                }
            }
        }
        return list; 
    }  
}