package com.linp.leetcode.topic140;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author : linpeng
 * ON 2020-10-20
 * used for:
 */
public class Topic126 {


    /**
     * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
     * <p>
     * 每次转换只能改变一个字母。
     * 转换后得到的单词必须是字典中的单词。
     * 说明:
     * <p>
     * 如果不存在这样的转换序列，返回一个空列表。
     * 所有单词具有相同的长度。
     * 所有单词只由小写字母组成。
     * 字典中不存在重复的单词。
     * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
     * 示例 1:
     * <p>
     * 输入:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     * <p>
     * 输出:
     * [
     * ["hit","hot","dot","dog","cog"],
     *   ["hit","hot","lot","log","cog"]
     * ]
     * 示例 2:
     * <p>
     * 输入:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * <p>
     * 输出: []
     * <p>
     * 解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-ladder-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return resultList;
        }
        turn(beginWord, endWord,  Arrays.asList(beginWord), wordList, resultList);
        return resultList;
    }

    public static final char[] all = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void turn(String curWord, String endWord, List<String> result, List<String> wordList, List<List<String>> resultList) {
        for (int i = 0; i < curWord.length(); i++) {
            char[] curWordArr = curWord.toCharArray();
            for (int m = 0; m < all.length; m++) {
                curWordArr[i] = all[m];
                String newStr = new String(curWordArr);
                if (!wordList.contains(newStr)) {
                    continue;
                }
                if (result.contains(newStr)) {
                    continue;
                }
                List<String> newList = new ArrayList<>(result);
                newList.add(newStr);
                if (newStr.equals(endWord)) {
                    resultList.add(newList);
                    return;
                }
                turn(newStr, endWord, newList, wordList, resultList);
            }
        }
    }


    public static void main(String[] a) {
        List<List<String>> resultList  =  findLadders("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"));

        System.out.println(resultList.size());
    }
}
