package com.linp.leetcode.top;

import java.util.*;

/**
 * @Author : linpeng
 * ON 2020-12-08
 * used for:
 */
public class Topic218 {

    /**
     * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。
     * <p>
     * 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示：
     * <p>
     * lefti 是第 i 座建筑物左边缘的 x 坐标。
     * righti 是第 i 座建筑物右边缘的 x 坐标。
     * heighti 是第 i 座建筑物的高度。
     * 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
     * <p>
     * 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
     * 输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
     * 解释：
     * 图 A 显示输入的所有建筑物的位置和高度，
     * 图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。
     * 示例 2：
     * <p>
     * 输入：buildings = [[0,2,3],[2,5,3]]
     * 输出：[[0,3],[5,0]]
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= buildings.length <= 104
     * 0 <= lefti < righti <= 231 - 1
     * 1 <= heighti <= 231 - 1
     * buildings 按 lefti 非递减排序
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-skyline-problem
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param buildings
     * @return
     */
    public static List<List<Integer>> getSkyline(int[][] buildings) {
        Map<Long, TreeSet<Integer>> map = new HashMap<>();
        List<List<Integer>> l = new ArrayList<>();

        if(buildings.length == 1){
            int xL = buildings[0][0];
            int xR =  buildings[0][0];
            int h =  buildings[0][0];
            List<Integer> item = new ArrayList<>();
            item.add(xL);
            item.add(h);
            l.add(item);

            return l;
        }
        for (int[] item : buildings) {
            long xL = new Long(item[0]) * 2;
            long xR = new Long(item[1]) * 2;
            int h = item[2];
            for (;xL <= xR; xL++) {
                TreeSet set = map.get(xL);
                if (set == null) {
                    set = new TreeSet();
                }
                set.add(h);
                map.put(xL, set);
            }
        }
        TreeSet<Long> s = new TreeSet<>(map.keySet());
        long max = s.last();

        Map<Long,Integer> map2 = new HashMap<>();
        for(long i = 0;i<=max ; i++){
            TreeSet<Integer> set0 = map.get(i);
            TreeSet<Integer> set1 = map.get(i+1);
            int itemMax0 = set0 == null? 0 :set0.last();
            int itemMax1 = set1 == null? 0 :set1.last();
            int h = 0;
            if(itemMax0<itemMax1){
                h = itemMax0;
            }else {
                h = itemMax1;
            }
            map2.put(i,h);
        }


        TreeSet<Long> s2 = new TreeSet<>(map2.keySet());
        for (long x : s2) {
            Integer y = map2.get(x) == null ? 0 : map2.get(x);
            Integer yL = map2.get(x - 1) == null ? 0 : map2.get(x - 1);
            if (y != yL) {
                List<Integer> item = new ArrayList<>();
                int xi = new Long((x+1)/2).intValue();
                item.add(xi);
                item.add(y);
                l.add(item);
            }
        }


        return l;

    }


    public static void main(String[] args) {
//        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
//        int[][] buildings = {{0,2147483647,2147483647}};
//        int[][] buildings = {{4,9,10}, {4,9,15}, {4,9,12}, {10,12,10}, {10,12,8}};
        int[][] buildings ={{1,2,1}, {2147483646,2147483647,2147483647}};
        getSkyline(buildings);
    }

}
