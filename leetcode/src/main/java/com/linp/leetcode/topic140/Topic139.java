package com.linp.leetcode.topic140;


/**
 * created by : linpeng
 * ON 2020-01-12 16:48
 * used for:
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<String>();
        w = false;
        for (String str : wordDict) {
            set.add(str);
            if (!s.contains(str)) {
                return false;
            }
        }
        String newS = s;
        for (; ; ) {

        }


    }


    public static boolean w = false;


    public static void reply(String oldStr, Set<String> set) {
        if ("".equals(oldStr)) {
            w = true || w;
            return;
        }
        String newStr = oldStr;
        for (String ss : set) {
            if (newStr.startsWith(ss)) {
                reply(newStr.replaceFirst(ss,""),set);
            }
        }






    }

}
