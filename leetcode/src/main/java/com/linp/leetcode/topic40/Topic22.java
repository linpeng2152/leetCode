package com.linp.leetcode.topic40;


/**
 * created by : linpeng
 * ON 2019-10-31 15:03
 * used for:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic22 {

    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate_(2 * n, list, "", 0);


        return list;
    }


    public static void generate_(int n, List<String> result, String curStr, int i) {
        if (i < 0) {
            return;
        }
        if (curStr.length() == n) {
            if (i == 0) {
                result.add(curStr);
                return;
            } else {
                return;

            }

        }
        String curStr0 = curStr + "(";
        String curStr1 = curStr + ")";
        generate_(n, result, curStr0, i + 1);
        generate_(n, result, curStr1, i - 1);
    }


    public static void main(String[] args) {


    }
}
