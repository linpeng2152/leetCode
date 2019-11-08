package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-11-02 17:55
 * used for:
 */

public class Topic34 {



    public int[] searchRange(int[] nums, int target) {
        int x = Topic33.search(nums, target);

        if(x == -1){
            return new int[]{-1,-1};
        }
        if(x == 0){
            if(nums[x+1] == target){
                return new int[]{0,1};
            }else{
                return new int[]{0,-1};
            }
        }
        if(x == nums.length){
            if(nums[x-1] == target){
                return new int[]{x-1,x};
            }else{
                return new int[]{-1,x};
            }
        }
        if(nums[x-1] == target){
            return new int[]{x-1,x};
        }else if(nums[x+1] == target){
            return new int[]{x,x+1};

        }else{
            return new int[]{x,-1};

        }
    }

    public static void main(String[] args) {



    }

}
