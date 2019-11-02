package com.linp.leetcode.topic20;


/**
 * created by : linpeng
 * ON 2019-10-31 11:26
 * used for:
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Topic17 {

    public static Map<String,String[]> numberStringMap = numberStringMap();

    public static List<String> letterCombinations(String digits) {
        if(digits == null){
            return new ArrayList<String>();
        }
        digits = digits.replaceAll("1","");
        if( "".equals(digits)){
            return new ArrayList<String>();
        }
        List<String> strAll = new ArrayList<String>();
        number2String(strAll,"",digits);
        return strAll;
    }



    public static void number2String(List<String> strAll,String str,String number){
        if("".equals(number)){
             strAll.add(str);
             return;
        }
        String charFirst = String.valueOf(str.charAt(0));
        String[] charFirstStrArr = numberStringMap.get(charFirst);
        String lastNumber = str.substring(1);
        for(String item:charFirstStrArr){
            String newStr = str + item;
            number2String(strAll,newStr,lastNumber);
        }

    }


    public static Map<String,String[]> numberStringMap(){
        Map<String,String[]> map = new HashMap<String,String[]>();
        map.put("2",new String[]{"a","b","c"});
        map.put("3",new String[]{"d","e","f"});
        map.put("4",new String[]{"g","h","i"});
        map.put("5",new String[]{"j","k","l"});
        map.put("6",new String[]{"m","n","o"});
        map.put("7",new String[]{"p","q","r","s"});
        map.put("8",new String[]{"t","u","v"});
        map.put("9",new String[]{"w","x","y","z"});
        return map;
    }



    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));


    }
}
