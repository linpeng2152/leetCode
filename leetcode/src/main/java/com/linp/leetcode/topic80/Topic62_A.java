package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-10 18:07
 * used for:
 */

public class Topic62_A {


    /**
     * 超时
     */
    public static long uniquePaths(int m, int n) {
        int cD = m + n - 2;
        int cT = m - 1 < n - 1 ? m - 1 : n - 1;

        long count = 1;
        System.out.println( cD + "  --------------------- " + cT);
        System.out.print(cD + " -> ");
        for (int i = 0; i < cT; i++) {
            System.out.print(cD - i + " -> ");
            count = count * (cD - i);
        }

        System.out.println( " --------------------- ");

        long af = 1L;
        for (int i = 1; i <= cT; i++) {
            System.out.print( i + " -> ");
            af = af * (i);
        }

        return new Long(count / af).longValue();

    }


    public static void main(String[] args) {
        Long s = System.currentTimeMillis();
        System.out.println(uniquePaths(51, 9));
        Long l = System.currentTimeMillis();
        System.out.println(l - s);

      long l2 =   111174244038L/1916797311L;
      System.out.println(l2);
//        1916797311

    }
}
