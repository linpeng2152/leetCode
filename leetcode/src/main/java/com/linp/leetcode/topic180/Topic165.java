package com.linp.leetcode.topic180;

/**
 * @Author : linpeng
 * ON 2020-04-13
 * used for:
 */

/**
 * 165. 比较版本号
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。其第三级和第四级修订号均为 0。
 *
 */
public class Topic165 {

    /**
     * 示例 1:
     *
     * 输入: version1 = "0.1", version2 = "1.1"
     * 输出: -1
     * 示例 2:
     *
     * 输入: version1 = "1.0.1", version2 = "1"
     * 输出: 1
     * 示例 3:
     *
     * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
     * 输出: -1
     * 示例 4：
     *
     * 输入：version1 = "1.01", version2 = "1.001"
     * 输出：0
     * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
     * 示例 5：
     *
     * 输入：version1 = "1.0", version2 = "1.0.0"
     * 输出：0
     * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/compare-version-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String[] args){
        String version1 = "7.5.2.4";
        String version2 = "7.5.3";

        System.out.println(compareVersion(version1,version2));

    }


    /**
     * 核心：
     * 1、\\. 转义符 去切分
     * 2、取值比较时 超出长度时 直接返回 0；
     *
     */
    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int l = Math.max(arr1.length,arr2.length);

        for(int i = 0;i<l  ;i++){
            int v1 = str2Int(i,arr1);
            int v2 = str2Int(i,arr2);
            if(v1 > v2){
                return  1;
            }
            if(v1 < v2){
                return  -1;
            }

        }
        return 0;

    }

    public static int str2Int(int i,String[] a){
        if(i >= a.length){
            return 0;
        }
        String s = a[i];
        while (s.startsWith("0") && s.length() >= 2){
            s = s.substring(1);

        }
        return Integer.valueOf(s);
    }



}
