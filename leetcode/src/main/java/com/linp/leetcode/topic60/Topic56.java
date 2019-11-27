package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-27 17:14
 * used for:
 */

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * <p>
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic56 {


    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 0) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        intervals = sort(intervals);
        int[] cur = null;
        for (int[] item : intervals) {
            if (cur == null) {
                cur = item;
                list.add(item);
            } else {
                if (cur[1] >= item[0] && cur[1] <= item[1]) {
                    if(cur[0]>item[1]){
                        list.add(0,item);
                    }else{
                        if (cur[1] < item[1]) {
                            cur[1] = item[1];
                        }
                        if(cur[0]>item[0]){
                            cur[0] = item[0];
                        }
                    }
                } else if(cur[1] >= item[1]){
                    continue;
                } else {
                    cur = item;
                    list.add(item);
                }
            }
        }
        int[][] data = new int[list.size()][];

        int i = 0;
        for (int[] item : list) {
            data[i] = item;
            i++;
        }
        return data;
    }


    public static int[][] sort(int[][] intervals){
        Map<Integer,int[]> map = new HashMap<>();

        for(int[] item : intervals){
            int[] cur = map.get(item[0]);
            if(cur!=null){
                if(item[1]>= cur[1]){
                    cur[1] = item[1];
                }
            }else{
                map.put(item[0],item);
            }
        }
        Set<Integer> set = map.keySet();
        Set<Integer>  sorted = new TreeSet<Integer>(set);
        int[][] data = new int[set.size()][];
        int i=0;
        for(Integer item:sorted){
            data[i] = map.get(item);
            i++;
        }
        return data;
    }

    public static void main(String[] args) {


//        merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
//        merge(new int[][]{{1, 4}, {0, 1}});
        merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});

    }
}
