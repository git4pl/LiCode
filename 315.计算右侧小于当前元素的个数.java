import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=315 lang=java
 *
 * [315] 计算右侧小于当前元素的个数
 */

// @lc code=start
class Solution {
    // 暴力解法会超出时间限制，时间复杂度过高
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 1) {
            res.add(0);
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int count = 0;
            for (int j = i+1; j < nums.length; j++) {
                if (currNum > nums[j]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }
}
// @lc code=end

