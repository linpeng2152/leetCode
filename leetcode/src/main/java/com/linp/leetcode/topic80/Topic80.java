package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 18:34
 * used for:
 */

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 说明:
 *
 * 为什么返回数值是整数，但输出的答案是数组呢?
 *
 * 请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 *
 * 你可以想象内部操作如下:
 *
 * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
 * int len = removeDuplicates(nums);
 *
 * // 在函数里修改输入数组对于调用者是可见的。
 * // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic80 {


    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));


    }

    /**
     * 遍历 数组 计算 包含重复2次的数目 len  并且将2次之外的 设置为 一个 特殊值 min
     * 循环执行 len 次 将头部的 len 的元素设置为需要的值
     *
     */
    public static int removeDuplicates(int[] nums) {
        int len = 0;
        int min = nums[0] - 1;
        int ll = nums.length;
        int cur = nums[0];
        int curN = 0;
        for(int i = 0; i<ll;i++){
            int val = nums[i];
            if(val > cur){
                cur = val;
                curN = 1;
                len ++;
            }else if(val == cur){
                curN ++ ;
                if(curN == 3){
                    curN = 2 ;
                    nums[i] = min;
                }else{
                    len ++ ;
                }
            }

        }

        int dex = 0;
        for(int i = 0; i < len;i++){
            boolean temp = true;
            while(temp){
                if(nums[dex] != min){
                    nums[i] = nums[dex];
                    temp = false;
                }
                dex ++;

            }
        }


        return len;
    }
}
