package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-27 11:41
 * used for:
 */

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3},[6,9}}, newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic57 {

    public static int[][] insert(int[][] intervals, int[] newInterval) {


        Set<int[]> list = new LinkedHashSet<>();
        if(intervals.length ==0){
            list.add(newInterval);
        }
        int min = newInterval[0];
        int max = newInterval[1];
        boolean tag = false;
        int[] cur = new int[2];
        cur[0] = min;
        cur[1] = max;

        int lastMax = Integer.MIN_VALUE;

        for(int i = 0; i <intervals.length ;i++){
            int[] item = intervals[i];
            if(lastMax < cur[0] && cur[1]<item[0]){
                list.add(cur);
            }

            if(lastMax < min && item[0] > min && item[1]>max){
                cur[0] = min < cur[0] ? min :  cur[0] ;
                cur[1] = item[1];
                list.add(cur);
            }
            lastMax = item[0];

            if( item[0] < min && item[1] > max){
                cur[0] = item[0] ;
                cur[1] = item[1];
                list.add(cur);
                continue;
            }




            if(i == 0){
                if(cur[1] < item[0]){
                    list.add(cur);
                }
                if(item[0]>=min){
                    cur[0] = min;
                    tag = true;
                    list.add(cur);
                }
            }


            if(item[1]< min){
                list.add(item);
                continue;
            }
            if(item[0]>max){

                if(tag){
                    cur[1] = max;
                    tag = false;

                }
                list.add(item);
                continue;
            }
            if(item[0]<=min){
                cur[0] = item[0];
                tag = true;
                list.add(cur);
            }
            if(item[1]>=max){
                cur[1] = item[1];
                tag = false;
            }


            if(item[0]>=min && item[1]<=max){
                list.add(cur);

            }

        }
        if(intervals.length != 0){
            int[] item = intervals[intervals.length-1];

            if(cur[0] > item[1]){
                list.add(cur);
            }

        }

        if(tag){
            cur[1] = max;
            // list.add(cur);
        }

        int[][] data = new int[list.size()][2];
        int i = 0;
        for(int[] item:list){
            data[i] = item;
            i++;
        }

        return data;
    }

    public static void main(String[] args) {

//        int[][] intervals = {{1,3},{6,9}};
//        int[] newInterval = {2,5};

//        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
//        int[] newInterval = {4,8};
//        int[][] intervals = {{0,5},{9,12}};
//        int[] newInterval = {7,16};

        int[][] intervals = {{0,5},{8,9}};
        int[] newInterval = {3,4};


        insert(intervals,newInterval);
    }

}
