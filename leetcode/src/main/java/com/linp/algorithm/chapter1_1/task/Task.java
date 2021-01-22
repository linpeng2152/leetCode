package com.linp.algorithm.chapter1_1.task;

import com.linp.algorithm.base.StdIn;

/**
 * @Author : linpeng
 * ON 2020-09-14
 * used for:
 */
public class Task {

    public static void main(String[] ars){
//        task01();
//        task02();
//        task03();
//        task05();
//        task06();
        task07();

    }

    public static void task01(){
        StdIn.print(" a.(0 +15 ) / 2 = 7 答案 == " + ((0 +15 ) / 2));
        StdIn.print(" c. true && false || true && true  == true 答案 == " + (true && false || true && true ));
    }
    public static void task02(){
        StdIn.print(" a.(1 +2.236 ) / 2 = 1.618 ,浮点数  答案 == " + ((1 +2.236 ) / 2));
        StdIn.print(" b.1+2+3+4.0  = 10.0  ,浮点数  答案 == " + (1+2+3+4.0 ));
        StdIn.print(" c.4.1 >= 4 = true  ,布尔  答案 == " + (4.1 >= 4 ));
        StdIn.print(" d.1+2+\"3\" >=  = 33  ,字符串  答案 == " + (1+2+"3" ));
        StdIn.print(" e.\"1\"+2+3 >=  = 123  ,字符串  答案 == " + ("1"+2+3 ));
    }

    /**
     * 从命令行 输入三个整数 判断是否都相等
     */
    public static void task03(){
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        int c = StdIn.readInt();

        StdIn.print(""+ (a == b && a == c));
    }

    public static void task04(){
        int a = 2;
        int b = 3;
        int c = 0;

        StdIn.print(" a.if (a>b) then c = 0;  答案 没有关键字 then ");
        StdIn.print(" b.if a>b {then c = 0;}  答案 判断条件需要被包含 ");
        StdIn.print(" c.if(a>b) c = 0;  没有问题 ");
    }


    public static void task05(){
        double b = StdIn.readDouble();
        StdIn.print("" + (b > 0 && b <1));
    }

    public static void task06(){
        int f = 0;
        int g = 1;
        for(int i =0;i<15;i++){
            StdIn.print(""+f);
            f = f +g;
            g = f - g;
        }
        StdIn.print("f = "+ f);
        StdIn.print("g = " + g);

    }


    public static  void task07(){
        StdIn.print("a --------------------  a");
        int sum = 0;
        for(int i = 1;i < 1000;i++){
            for (int j = 0;j<i;j++){
                sum++;
            }
        }

        StdIn.print(""+sum);

        StdIn.print("a --------------------  a");
    }



}
