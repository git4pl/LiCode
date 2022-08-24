/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs1(int n) {
        int n0 = 1, n1 = 1;
        for (int i = 2; i <= n; i++) {
            n1 = n0 + n1;
            n0 = n1 - n0;
        }
        return n1;
    }
    public int climbStairs(int n) {
        int steps[] = new int[n+1];
        steps[0] = 1;
        if (n < 2) {
            return steps[0];
        }
        steps[1] = 1;
        for (int i = 2; i <= n; i++) {
            steps[i] = steps[i-1] + steps[i-2];
        }
        return steps[n];
    }
}
// @lc code=end

