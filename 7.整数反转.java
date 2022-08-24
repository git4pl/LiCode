/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int revAns = 0;
        while (x != 0) {
            if (revAns < Integer.MIN_VALUE / 10 || revAns > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            revAns = revAns * 10 + digit;
        }
        return revAns;
    }

    public int reverse1(int x) {
        int rev = 0;
        int last = 0;
        while(x != 0) {
            int temp = x % 10;//取剩下的未反转的数的末位数字
            last = rev;
            rev = rev * 10 + temp;
            // 如果数字溢出了，那么上次记录的反转后的数字与最新反转后的数字除以10的商数不同
            if (last != rev / 10) {
                return 0;
            }
            x /= 10;
        }
        return rev;
    }
}
// @lc code=end

