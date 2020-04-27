package com.linp.leetcode;

/**
 * created by : linpeng
 * ON 2020-04-10
 * used for:
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 每枪 0～ 10
 * 打 10枪
 * 打出 90环
 */
public class Score90 {


    private static int MAX_V = 90;//需要打到的环数

    private static int T = 10;//打的次数

    private static int T_MAX = 10;//每次打到的最大 环数


    public static void main(String[] args) {

        Long st = System.currentTimeMillis();
        System.out.println(st);
//        System.out.println("总数 "+gun().size());
        print(gun());

        System.out.println(System.currentTimeMillis() - st);

    }


    public static void print(List<int[]> list) {
        System.out.println(" -------------start-------------- ");
        for (int[] arr : list) {
            for (int i : arr) {
                System.out.print((10-i) + " ");
            }
            System.out.println();
        }
        System.out.println(" -------------end-------------- ");
        System.out.println(" 总共  " + list.size());


    }

    public static List<int[]> gun() {

        int minV = T * T_MAX - MAX_V;
        List<int[]> allArr = new ArrayList<>();
        gunOne(minV, 0, allArr, new int[T], 0);

        return allArr;

    }

    /**
     * @param minV 最低的值
     * @param times 执行的次数
     */
    private static void gunOne(int minV, int times, List<int[]> allArr, int[] arr, int arrCount) {
        if (arrCount > minV) {
            return;
        }
        if (times > T) {
            return;
        }
        if (arrCount == minV) {
            allArr.add(arr);
            return;
        }
        if (times == T) {
            return;
        }
        for (int i = 0; i <= T_MAX; i++) {
            int[] itemArr = Arrays.copyOf(arr, T);
            int newArrCount = arrCount + i;
            itemArr[times] = i;
            gunOne(minV, times + 1, allArr, itemArr, newArrCount);
        }
    }


}
