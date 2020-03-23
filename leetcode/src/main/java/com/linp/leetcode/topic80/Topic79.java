package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-19 17:13
 * used for:
 */

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic79 {

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCCED";
//        char[][] board = {{'A'}};
//        String word = "A";
        char[][] board = {{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'b'}};
        String word = "aaaaaaaaaaaaaaaaaaaa";

        System.out.println(exist(board, word));
    }

    /**
     * 1、判断长度
     *      1、m * n < len 直接返回 false
     *      2、m * n == len board 拥有不被 word 包含的元素 直接返回 false
     * 2、判断 是否能组合成 word
     */
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        if (m * n < len) return false;
        if (m * n == len) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Character c = board[i][j];
                    if (!word.contains(c.toString())) {
                        return false;
                    }
                }
            }
        }

        /**
         * 循环找到 等于第一个元素
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Set<String> set = new HashSet<>();
                    set.add(" " + i + " " + j);

                    if (exist(board, word, i, j, m, n, 0, set, len)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     *
     *
     *
     * @param tt    -1 左、 1 右 、 -2 上、2 下
     */
    public static boolean exist(char[][] board, String word, int x, int y, int m, int n, int tt, Set<String> s, int wordLen) {
        if (board[x][y] != word.charAt(0)) {
            return false;
        }
        if (word.length() == 1) {
            if (s.size() == wordLen) {
                return true;
            } else {
                return false;
            }
        }
        String newWord = word.substring(1);
        Character left = turnLeft(board, x, y, m, n);
        Character right = turnRight(board, x, y, m, n);
        Character top = turnTop(board, x, y, m, n);
        Character down = turnDown(board, x, y, m, n);
        if (left != null && left == newWord.charAt(0) && tt != -1) {//尝试向左
            Set<String> newS = copy(s);
            newS.add(" " + x + " " + (y - 1));
            if (exist(board, newWord, x, y - 1, m, n, 1, newS, wordLen)) {
                return true;
            }
        }
        if (right != null && right == newWord.charAt(0) && tt != 1) {//尝试向右
            Set<String> newS = copy(s);
            newS.add(" " + x + " " + (y + 1));
            if (exist(board, newWord, x, y + 1, m, n, -1, newS, wordLen)) {
                return true;
            }
        }
        if (top != null && top == newWord.charAt(0) && tt != -2) {//尝试向上
            Set<String> newS = copy(s);
            newS.add(" " + (x - 1) + " " + (y));
            if (exist(board, newWord, x - 1, y, m, n, 2, newS, wordLen)) {
                return true;
            }
        }
        if (down != null && down == newWord.charAt(0) && tt != 2) {//尝试向下
            Set<String> newS = copy(s);
            newS.add(" " + (x + 1) + " " + (y));
            if (exist(board, newWord, x + 1, y, m, n, -2, newS, wordLen)) {
                return true;
            }
        }
        return false;

    }


    //向左
    public static Character turnLeft(char[][] board, int x, int y, int m, int n) {
        if (y == 0) {
            return null;
        }
        y = y - 1;
        return board[x][y];
    }

    //向右
    public static Character turnRight(char[][] board, int x, int y, int m, int n) {
        if (y == n - 1) {
            return null;
        }
        y = y + 1;
        return board[x][y];
    }

    //向上
    public static Character turnTop(char[][] board, int x, int y, int m, int n) {
        if (x == 0) {
            return null;
        }
        x = x - 1;
        return board[x][y];
    }

    //向下
    public static Character turnDown(char[][] board, int x, int y, int m, int n) {
        if (x == m - 1) {
            return null;
        }
        x = x + 1;
        return board[x][y];
    }


    public static Set<String> copy(Set<String> s) {
        Set<String> newS = new HashSet<String>();
        if (s == null) {
            return newS;
        }
        for (String i : s) {
            newS.add(i);
        }
        return newS;
    }


}
