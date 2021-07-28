package com.cwh.study.backtrack;

import java.util.LinkedList;
import java.util.List;

public class PermuteTest {
    static List<List<Integer>> res = new LinkedList<>();

    public static void main(String[] args) {
        LinkedList<Integer> track = new LinkedList<>();

        // 不重复的数字
        int[] num = new int[]{1, 2, 3};
        backtrack(num, track);
        System.out.println(res);
    }

    /**
     * 路径：记录在track中
     * 选择列表：nums中不存在与track的那些元素
     * 结束条件：nums中的元素全部在track中出现
     *
     * @param num
     * @param track
     */
    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (int num : nums) {
            // 排除不合法的选择
            if (track.contains(num)) {
                continue;
            }
            // 做选择
            track.add(num);
            // 进入下一层决策树
            backtrack(nums, track);
            //取消选择
            track.removeLast();
        }

    }
}
