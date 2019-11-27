package com.linp.leetcode.topic60;


/**
 * created by : linpeng
 * ON 2019-11-26 17:58
 * used for:
 */

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic59 {

    public static int[][] generateMatrix(int n) {
        int[][] data = new int[n][n];
        int count = n*n;

        trun(data,1,0,0,1,count,0,n);

        return data;
    }


    /**
     *
     * 1.将 x,y 位置上设置成对应
     * 2、计算下一个值是否需要转向
     * 3、根据当前方向 计算 新的 x，y的值
     *
     * 递归调用 直到 所有的数目都设置了
     */
    public static void trun(int[][] data,int val,int x,int y,int tag,int count,int circle,int n) {
        if(count <= 0){
            return;
        }
        int newVal=0, newX=0, newY=0, newTag=0, newCount=circle,newCircle=0;
        data[x][y] = val;
        newTag = turnL(x,y, tag, n);
        if(newTag == 1){
            newCircle =  ++circle;

        }else if(newTag == -1){
            newTag = tag;
        }



        if(newTag == 1){
            newX = x;
            newY = ++y;
        }else if(newTag ==2){
            newX = ++x;
            newY = y;
        }else if(newTag ==3){
            newX = x;
            newY = --y;
        }else if(newTag ==4){
            newX = --x;
            newY = y;
        }

        newVal = ++val;
        newCount = --count;


        trun(data,newVal, newX, newY, newTag, newCount,newCircle,n);
    }


    /**
     * 判断是否需要转弯
     * 该规律 需要画图研究
     */
    public static int turnL(int x,int y,int tag,int n){

        if(tag == 1){
            if(x+y == n-1 && x < y){
               return 2;
            }
        }else if(tag ==2){
            if(x==y && x >= n/2){
                return 3;
            }

        }else if(tag ==3){
            if(x+y == n-1 && x > y){
                return 4;
            }

        }else if(tag ==4){
            if(x==y+1 && x <= n/2){
                return 1;
            }

        }
        return -1;//代表不用转向
    }




    public static void main(String[] args) {

        int[][] data = generateMatrix(4);

        System.out.println(data[0][0]);
    }
}
