import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=84 lang=java
 *
 * [84] 柱状图中最大的矩形
 */

// @lc code=start
class Solution {
    /**
     * 用单调栈实现，时间复杂度为 O(n)，空间复杂度为 O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        //用一个栈存储柱子的位置，初始栈顶存-1
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        int area = 0;
        //遍历数组中的柱子
        for (int i = 0; i < heights.length; i++) {
            //如果当前柱子高度小于栈顶柱子的高度，则将栈顶的柱子出栈计算以栈顶柱子为高度的面积
            while(stack.peekFirst() != -1 && heights[i] < heights[stack.peekFirst()]) {
                //计算栈顶柱子到它前一个柱子之间围成的面积
                int tmpArea = heights[stack.removeFirst()] * (i - stack.peekFirst() - 1);
                area = Math.max(area, tmpArea);
            }
            stack.addFirst(i);
        }
        //最后栈中还有柱子，它们从栈顶到栈底柱子高度递减
        while(stack.peekFirst() != -1) {
            //计算栈顶柱子到其前一个柱子之间围成的面积
            int temp = heights[stack.removeFirst()] * (heights.length - stack.peekFirst() - 1);
            area = Math.max(area, temp);
        }
        return area;
    }

    // 暴力解法，时间复杂度为 O(n^2), 空间复杂度为 O(1)
    public int largestRectangleArea1(int[] heights) {
        int area = 0, n = heights.length;
        for (int mid = 0; mid < n; mid++) {
            int height = heights[mid];  //取当前柱子的高度
            int left = mid, right = mid;
            while(left-1 >= 0 && heights[left-1] >= height) {
                //向左边找，找到第一个高度小于当前高度的柱子
                left--;
            }
            while(right+1 < n && heights[right+1] >= height) {
                //向右边找，找到第一个高度小于当前高度的柱子
                right++;
            }
            area = Math.max(area, height*(right-left+1));
        }
        return area;
    }
}
// @lc code=end

