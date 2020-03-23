package com.linp.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * created by : linpeng
 * ON 2020-03-20
 * used for: 赌博 理论
 */
public class Gambling {

    private Random random = new Random();

    private Integer fool = 10000 * 0000; //底 一亿



    private double rate = 0.45; //客人赢的概率

    private double p = 0.01; //抽成



    //判断输赢  true 客赢
    public boolean victoryOrDefeat() {
        return random.nextInt(1000000) <= 1000000*rate;
    }

    //下注
    public Integer bets(Integer v) {
        if (victoryOrDefeat()) {//ke赢
            int shouxufei =  new Double(v*p).intValue();
            fool = fool - v + shouxufei;
            return 2 * v - shouxufei;
        } else {//ke输
            fool = fool + v;
            return 0;
        }
    }

    private Integer max = 5 * 10000;//出局数目

    public static void main(String[] a) {
        int account = 100000;//底
        int max = account +  100000;//赢1万出局
        int note = 1;//基础底


        int falseNum = 0;
        int successNum = 0;

        List<Integer> su = new ArrayList<>();
        List<Integer> fail = new ArrayList<>();

        for(int i = 0;i<1000;i++){
            int cc = doBest(account,note,max);
            if(cc > 0){
                su.add(cc);
            }else {
                fail.add(cc);
            }
        }


        System.out.println("基础底"+note+",赢"+(max-account)+".. 的结果 成功："+su.size()+ "  失败："+fail.size());

        int count = 0;
        for(int i:su){
            count += i;
        }
        System.out.println("赢钱 平均需要次数 ："+(count/su.size()));
        System.out.println("赢钱 平均需要时间 ："+(count/su.size() * 5 / 60 ));
        count=0;
        for(int i:fail){
            count += i;
        }
        System.out.println("输钱 平均需要次数 ："+(count/fail.size() ));
        System.out.println("输钱 平均需要 ："+(count/fail.size() * 5 / 60 ));
    }


    public static Integer doBest(int account, int note,int max) {
        Gambling g = new Gambling();
        int i = 0;
        while (true) {
            i++;
            account = account - note;//下注了
            Integer result = g.bets(note);
            System.out.println("第"+i+"次"+"底："+note+" 结果："+result);

            if (result == 0) {
                note = 2 * note;
            } else {
                note = 100;
                account = account + result;
            }
            if (account <= 0) {
                return i * -1;
            }
            if(max <= account) {
                return i;
            }
            System.out.println("------------------------------------------------   第"+i+"次"+" 结余："+account);

        }

    }


}

