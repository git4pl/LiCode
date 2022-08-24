import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int result = 0;
        //快慢指针：快指针指向最新的下标，慢指针指向不重复的最小下标
        int fast = 0, slow = 0;
        //哈希表来快速定位重复字符的最新位置
        HashMap<Character, Integer> charAndIndexMap = new HashMap<>();
        while (fast < s.length()) {
            if (charAndIndexMap.containsKey(s.charAt(fast))) {
                slow = Math.max(slow, charAndIndexMap.get(s.charAt(slow)) + 1);
            }
            charAndIndexMap.put(s.charAt(fast), fast);
            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}
// @lc code=end

