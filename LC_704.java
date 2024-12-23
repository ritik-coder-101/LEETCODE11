// 704. Binary Search- {E}

// Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

// You must write an algorithm with O(log n) runtime complexity.

class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while (left <= right) {
            int mid=left+(right-left)/2;
            if (nums[mid] > target) {
                right=mid-1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                left=mid+1;
            }
        }
        return -1;
    }
}