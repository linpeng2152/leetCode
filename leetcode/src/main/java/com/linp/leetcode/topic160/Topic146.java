package com.linp.leetcode.topic160;

/**
 * created by : linpeng
 * ON 2020-03-20
 * used for:
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 *
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 /* 缓存容量）;
*/
//        *
//        *cache.put(1,1);
//        *cache.put(2,2);
//        *cache.get(1);       // 返回  1
//        *cache.put(3,3);    // 该操作会使得密钥 2 作废
//        *cache.get(2);       // 返回 -1 (未找到)
//        *cache.put(4,4);    // 该操作会使得密钥 1 作废
//        *cache.get(1);       // 返回 -1 (未找到)
//        *cache.get(3);       // 返回  3
//        *cache.get(4);       // 返回  4
//        *通过次数39,321提交次数84,811
//        *在真实的面试中遇到过这道题？

public class Topic146 {

    public static void  main(String[] a){

        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);    // 该操作会使得密钥 2 作废

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(4,4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(4));

        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));




    }


    public static class LRUCache {

        private Map<Integer,Integer> map;
        private List<Integer> keys;

        private int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            keys = new ArrayList<>(capacity);
            this.capacity = capacity;
        }

        public int get(int key) {
            Integer value = -1;
            if(keys.contains(key)){
                 value = map.get(key);
                put(key,value);
            }
            return value;
        }

        public void put(int key, int value) {
            if(keys.contains(key)){
                int i =  keys.lastIndexOf(key);
                keys.remove(i);

                keys.add(0,key);
                map.put(key,value);
            }else {
                add(key,value);
            }
        }

        private void add(int key, int value){
            if(capacity > 0 ){
                capacity--;

                keys.add(0,key);
                map.put(key,value);
            }else {
                Integer lastKey = keys.get(keys.size() -1);
                map.remove(lastKey);
                keys.remove(keys.size() -1);

                keys.add(0,key);
                map.put(key,value);
            }

        }

    }
}