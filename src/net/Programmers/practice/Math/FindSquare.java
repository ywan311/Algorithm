package net.Programmers.practice.Math;

import java.util.Arrays;

public class FindSquare {


    public int solution(int[][] board) {
        int answer = 0;
        for(int i=0;i<board.length;i++){
            answer = Math.max(answer,board[i][0]);
        }
        for(int i=0;i<board[0].length;i++){
            answer = Math.max(answer,board[0][i]);
        }
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j]>=1) {
                    int min = Math.min(board[i-1][j],board[i][j-1]);
                    min = Math.min(min,board[i-1][j-1]);

                    board[i][j] = min+1;

                    answer = Math.max(board[i][j], answer);
                }
            }
        }
        for(int[] a: board)System.out.println(Arrays.toString(a));

        return answer*answer;
    }



    public static void main(String[] args) {
        System.out.println(new FindSquare().solution(new int[][]{{0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}));
    }
}
