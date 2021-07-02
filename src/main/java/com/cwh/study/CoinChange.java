package com.cwh.study;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

// 暴力破解
public class CoinChange {
    int[] coins = new int[]{1, 2, 5};

    @Test
    public void test() {
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(1, 2, 5));
        int amount = 20;
        System.out.println(coinChange(amount, coins));
    }

    private int coinChange(int amount, ArrayList<Integer> coins) {
        return dp(amount, coins);
    }

    int dp(int amount, ArrayList<Integer> coins) {
        // 金额为0，要求的硬币数量为0
        if (amount == 0) return 0;
        // -1表示问题没有解，即该硬币凑不出零钱
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 减去当前硬币面值，得到凑出剩余金额所需最少的硬币数量
            int subProblem = dp(amount - coin, coins);
            // 若subProblem不为1，则当前面值可以凑硬币
            if (subProblem == -1)
                continue;
            // 与以上结果比较，取最小值（注意：加1是加上当前这个面值硬币
            res = Math.min(res, 1 + subProblem);
        }
        if (res != Integer.MAX_VALUE) return res;
        else return -1;
    }

}
