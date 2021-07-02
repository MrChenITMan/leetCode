package com.cwh.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 备忘录优化
 */
public class CoinChange1 {
    public int dp(int amount, ArrayList<Integer> coins, HashMap<Integer, Integer> memo) {
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(amount - coin, coins, memo);
            if (subProblem == -1) continue;
            res = Integer.min(res, 1 + subProblem);
        }

        if (res == Integer.MAX_VALUE) memo.put(amount, -1);
        else memo.put(amount, res);

        return memo.get(amount);
    }

    public int coinChange(int amount, ArrayList<Integer> coins) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dp(amount, coins, memo);
    }

    @Test
    public void test() {
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(1, 2, 5));
        int amount = 1100;
        System.out.println(coinChange(amount, coins));
    }
}
