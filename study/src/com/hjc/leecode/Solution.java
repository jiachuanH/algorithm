package com.hjc.leecode;

//力扣  33
public class Solution {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (target == nums[mid]) {
                return mid;
            }else if (nums[mid] >= nums[low]) {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else
                    low = mid + 1;
            } else {
                if (nums[mid] < target && nums[high] >= target) {
                    low = mid + 1;
                } else
                    high = mid - 1;

            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] b = { 4, 5, 6, 7, 0, 1, 2 };
        int search = search(b, 0);
        System.out.println(search);
    }
}
