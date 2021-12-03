package net.Programmers;

import java.util.Arrays;

//2021 Dev-Matching: 웹 백엔드 개발자(상반기) 행렬 테두리 회전하기
public class MatrixBorder {
    static int[][] arr;
    static int min = Integer.MAX_VALUE;
    static int[] dx= new int[]{0,1,0,-1};
    static int[] dy= new int[]{1,0,-1,0};

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        arr = new int[rows][columns];
        int n=1;
        for(int i=0;i<rows;i++){
            for(int j =0; j<columns;j++){
                arr[i][j]=n++;
            }
        }
        int index=0;
        for(int[] a : queries){
            spin(a[0]-1,a[1]-1,a[2]-1,a[3]-1);
            answer[index++]= min;
            for(int[] b : arr)
            min=Integer.MAX_VALUE;
        }

        return answer;
    }
    void spin(int x1,int y1, int x2,int y2){
        int tmp = arr[x1][y1];
        min= Math.min(tmp,min);
        int width = x2-x1;
        int height = y2-y1;
        int nx = x1;
        int ny = y1;

        for(int i=0;i<4;i++){
                for(int j = 0;j <  (i%2==0?height:width) ;j++){
                    nx +=dx[i];
                    ny +=dy[i];
                    int tmp2 =arr[nx][ny];
                    arr[nx][ny]=tmp;
                    tmp=tmp2;
                    min= Math.min(tmp,min);
                }
        }

    }


    public static void main(String[] args) {
        int row = 6;
        int col = 6;
        int[][] queries = new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
    }
}
