package com.cwh.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 数组优化
 */
public class CoinChange2 {

    @Test
    public void test() {
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(1, 2, 5));
        int amount = 1100;
        System.out.println(coinChange(amount, coins));
    }

    public int coinChange(int amount, ArrayList<Integer> coins) {
        int[] dp = new int[amount + 1];
        // 将数组所有值初始化为amount + 1，这样方便接下来比较大小
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Integer.min(1 + dp[i - coin], dp[i]);
            }
        }

        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
