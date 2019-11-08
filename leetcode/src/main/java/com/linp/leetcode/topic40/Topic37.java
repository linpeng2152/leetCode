package com.linp.leetcode.topic40;


import java.util.HashSet;
import java.util.Set;

/**
 * created by : linpeng
 * ON 2019-11-07 14:11
 * used for:
 */

public class Topic37 {

    public static void solveSudoku(char[][] board) {


        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if( board[i][j] != '.'){
                    continue;
                }
                for(int k = 1; k <= 9; k++){
                    board[i][j] = change2Char(k);
                    if(isValidSudoku(board)){
                        break;
                    }else{
                        continue;
                    }
                }
            }
        }
    }



    public static boolean isValidSudoku(char[][] board) {

        char[] item = new char[9];


        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                item[j] = board[i][j];
            }
            if(!check(item)){
                return false;
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                item[j] = board[j][i];
            }
            if(!check(item)){
                return false;
            }
        }


        return checkByOne(0,0,board)
                && checkByOne(0,3,board)
                && checkByOne(0,6,board)
                && checkByOne(3,0,board)
                && checkByOne(3,3,board)
                && checkByOne(3,6,board)
                && checkByOne(6,0,board)
                && checkByOne(6,3,board)
                && checkByOne(6,6,board);



    }

    public static boolean checkByOne(int x,int y ,char[][] board){
        char[] item = new char[9];
        item[0] = board[x][y];
        item[1] = board[x][y+1];
        item[2] = board[x][y+2];
        item[3] = board[x+1][y+0];
        item[4] = board[x+1][y+1];
        item[5] = board[x+1][y+2];
        item[6] = board[x+2][y+0];
        item[7] = board[x+2][y+1];
        item[8] = board[x+2][y+2];

        return check(item);
    }

    public static boolean check(char[] item){
        Set<Integer>  s = new HashSet<Integer>();

        for(int i = 0; i < item.length; i++) {
            if('.' == item[i]){
                continue;
            }
            Integer j = change2Int(item[i]);
            if( j > 9 ||  j < 0){
                return false;
            }
            if(!s.add( j)){
                return false;
            }
        }
        return true;
    }
    public static Integer change2Int(char c){
        if('1' == c){
            return 1;
        } if('2' == c){
            return 2;
        } if('3' == c){
            return 3;
        } if('4' == c){
            return 4;
        } if('5' == c){
            return 5;
        } if('6' == c){
            return 6;
        } if('7' == c){
            return 7;
        } if('8' == c){
            return 8;
        } if('9' == c){
            return 9;
        }

        return 0;
    }
    public static char change2Char(int c){
        if(1 == c){
            return '1';
        }
        if(2 == c){
            return '2';
        }
        if(3 == c){
            return '3';
        }
        if(4 == c){
            return '4';
        }
        if(5 == c){
            return '5';
        }
        if(6 == c){
            return '6';
        }
        if(7 == c){
            return '7';
        }
        if(8 == c){
            return '8';
        }
        if(9 == c){
            return '9';
        }
        return '.';
    }


    public static void main(String args[]){
        char[][] board =    {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
        System.out.println(board);


    }

}
