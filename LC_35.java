// 35. Search Insert Position - {M}

// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums[nums.length-1] < target) return nums.length;
        if (nums[0] > target) return 0;
        int left=0;
        int right=nums.length-1;

        while (left<= right) {
            int mid=left+(right - left)/2;

            if (nums[mid] > target) {
                right=mid-1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                left=mid+1;
            }
        }
        return left;
    }
}