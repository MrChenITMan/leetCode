package com.cwh.study;


import org.junit.Test;

public class Fib {

    @Test
    public void fib1() {
        int[] memo = new int[21];
        int i = helper(memo, 20);
        System.out.println(i);
    }

    // 备忘录，自底向上
    public int helper(int[] memo, int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    @Test
    public void fib2() {
        int[] memo = new int[21];
        int i = helper2(memo, 20);
        System.out.println(i);
        assert i == 6765;
    }

    // 自顶向下
    public int helper2(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 3; i <= n; i++) {
            if (memo[n] != 0) {
                return memo[n];
            }
            memo[n] = helper2(memo, n - 1) + helper(memo, n - 2);
        }
        return memo[n];
    }

    @Test
    public void fib3() {
        int i = helper3(20);
        assert i == 6765;
    }

    // 状态压缩
    public int helper3(int n) {
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }
}

