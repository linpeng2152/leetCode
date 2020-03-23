package com.linp.leetcode.topic80;


/**
 * created by : linpeng
 * ON 2019-12-16 16:42
 * used for:
 */

/**
 * 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1:
 * <p>
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2:
 * <p>
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic72 {

    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
//        System.out.println(minDistance("intention","execution"));

    }

    /**
     * 无解决
     * 无法判断最短路径
     */
    public static int minDistance(String word1, String word2) {

        String longText = word1.length() < word2.length() ? word2 : word1;
        int longLen = longText.length();
        String shortText = word1.length() < word2.length() ? word1 : word2;
        int shortLen = shortText.length();
        min = Integer.MAX_VALUE;

        if(longLen == shortLen){
            checkAndAdd(longText,shortText,longLen - shortLen);
            return min;
        }

        distance(longText,shortText,shortLen,"",longLen - shortLen);

        return min;
    }

    public static void distance(String longText,String shortText,int shortLen,String itemText,int curMin){
        if(itemText.length() == shortLen){
            checkAndAdd(shortText,itemText,curMin);
        }else{
            int len = longText.length();
            for(int i = 0; i < len - 1; i ++ ){
                if(i <= len - 2){
                    distance(longText.substring(i + 1),shortText,shortLen,  itemText + longText.charAt(i),curMin);
                }
            }

        }

    }



    public static void checkAndAdd(String word1, String word2,int curMin) {
        int stepNum = curMin;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                stepNum ++;
                if(stepNum > min){
                    return;
                }

            }
        }
        if(stepNum < min){
            min = stepNum;
        }
    }

}
