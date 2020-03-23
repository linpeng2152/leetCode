package com.linp.leetcode.topic140;


/**
 * created by : linpeng
 * ON 2020-01-15 15:11
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 * <p>
 * 你需要按照以下要求，帮助老师给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻的孩子中，评分高的孩子必须获得更多的糖果。
 * 那么这样下来，老师至少需要准备多少颗糖果呢？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。
 * 示例 2:
 * <p>
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
 * 第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic135 {

    public static void main(String[] args) {
//        int[] arr = {1,0,2};
//        int[] arr = {1,3,2,2,1};
        int[] arr = {1,2,87,87,87,2,1};

        int v = candy2(arr) < candy1(arr) ? candy2(arr) : candy1(arr);


        System.out.println(v);
    }


    public static int candy1(int[] ratings) {
        if (ratings.length <= 1) {
            return 1;
        }
        int total = 0;
        int cur = Integer.MIN_VALUE;
        int curV = 0;
        int min = 1;

        List<Integer> l = new ArrayList<Integer>();

        for (int i = 0; i < ratings.length; i++) {
            int item = ratings[i];
            if (item > cur) {
                curV += 1;
                total += curV;
                l.add(curV);
            } else {
                curV -= 1;
                total += curV;
                l.add(curV);
            }
            if (min > curV) {
                min = curV;
            }
            cur = item;

        }
        total += l.size() * (1 - min);

        return total;
    }

    public static int candy2(int[] ratings) {
        if (ratings.length <= 1) {
            return 1;
        }
        int total = 0;
        int cur = Integer.MIN_VALUE;
        int curV = 0;
        int min = 1;

        List<Integer> l = new ArrayList<Integer>();

        for (int i = ratings.length - 1; i >= 0; i--) {
            int item = ratings[i];
            if (item > cur) {
                curV += 1;
                total += curV;
                l.add(curV);
            } else {
                curV -= 1;
                total += curV;
                l.add(curV);
            }
            if (min > curV) {
                min = curV;
            }
            cur = item;

        }
        total += l.size() * (1 - min);

        return total;
    }

}
