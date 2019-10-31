package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-31 10:56
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic16 {

    public static int threeSumClosest(int[] nums, int target) {

        int i = 0;
        List<Integer> l = new ArrayList();

        int length = nums.length;
        for(int j = 0; j < length; j++){
            for(int k = j+1; k <length; k++){
                for(int x = k+1; x <length; x++){
                    int conut = nums[x]+nums[j]+nums[k];

                    if(isExit(target,i,conut)){
                        return conut;
                    }
                    l.add(conut);

                }
            }
        }
        return choose(target,l);
    }

    private static int choose(int target, List<Integer> l) {
       int min = Integer.MAX_VALUE;
       int j;
       int val = Integer.MIN_VALUE;
       for(Integer item: l){
           if(target < item){
                j = item - target;
           }else{
                j = target -item;
           }
          if(j < min ){
              min =  j;
              val = item;
          }
       }

       return val;


    }

    public static boolean isExit(int target,int i,int number){
        if((target + i == number) || (target -i == number)){
            return true;
        }
        return false;
    }



    public static void main(String[] args){
        int[] nums = {-1,2,1,-4};

        System.out.println(threeSumClosest(nums,1));
    }

}
