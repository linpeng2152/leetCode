package com.linp.leetcode.topic160;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * created by : linpeng
 * ON 2020-03-23
 * used for:
 */
public class Topic149 {

    public static void main(String[] a) {
        int[][] arr = {{0,0},{94911151,94911150},{94911152,94911151}};

        System.out.println(maxPoints(arr));
    }

    /**
     * 网站不支持 BigDecimal 哭
     *
     */

    public static int maxPoints(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }

        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> repeatMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            String key1 = points[i][0]+":"+points[i][1];
            Integer c = repeatMap.get(key1) == null ? 0 : repeatMap.get(key1);
            repeatMap.put(key1,c+1);

            for (int z = i + 1; z < points.length; z++) {
                String key = getXY(points[i], points[z]);
                Set<String> s = map.get(key) == null ? new HashSet<>() : map.get(key);
                s.add(points[i][0]+":"+points[i][1]);
                s.add(points[z][0]+":"+points[z][1]);
                map.put(key, s);
            }
        }

        int max = 0;
        for (Set<String> s : map.values()) {

            int itemMax = getLen(repeatMap,s);
            max = itemMax > max ? itemMax : max;


        }
        return max;
    }
    public static int getLen(Map<String, Integer> repeatMap,Set<String> s ){
        int itemMax = s.size();
        for(String key1 :s){
            Integer count = repeatMap.get(key1) == null ? 1 : repeatMap.get(key1);
            itemMax += (count -1);
        }
        return itemMax;

    }

    public static String getXY(int[] point1, int[] point2) {

        String rate;

        int x = point1[0] - point2[0];
        int y = point1[1] - point2[1];

        if (x == 0) {
            rate = Double.MIN_NORMAL + "";
        } else if (y == 0) {
            rate = Double.MAX_VALUE + "";
        } else {
            rate = new BigDecimal(y).divide(new BigDecimal(x),20,  4).toString();
        }

        return point1[0] + ":" + point1[1] + ":" + rate;
    }


}
