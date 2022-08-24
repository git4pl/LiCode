/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
class Solution {
    // 首尾双指针初版写法
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        for (int i = 0, j = nums.length - 1; i <= j;) {
            if (nums[i] != val) {
                i++;
            } else {
                if (nums[j] == val) {
                    j--;
                } else {
                    nums[i] = nums[j];
                    nums[j] = val;
                    i++;
                }
            }
            ans = i;
        }
        return ans;
    }
    // 首尾双指针优化版本
    public int removeElement1(int[] nums, int val) {
        int i = 0, j = nums.length;
        while(i < j) {
            if (nums[i] == val) {
                nums[i] = nums[j-1];
                j--;
            } else {
                i++;
            }
        }
        return i;
    }
    // 同向双指针
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
// @lc code=end

