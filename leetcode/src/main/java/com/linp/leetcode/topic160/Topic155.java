package com.linp.leetcode.topic160;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * created by : linpeng
 * ON 2020-03-23
 * used for:
 */
public class Topic155 {


    public static void main(String[] ar){
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(1);

        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());

    }

    //实现个 stack
    public  static class MinStack {


        private List<Integer> stack;
        /** initialize your data structure here. */

        public MinStack() {
            stack = new ArrayList<>();
        }

        public void push(int x) {
            stack.add(x);
        }

        public void pop() {
            stack.remove(stack.size()-1);

        }

        public int top() {
         return stack.get(stack.size()-1);
        }

        public int getMin() {
            Object[] a = stack.toArray();
            Arrays.sort(a);
            return Integer.valueOf(""+ a[0]);
        }
    }
}
