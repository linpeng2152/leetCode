package com.linp.algorithm.chapter2_1;

import com.linp.algorithm.base.StdIn;

/**
 * @Author : linpeng
 * ON 2020-09-15
 * used for:
 */
public class SortBase {


    public static void sort(Comparable[] a) {

    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable c = a[i];
        a[i] = a[j];
        a[j] = c;
    }
    public static void exch(int[] a, int i, int j) {
        int c = a[i];
        a[i] = a[j];
        a[j] = c;
    }


    public static void print(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdIn.print(a[i] + "   ");
        }
    }
    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "   ");
        }
    }


    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

}
