package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BreakWall {
    static int[][][] arr;
    static boolean[][] map;
    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static  int width;
    static int height;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s1 = br.readLine().split(" ");
        width= Integer.parseInt(s1[0]);
        height= Integer.parseInt(s1[1]);

        if(width==1&&height==1){
            System.out.println(1);
            return;
        }

        arr = new int[2][width][height];
        map = new boolean[width][height];
        for(int i=0; i<width; i++) {
            String s = br.readLine();

            for(int j=0; j<height; j++){
                arr[0][i][j]=0;
                arr[1][i][j]=0;
                map[i][j] = s.charAt(j)=='0'?true:false;
            }
        }
        bw.write(String.valueOf(BFS(0, 0)));
        for(int[] a:arr[1])System.out.println(Arrays.toString(a));
        System.out.println("------------------------------------");
        for(int[] a:arr[0])System.out.println(Arrays.toString(a));
        bw.flush();
    }
    public static int BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        int[] next = new int[]{x,y,1};//x,y,벽깨기 여부
        queue.add(next);
        while(!queue.isEmpty()){
            int value[] = queue.poll();
            if(arr[1][value[0]][value[1]]>1)continue;
            arr[1][value[0]][value[1]]++;
            for(int i=0;i<4;i++){
                int nx = value[0]+dx[i];
                int ny = value[1]+dy[i];

                if (nx < 0 || nx >= width || ny < 0 || ny >= height) continue;

                System.out.println(Arrays.toString(value));
                System.out.println(nx+"  "+ny);
                if(value[2]==0){
                    if(!map[nx][ny]||arr[1][nx][ny]>0)continue;
                    else{
                        arr[0][nx][ny]=arr[0][value[0]][value[1]]+1;
                        queue.add(new int[]{nx,ny,0});
                    }
                }else{
                    if(arr[1][nx][ny]>1)continue;
                    if(!map[nx][ny]){
                        arr[0][nx][ny]=arr[0][value[0]][value[1]]+1;
                        queue.add(new int[]{nx,ny,0});
                    }else{
                        arr[1][nx][ny]=0;
                        arr[0][nx][ny]=arr[0][value[0]][value[1]]+1;
                        queue.add(new int[]{nx,ny,1});
                    }
                }


            }
        }
        return arr[0][width-1][height-1]==0?-1:arr[0][width-1][height-1]+1;
    }
}
