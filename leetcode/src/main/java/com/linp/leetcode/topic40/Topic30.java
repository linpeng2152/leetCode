package com.linp.leetcode.topic40;


import java.util.*;

/**
 * created by : linpeng
 * ON 2019-11-02 14:10
 * used for:
 */

public class Topic30 {

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> data = new ArrayList<Integer>();
        if (words.length == 0) {
            return data;
        }

        Map<Integer, String> map = new HashMap<Integer, String>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (String word : words) {
                if (s.startsWith(word, i)) {
                    map.put(i, word);
                }

            }
        }


        int lenWords = words.length;
        int longWord = words[0].length();

        Set<Integer> set = map.keySet();
        for (Integer i : set) {
            if (check(i, lenWords, longWord, set, map, words)) {
                data.add(i);
            }
        }
        return data;
    }

    private static boolean check(Integer i, int lenWords, int longWord, Set<Integer> set, Map<Integer, String> map, String[] words) {


        StringBuilder sb = new StringBuilder();
        Map<String, Integer> mapmap = new HashMap<>();
        int cur = i;
        for (int z = 0; z < lenWords; z++) {
            cur = z * longWord + i;
            if (!set.contains(cur)) {
                return false;
            }
            int conunt = mapmap.get(map.get(cur)) == null ? 1 : mapmap.get(map.get(cur)) + 1;
            sb.append(map.get(cur));
            mapmap.put(map.get(cur), conunt);
        }
        for (String word : words) {
            Integer conunt = mapmap.get(word);
            if (conunt == null || conunt == 0) {
                return false;
            }
            mapmap.put(word, --conunt);

        }


        return true;

    }


    public static void main(String[] args) {
        findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});


    }


}
