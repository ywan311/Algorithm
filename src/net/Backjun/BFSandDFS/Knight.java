package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Knight {
    static boolean[][] arr;
    static int[] dx = new int[]{2, 1, 2, 1, -2, -1, -2, -1};
    static int[] dy = new int[]{1, 2, -1, -2, 1, 2, -1, -2};

    static int N;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int loop = Integer.parseInt(br.readLine());

        for (int i = 0; i < loop; i++) {
            N = Integer.parseInt(br.readLine());

            arr = new boolean[N][N];

            String[] str1 = br.readLine().split(" ");

            int x = Integer.parseInt(str1[0]);
            int y = Integer.parseInt(str1[1]);

            String[] str2 = br.readLine().split(" ");
            int tx = Integer.parseInt(str2[0]);
            int ty = Integer.parseInt(str2[1]);

            int r =BFS(x,y,tx,ty);
            bw.write(r+"\n");
        }
        bw.flush();
    }

    static int BFS(int x, int y, int tx, int ty) {
        if(x==tx&&y==ty)return 0;
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>();
        ArrayList<int[]> list = new ArrayList<>();

        queue.add(new int[]{x,y});

        while(true){
            answer ++;

            while(!queue.isEmpty()){
                int[] current= queue.poll();
                arr[current[0]][current[1]]=true;


                for(int i=0;i<8;i++){
                    int nx = current[0]+dx[i];
                    int ny = current[1]+dy[i];



                    if(nx<0||nx>=N||ny<0||ny>=N)continue;
                    if(arr[nx][ny])continue;
                    if(nx==tx&&ny==ty)return answer;

                    arr[nx][ny] = true;
                    list.add(new int[]{nx,ny});
                }
            }
            if(list.isEmpty())return answer;
            queue.addAll(list);
            list.clear();
        }
    }
}
