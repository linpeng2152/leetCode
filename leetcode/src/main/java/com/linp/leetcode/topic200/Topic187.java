package com.linp.leetcode.topic200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author : linpeng
 * ON 2020-12-03
 * used for:
 *
 *
 * 179 ~ 187 为 sql
 */
public class Topic187 {


    /**
     * 所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     *
     * 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     * 输出：["AAAAACCCCC","CCCCCAAAAA"]
     * 示例 2：
     *
     * 输入：s = "AAAAAAAAAAAAA"
     * 输出：["AAAAAAAAAA"]
     *  
     *
     * 提示：
     *
     * 0 <= s.length <= 105
     * s[i] 为 'A'、'C'、'G' 或 'T'
     * 通过次数25,933提交次数56,628
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> l1 = new HashSet<>();
        Set<String> l2 = new HashSet<>();

        int c = s.length() - 10;

        for(int i = 0;i<=c;i++){
            String item = s.substring(i,i+10);
            if(!l1.add(item)){
                l2.add(item);
            }
        }

        return new ArrayList<>(l2);
    }


    public static void main(String[] a){
        String s = "AAAAAAAAAAA";
//        System.out.println(s.length());

        List<String> l = findRepeatedDnaSequences2(s);
//
//        System.out.println(l.size());
        System.out.println(Long.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }

    public static List<String> findRepeatedDnaSequences2(String s) {
        if(s.length()<11) return new ArrayList<>();
        int f = 1048575;
        char[] cs = s.toCharArray();
        int tmp = 0;
        for(int i=0;i<10;i++) {
            tmp<<=2;
            tmp|=key(cs[i]);
        }
        Set<Integer> set = new HashSet<>();
        set.add(tmp);
        Set<String> ans = new HashSet<>();

        for(int i=10;i<cs.length;i++){
            tmp <<=2;
            tmp |= key(cs[i]);
            int p = tmp & f;
            if(set.contains(p)){
                ans.add(cast(p));
            }else set.add(p);
        }
        return new ArrayList<>(ans);
    }
    private static int key(char c){
        switch(c){
            case 'A':return 0;
            case 'C':return 1;
            case 'G':return 2;
            case 'T':return 3;
        }
        return -1;
    }
    private static char val(int c){
        switch(c){
            case 0:return 'A';
            case 1:return 'C';
            case 2:return 'G';
            case 3:return 'T';
        }
        return 'm';
    }
    private static String cast(int val){
        char[] cs = new char[10];
        for(int i=9;i>-1;i--){
            cs[i] = val(3 & val);
            val>>=2;
        }
        return new String(cs);
    }


}


