/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1]) {
            //从数列后面往前面，找到第一个非逆序的数（i是其下标）
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while(i <= j && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        //将从 i+1 开始往后的数字进行翻转
        reverse(nums, i+1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int begin) {
        int l = begin, r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}
// @lc code=end

