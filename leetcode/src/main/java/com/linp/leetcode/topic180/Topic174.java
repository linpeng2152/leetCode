package com.linp.leetcode.topic180;

/**
 * created by : linpeng
 * ON 2020-04-02
 * used for:
 */

/**
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * <p>
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * <p>
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0）
 * ，要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * <p>
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * <p>
 * <p>
 * <p>
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * <p>
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * <p>
 * <p>
 * 说明:
 * <p>
 * 骑士的健康点数没有上限。
 * <p>
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 通过次数8,320提交次数20,483
 * 在真实的面试中遇到过这道题？
 */
public class Topic174 {

    private int min_v = Integer.MIN_VALUE;



    public int calculateMinimumHP(int[][] dungeon) {
        turn(dungeon,0,0,dungeon[0][0],dungeon[0][0]);
        if(min_v >= 0 ){
            return 1;
        }
        return (0-min_v) + 1;
    }


    private void turn(int[][] dungeon, int x, int y, int cur, int min) {
        int h = dungeon[0].length; // y
        int l = dungeon.length;//x

        boolean turnR = x < l - 1;
        boolean turnD = y < h - 1;
        if(min < 0 && min < min_v){
            return;
        }
        if(!turnR && !turnD){
            if(min_v < min){
                min_v = min;
            }
        }
        if (turnR) {
            int newMin = min;
            int newCur = dungeon[x + 1][y] + cur;
            if (newCur < min) {
                newMin = newCur;
            }
            turn(dungeon, x + 1, y, newCur, newMin);
        }
        if (turnD) {
            int newMin = min;
            int newCur = dungeon[x][y + 1] + cur;
            if (newCur < min) {
                newMin = newCur;
            }
            turn(dungeon, x, y + 1, newCur, newMin);
        }

    }

    public static void main(String[] a){
        Topic174 t = new Topic174();
        int[][] dungeon = {{-2,-3,3},{ -5,-10,1},{10,30,-5}};
//        int[][] dungeon = {{0}};

        System.out.println(t.calculateMinimumHP(dungeon));


    }


}
