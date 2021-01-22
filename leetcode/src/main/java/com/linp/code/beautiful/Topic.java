package com.linp.code.beautiful;

import java.util.Random;

/**
 * @Author : linpeng
 * ON 2020-10-26
 * used for:
 */
public class Topic {



    public static void main(String[] arge){

//        for(int h = 1; h < 100;h++){
        int h = 10;
            int t = 0;
            for(int y = 0;y<1000;y++){
                t +=  times(h);
            }
            System.out.println(" 高 ："+h + " t :" + (t/1000));

//        }


    }


    public static int times(int height) {
        //随机楼层
        int level = 1 + new Random().nextInt(99);


        int l = 1;
        int times = 0;

        for (int i = 0; l + i < level; i += height) {
            times++;
        }
        l = times * height;
        times += (level - l);
        return times;
    }


}
