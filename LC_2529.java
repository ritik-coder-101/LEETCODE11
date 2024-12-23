// 2529. Maximum Count of Positive Integer and Negative Integer-{E}

// Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

// In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
// Note that 0 is neither positive nor negative.

class Solution {
    public int maximumCount(int[] nums) {
        if (nums[nums.length - 1] < 0 || nums[0] > 0)
            return nums.length;
        if ( nums[0] == 0 && nums[nums.length - 1] == 0)
            return 0;
        int n=nums.length;
        int left=0;
        int right=nums.length-1;
        int poscount=0;
        while (left <= right) {
            int mid=left+(right-left)/2;

            if (nums[mid] > 0 ) {
                poscount=mid;
                right=mid-1;
            } else {
                left=mid+1;
            }
        }
        if (poscount != 0) poscount=n-poscount;

        int negcount=0;
        left=0;
        right=nums.length-1;

        while (left <= right) {
            int mid=left+(right-left)/2;

            if (nums[mid] < 0) {
                negcount=mid;
                left=mid+1;
            } else {
                right=mid-1;
            }
        }
        if (negcount != 0) negcount+=1;
        return Math.max(negcount,poscount);
    }
}