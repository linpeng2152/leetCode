package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 14:07
 * used for:
 */

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 *
 * 示例:
 *
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 *
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic75 {

    public static int x = 0;
    public static int y = 0;

    public static void main(String[] args){
        int[] num = {2,0,2,1,1,0};
//        sortColorsSimple(num);
        sortColors(num);
        System.out.println(num);
    }

    /**
     * 时间复杂读  2N
     * 找出 0 1、2 的个数
     * 对应的位置 设置 对应 数目
     * @param nums
     */
    public static void sortColorsSimple(int[] nums) {
        int len = nums.length;

        int x = 0;
        int y = 0;
        int z = 0;

        for(int i = 0; i < len; i++){
            int val = nums[i];
            if(val == 2){
                z++;
            }
            if(val == 0){
                x++;
            }
            if(val == 1){
                y++;
            }
        }
        for(int i = 0; i < x; i++){
            nums[i] = 0;
        }
        for(int i = 0; i < y; i++){
            nums[x+i] = 1;
        }
        for(int i = 0; i < z; i++){
            nums[x+y+i] = 2;
        }

        return;
    }


    /**
     * 错误答案 N + i
     *
     * 思路 遍历 0 放到顶部、2 放到尾部 并 记录0 的结束位置x 2的开始位置y
     * 从 x~ y 到 设置为 1
     */
    public static void sortColors(int[] nums) {

        int len = nums.length;
        x = 0; y = len - 1;

        for(int i = 0; i < len; i++){
            int val = nums[i];
            temp(nums,val);
        }

        for(int i = x; i < y;i++){
            nums[i] = 1;
        }

    }

    public static void temp(int[] nums, int temp){
        if(temp == 0){
            trapX(nums,temp);
        }else if(temp == 2) {
            trapY(nums,temp);
        }
    }

    public static void trapX(int[] nums,int val) {
        if(val == 0){
            int temp = nums[x];
            nums[x] = 0;
            x++;
            temp(nums,temp);
        }

    }
    public static void trapY(int[] nums,int val) {
        if(val == 2){
            int temp = nums[y];
            nums[y] = 2;
            x--;
            temp(nums,temp);
        }

    }



}
