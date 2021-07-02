package com.cwh.study;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Traverse {
    List<List<Integer>> res  = new LinkedList<>();

    @Test
    public void test(){
        List<List<Integer>> list = permute(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(list.toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        backTrack(nums,new LinkedList<>());
        return res;
    }

    public void backTrack(int[] nums,LinkedList<Integer> track){

        if(nums.length == track.size()){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num)) {
                continue;
            }
            track.add(num);
            backTrack(nums, track);
            track.removeLast();
        }

    }
}
