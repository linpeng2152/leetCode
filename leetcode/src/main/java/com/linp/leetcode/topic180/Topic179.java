//package com.linp.leetcode.topic180;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author : linpeng
// * ON 2020-04-13
// * used for:
// */
//public class Topic179 {
//
//    /**
//     * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
//     * <p>
//     * 示例 1:
//     * <p>
//     * 输入: [10,2]
//     * 输出: 210
//     * 示例 2:
//     * <p>
//     * 输入: [3,30,34,5,9]
//     * 输出: 9534330
//     * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
//     * <p>
//     * 通过次数27,091提交次数75,431
//     * <p>
//     * 来源：力扣（LeetCode）
//     * 链接：https://leetcode-cn.com/problems/largest-number
//     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//     *
//     * @param nums
//     * @return
//     */
//
//
//    public String largestNumber(int[] nums) {
//
//        List<String> l = new ArrayList<>(nums.length);
//        for (int i : nums) {
//            l.add(i+"");
//        }
//        String str = "";
//        for(;;){
//            if(l.size() == 0){
//                break;
//            }
//            Integer value = getNextIndex(l,0);
//            if(value == null){
//                break;
//            }
//            str += l.get(value);
//            l.remove(value);
//
//        }
//
//        return "";
//    }
//
//
//    public static Integer getNextIndex(List<String> l,int index) {
//        if(l.size() == 0){
//            return null;
//        }
//        int v = -1;
//        List<Integer> newL = new ArrayList<>();
//        for (int i =0;i<l.size();i++){
//            if(l.get(i) > v){
//                v = l.get(i);
//            }
//
//        }
//
//
//    }
//
//
//    public static Integer getV()[]
//}
