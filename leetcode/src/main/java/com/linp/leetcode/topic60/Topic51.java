package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-12-10 14:27
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 */
public class Topic51 {


    public static List<List<String>> solveNQueens(int n) {
        List<Integer> xList = nList(n);
        List<Integer> yList = nList(n);
        List<List<Vo>> allData = new ArrayList<>(n);
        init(xList, yList, n, allData, new ArrayList<>(n * n), new ArrayList<>(n));
        return vo2Str(allData);
    }

    public static void init(List<Integer> xList, List<Integer> yList, int n, List<List<Vo>> allData, List<Vo> itemList, List<Vo> qList) {
        if (qList.size() == n || xList.size() == 0 || yList.size() == 0) {
            allData.add(itemList);
            return;
        }

        for (int i = 0; i < xList.size(); i++) {
            for (int j = 0; j < yList.size(); j++) {
                int x = xList.get(i);
                int y = yList.get(j);
                String val = getVal(qList, x, y);
                Vo vo = new Vo(x, y, val);
                itemList.add(vo);
                if ("Q".equals(val)) {
                    qList.add(vo);
                }
                List<Integer> newXList = copy(xList, x);
                List<Integer> newYList = copy(yList, y);
                List<Vo> newItemList = copy(itemList);
                List<Vo> newQList = copy(qList);
                if (newQList.size() == n || newXList.size() == 0 || newYList.size() == 0) {
                    allData.add(newItemList);
                    return;
                }
                init(newXList, newYList, n, allData, newItemList, newQList);

            }
        }


    }

    public static String getVal(List<Vo> qList, int x, int y) {
        for (Vo vo : qList) {
            if (x == vo.x || y == vo.y) {
                return ".";
            }
            int xx = x - vo.x;
            int yy = y - vo.y;

            if (xx == yy || xx == -yy) {
                return ".";
            }

        }
        return "Q";
    }

    public static List<Integer> copy(List<Integer> list, int item) {
        List<Integer> l = new ArrayList<>(list.size());
        for (Integer i : list) {
            if (i.intValue() != item) {
                l.add(i);
            }
        }
        return l;
    }

    public static List<Vo> copy(List<Vo> list) {
        List<Vo> l = new ArrayList<>(list.size());

        for (Vo vo : list) {
            l.add(vo.copy());
        }
        return l;
    }

    public static List<List<String>> vo2Str(List<List<Vo>> allData) {
        List<List<String>> data = new ArrayList<>();
        for (List<Vo> li : allData) {
            List<String> ar = new ArrayList<>();
            for (Vo vo : li) {
                ar.add(vo.val);
            }
            data.add(ar);
        }
        return data;
    }

    public static void main(String[] args) {

        List<List<String>> s =  solveNQueens(2);
        System.out.println(s.toString());

    }


    public static List<Integer> nList(int n) {
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nList.add(i);
        }
        return nList;
    }

    public static class Vo {
        public int x;
        public int y;
        public String val;

        public Vo(int x, int y, String val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }


        public Vo copy() {
            return new Vo(this.x, this.y, this.val);
        }
    }
}
