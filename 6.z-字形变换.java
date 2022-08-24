/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length(), r = numRows;
        if (r == 1 || r > n) {
            return s;
        }
        StringBuilder ans = new StringBuilder();
        int t = r * 2 - 2; //计算周期
        //遍历矩阵的行
        for (int i = 0; i < r; i++) {
            //计算每个周期的起始下标
            for (int j = 0; j + i < n; j += t) {
                //添加当前周期第一个字符
                ans.append(s.charAt(j+i));
                if (i > 0 && i < r -1 && j + t - i < n) {
                    //添加当前周期第二个字符
                    ans.append(s.charAt(j+t-i));
                }
            }
        }
        return ans.toString();
    }
    
    public String convert1(String s, int numRows) {
        int length = s.length();
        if (numRows == 1 || numRows > length) {
            return s;
        }
        StringBuilder[] mat = new StringBuilder[numRows];
        for (int i = 0; i < mat.length; i++) {
            //为每一行构造一个字符串存放该行的字符
            mat[i] = new StringBuilder();
        }

        for (int i = 0, row = 0, t = numRows * 2 - 2; i < length; i++) {
            mat[row].append(s.charAt(i));
            if (i % t < numRows - 1) {
                ++row;
            } else {
                --row;
            }
        }
        StringBuilder ans = new StringBuilder();
        //将所有行的字符串拼接起来
        for (StringBuilder rowStr : mat) {
            ans.append(rowStr);
        }

        return ans.toString();
    }
}
// @lc code=end

