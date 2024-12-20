// 2182. Construct String With Repeat Limit {M}

// You are given a string s and an integer repeatLimit. Construct a new string repeatLimitedString using the characters of s such that no letter appears more than repeatLimit times in a row. You do not have to use all characters from s.

// Return the lexicographically largest repeatLimitedString possible.

// A string a is lexicographically larger than a string b if in the first position where a and b differ, string a has a letter that appears later in the alphabet than the corresponding letter in b. If the first min(a.length, b.length) characters do not differ, then the longer string is the lexicographically larger one.

class Solution {

    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character,Integer> map=new HashMap<>();
        for (char c : s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);

        PriorityQueue<Character> pq=new PriorityQueue<>((a,b) -> b-a);

        for (Map.Entry<Character,Integer> i : map.entrySet()) {
            pq.offer(i.getKey());
        }

        StringBuilder s1=new StringBuilder();

        while (!pq.isEmpty()) {
            char c=pq.poll();
            int count=map.get(c);

            if (count <= repeatLimit) {
                for (int i=0;i<count;i++) {
                    s1.append(c);
                }

                map.remove(c);
            } else {
                for (int i=0;i<repeatLimit;i++) {
                    s1.append(c);
                }

                map.put(c,map.get(c)-repeatLimit);

                if (pq.isEmpty()) return s1.toString();

                char d=pq.poll();
                s1.append(d);
                map.put(d,map.get(d)-1);
                if (map.get(d) == 0) map.remove(d);
                if (map.containsKey(d)) pq.offer(d);
                pq.offer(c);
            }
        }
        return s1.toString();
    }
}