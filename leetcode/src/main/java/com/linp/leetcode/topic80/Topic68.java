package com.linp.leetcode.topic80;


import java.util.ArrayList;
import java.util.List;

/**
 * created by : linpeng
 * ON 2019-12-12 11:29
 * used for:
 */

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 * <p>
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 * <p>
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 * <p>
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 * "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/text-justification
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic68 {
    public static void main(String[] args){
//        fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},16);
//        fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16);
        fullJustify(new String[]{"a"},1);
//        fullJustify(new String[]{"Science","is","what","we","understand","well","enough","to","explain",
//               "to","a","computer.","Art","is","everything","else","we","do"},20);


    }


    /**
     * 1、数组长度为0 直接返回
     * 2、对字符串循环  checkAndAdd  转化为 List<List<String>>
     * 3、List<List<String>> 转化为 List《String》
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) {
            return result;
        }
        List<List<String>> ll = new ArrayList<>();
        List<String> curList = new ArrayList<>();
        for (String s : words) {
            curList = checkAndAdd(ll, curList, s, maxWidth);
        }
        if(curList.size() != 0){
            ll.add(curList);
        }

        List<String> data = new ArrayList<>();
        for (int i = 0; i < ll.size(); i++) {
            if (i == ll.size() - 1) {
                data.add(list2Str(ll.get(i), maxWidth, true));
            } else {
                data.add(list2Str(ll.get(i), maxWidth, false));
            }
        }
        return data;
    }

    /**
     * 判断当前的list 能放入string
     * @param ll 存储所有的list
     * @param curList 当前的list
     * @param str 当前字符串
     * @param maxWidth 最大的宽度
     *
     * 1、计算当前的长度 len
     * 2、假如list size = 0 且 str的长度 等级   maxWidth 、则将 str 放入 curList、将 curList 放入 ll  、生成新的 curList
     * 3、假如 len + str.length() + 1 <= maxWidth 说明还可以放入 则将 str 放入 curList
     * 4、假如 len + str.length() + 1 > maxWidth  说明 不 可以放入 curList  则 将 curList 放入 ll  、生成新的 curList、str 放入新的curList
     */
    public static List<String> checkAndAdd(List<List<String>> ll, List<String> curList, String str, int maxWidth) {
        int len = 0;
        for (int i = 0; i < curList.size(); i++) {
            if (i == 0) {
                len += curList.get(i).length();
            } else {
                len += curList.get(i).length() + 1;
            }
        }
        if(curList.size() == 0 && str.length() == maxWidth){
            curList.add(str);
            ll.add(curList);
            curList = new ArrayList<>();
        }else{

            if (len + str.length() + 1 <= maxWidth) {
                curList.add(str);
            } else {
                ll.add(curList);
                curList = new ArrayList<>();
                curList.add(str);
            }
        }


       return curList;

    }

    /**
     * 1、计算所有的 空格数 spaceLen
     * 2、根据是否最后 一个list 是左对齐还是有对齐
     */
    public static String list2Str(List<String> strList, int maxWidth, boolean end) {

        int len = 0;
        for (String str : strList) {
            len += str.length();
        }

        int spaceLen = maxWidth - len;
        if (strList.size() == 1) {
            return insertSpace(strList.get(0), spaceLen);
        }

        if (end) {
            return insertSpacesLeft(strList, spaceLen);

        } else {
            return insertSpacesRight(strList, spaceLen);
        }
    }

    /**
     * 右对齐
     * 1、计算出所有空格数据
     * 2、循环添加 字符串、数个空格
     */
    public static String insertSpacesRight(List<String> strList, int spaceLen) {
        String str = "";
        int w0 = spaceLen / (strList.size() - 1);
        int w1 = spaceLen / (strList.size() - 1) + 1;
        int n = spaceLen % (strList.size() - 1);

        for (int i = 0; i < strList.size(); i++) {

            str += strList.get(i);
            if (n != 0) {
                str = insertSpace(str, w1);
                n--;
                spaceLen -= w1;
            } else {
                if (spaceLen > 0) {
                    str = insertSpace(str, w0);
                    spaceLen -= w0;
                }
            }
        }

        return str;

    }

    /**
     * 左对齐
     * 1、循环添加 字符串、一个空格
     * 2、添加剩余空格
     */
    public static String insertSpacesLeft(List<String> strList, int spaceLen) {
        String str = "";
        for (int i = 0; i < strList.size(); i++) {
            if (i == 0) {
                str += strList.get(i);
            } else {
                spaceLen--;
                str += " " + strList.get(i);
            }
        }
        return insertSpace(str, spaceLen);
    }


    public static String insertSpace(String str, int len) {
        for (int i = 0; i < len; i++) {
            str += " ";
        }
        return str;
    }

}
