package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-11-02 17:08
 * used for:
 */

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic33 {


    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        return search(nums, target,0,len-1);
    }

    public static int search(int[] nums, int target,int start,int end){
        int mid = (start + end) / 2;
        int midVal = nums[mid];
        int midValL = nums[start];
        int midValR = nums[end];
        if(midVal == target){
            return mid;
        }else if(midValR == target){
            return end;
        }else if(midValL==target){
            return start;
        }

        if(start == end || start == mid){
            return -1;
        }



        if(midVal < midValR){
            if(midVal < target  && target < midValR ){
                return search( nums,  target,mid, end);
            }else{
                return search( nums,  target,start, mid);
            }

        }else{
            if(target < midVal && target > midValL){
                return search( nums,  target,start, mid);
            }else{
                return search( nums,  target,mid, end);

            }

        }
    }

    public static void main(String[] args) {

        System.out.println(search(new int[]{4,5,6,7,0,1,2},5));

    }



}