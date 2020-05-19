package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Snake {
    static int arr[][];
    static int N;
    static int K;
    static int L;
    static int[] dx = new int[]{0,-1,0,1};
    static int[] dy = new int[]{1,0,-1,0};
    static boolean[][] snakeMap;
    public static void main(String[] args) throws Exception{
       //입력
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr=new int[N][N];
        snakeMap = new boolean[N][N];
        K= Integer.parseInt(br.readLine());
        for(int i=0;i<K;i++){
            String input[] = br.readLine().split(" ");
            arr[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1]=1;
        }
        L = Integer.parseInt(br.readLine());
        TreeMap<Integer,String> comm = new TreeMap<>();
        for(int i=0;i<L;i++){
            String input[] = br.readLine().split(" ");
            comm.put(Integer.parseInt(input[0]),input[1]);
        }
        //탐색
        Player current = new Player(0,0,0);
        snakeMap[current.x][current.y]=true;
        int time=0;
        while(true){

            int nd= current.dir;
            if(!comm.isEmpty()&&comm.firstKey()==time){
              String value = comm.pollFirstEntry().getValue();
              nd += value.equals("D")?3:5;
              System.out.println(nd+":"+time);
              nd%=4;
            }
            int nx = current.x+dx[nd];
            int ny = current.y+dy[nd];

            time++;
            if(nx<0||ny<0||nx>=N||ny>=N)break;
            if(snakeMap[nx][ny])break;

            current.next(nx,ny,nd);

            if(arr[nx][ny]!=1)current.notApple();
            else arr[nx][ny]=0;


            System.out.println(current);
        }
        System.out.println(time);
    }
    static class Player{
        int x;
        int y;
        int dir;
        LinkedList<int[]> tail = new LinkedList<>();

        public Player(int x, int y,int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.tail.add(new int[]{x,y});
        }
        void notApple(){
            int[] tmp = tail.pollFirst();
            snakeMap[tmp[0]][tmp[1]]=false;
        }
        void next(int x,int y,int dir){
            this.x = x;
            this.y =y;
            this.dir=dir;
            this.tail.add(new int[]{x,y});
            snakeMap[x][y]=true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int[] a:tail)sb.append(Arrays.toString(a)+",");
            return "Player{" +
                    "x=" + x +
                    ", y=" + y +
                    ", dir=" + dir +
                    ", tail=" + sb.toString() +
                    '}';
        }
    }
}
