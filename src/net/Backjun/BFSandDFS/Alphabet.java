package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Alphabet {
    static int R;
    static int C;
    static char[][] arr;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        R = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);

        arr = new char[R][C];

        for(int i=0;i<R;i++){
            String str = br.readLine();
            for(int j=0;j<C;j++){
                arr[i][j] = str.charAt(j);
            }
        }
        //---------- 입력
        System.out.println(DFS(0,0,1));

    }
    public static int DFS(int x,int y,int distance){
        System.out.println(x+"   "+y+"   "+distance);
        System.out.println(arr[x][y]);
        set.add(arr[x][y]);
        int max = distance;
        for(int i =0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=R&&ny>=C)return max;
            if(nx<0||nx>=R||ny<0||ny>=C)continue;
            if(set.contains(arr[nx][ny]))continue;
            max =Math.max(max,DFS(nx,ny,distance+1));
        }
        set.remove(arr[x][y]);
        return max;
    }
}
