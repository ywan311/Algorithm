package net.Programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 교점에 별그리기
*
* 28,29 Integer MAXVAlue 이상 고려 long으로 형변환
* */
public class DrawingStar {
    static Set<long[]> points = new HashSet<>();
    static long minX = Long.MAX_VALUE;
    static long maxX = Long.MAX_VALUE;
    static long minY = Long.MIN_VALUE;
    static long maxY = Long.MIN_VALUE;
    public String[] solution(int[][] line) {

        for(int i =0;i<line.length-1;i++){
            for(int j =i+1;j< line.length;j++){
                getPoints(line[i],line[j]);
            }
        }

        int height = (int)maxY-(int)minY+1;
        int width = (int)maxX-(int)minX+1;
        String[] answer = new String[height];

        char[][] answerArr = new char[height][width];


        for(int i = 0; i<height;i++){
            for(int j = 0; j <width;j++){
                answerArr[i][j]='.';
            }
        }

        for(long[] point : points){
            answerArr[(int)point[1]- (int)minY][(int)point[0] - (int)minX]='*';
        }
        for(int i =0;i<answer.length;i++){
            answer[answerArr.length-1-i] = String.valueOf(answerArr[i]);
        }


        return answer;
    }

    void getPoints(int[] input1 , int[] input2){
        long[] line1 = new long[]{(long)input1[0],(long)input1[1],(long)input1[2]};
        long[] line2 = new long[]{(long)input2[0],(long)input2[1],(long)input2[2]};
        double denominator = (line1[0]*line2[1])-(line1[1] *line2[0]);
        if(denominator==0){
            return;
        }
        double numerator1 = line1[1]*line2[2]-line1[2]*line2[1];
        double numerator2 = line1[2]*line2[0]-line1[0]*line2[2];
        double x = numerator1/denominator;
        double y = numerator2/denominator;

        if(x % 1.0==0.0 && y % 1.0==0.0){
            long[] point = new long[]{(long)(x),(long)(y)};
            points.add(point);
            getMinMax(point[0],point[1]);
        }
    }
    void getMinMax(long x , long y ){
        maxX = Math.max(x,maxX);
        maxY = Math.max(y,maxY);
        minX = Math.min(x,minX);
        minY = Math.min(y,minY);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{100000, 100000, 1}, {100000, -100000, -1}};
        System.out.println(Arrays.toString(new DrawingStar().solution(input)));
    }
}
