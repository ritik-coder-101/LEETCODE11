// 2270. Number of Ways to Split Array -{M}

// You are given a 0-indexed integer array nums of length n.

// nums contains a valid split at index i if the following are true:

// The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
// There is at least one element to the right of i. That is, 0 <= i < n - 1.
// Return the number of valid splits in nums.

class Solution {
    public int waysToSplitArray(int[] nums) {
        int l=nums.length;
        int count=0;
        long[] prefix=new long[l+1];
        for (int i=0;i<l;i++) {
            prefix[i+1]=prefix[i]+nums[i];
        }

        for (int i=0;i<l-1;i++) {
            if (prefix[i+1] >= (prefix[l] - prefix[i+1])) {
                count++;
            }
        }
        return count;
    }
}