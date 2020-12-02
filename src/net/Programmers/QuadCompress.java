package net.Programmers;

import java.util.Arrays;

public class QuadCompress {
    static int[][] inputArr;
    public int[] solution(int[][] arr) {
        inputArr = arr;
        return check(0,arr.length-1,0,arr.length-1);
    }
    public int[] check(int x1, int x2, int y1, int y2){
        System.out.println(x1+"/"+x2+"/"+y1+"/"+y2);
        if(x1==x2 || y1==x2){
            if(inputArr[x1][y1]==1)return new int[]{0,1};
            else return new int[]{1,0};
        }
        int midx = (x1+x2)/2;
        int midy = (y1+y2)/2;
        int[][] answerArr = new int[4][2];
        answerArr[0]= check(x1,midx,y1,midy);
        answerArr[1]= check(x1,midx,midy+1,y2);
        answerArr[2]= check(midx+1,x2,y1,midy);
        answerArr[3]= check(midx+1,x2,midy+1,y2);

        int[] answer = new int[2];

        for(int[] a : answerArr){
            answer[0] += a[0];
            answer[1] += a[1];
        }
        if(answer[0]==4 && answer[1]==0)return new int[]{1,0};
        else if(answer[1]==4 && answer[0]==0)return new int[]{0,1};
        else return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new QuadCompress().solution(new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}})));
    }
}
