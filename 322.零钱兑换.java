/*
 * @lc app=leetcode.cn id=322 lang=java
 *
 * [322] 零钱兑换
 */

// @lc code=start
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        memo = new int[amount];
        return findWays(coins, amount);
    }
    private int findWays(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount-1] != 0) {
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWays(coins, amount-coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1;
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }

    public int coinChange1(int[] coins, int amount) {
        int[] ways = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            ways[i] = amount + 1;
        }
        for (int i = 0; i < ways.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                ways[i] = Math.min(ways[i], ways[i-coins[j]] + 1);
            }
        }
        return (ways[amount] == amount + 1) ? -1 : ways[amount];
    }
}
// @lc code=end

