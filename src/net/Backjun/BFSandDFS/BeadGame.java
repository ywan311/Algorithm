package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BeadGame {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int hx;
    static int hy;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        arr = new char[N][M];
        visited = new boolean[N][M];

        int[] r=new int[2];
        int[] b=new int[2];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'R') r = new int[]{i, j};
                else if (arr[i][j] == 'B') b = new int[]{i, j};
                else if (arr[i][j] == 'O'){
                    hx=i;
                    hy=j;
                }
            }
        }
        BFS(r,b);
        answer = answer>10?-1:answer;
        System.out.println(answer);
    }

    static void BFS(int[] r, int[] b) {
        Queue<int[]> redQueue = new LinkedList<>();
        Queue<int[]> blueQueue = new LinkedList<>();
        redQueue.offer(new int[]{r[0], r[1]});
        blueQueue.offer(new int[]{b[0], b[1]});
        visited[r[0]][r[1]] = true;
        ArrayList<int[]> list = new ArrayList<>();
        int[] currentR;
        int[] currentB;
        while (++answer <= 10) {
            while (!redQueue.isEmpty()) {
                currentR = redQueue.poll();
                currentB = blueQueue.poll();
                arr[currentR[0]][currentR[1]]='R';
                arr[currentB[0]][currentB[1]]='B';
//                System.out.println(Arrays.toString(currentR)+"-------------------------");
                boolean flag=false;//먼저 움직일 친구 찾기
                for (int i = 0; i < 4; i++) {
                    int rnx = currentR[0] + dx[i];
                    int rny = currentR[1] + dy[i];
                    int bnx = currentB[0] + dx[i];
                    int bny = currentB[1] + dy[i];

                    if (rnx < 0 || rny < 0 || rnx >= N || rny >= M) continue;
                    if (arr[rnx][rny]=='O')return;
                    if (visited[rnx][rny] || arr[rnx][rny] != '.') continue;
                    visited[rnx][rny] = true;

                    if(i<2)flag = (rnx-bnx)*dx[i]>0;
                    else flag = (rny-bny)*dy[i]>0;
                    int[] resultR;
                    int[] resultB;
                    if(flag){
                        resultR = move(rnx,rny,i,true);
                        arr[currentR[0]][currentR[1]]='.';
                        resultB = move(bnx,bny,i,false);
                        arr[currentB[0]][currentB[1]]='.';
                        if(bnx+dx[i]==hx&&bny+dy[i]==hy){
                            answer=11;
                            return;
                        }
                        if(rnx+dx[i]==hx&&rny+dy[i]==hy){
                            return;
                        }
                        if(resultB!=null&&resultB[0]==resultR[0]&&resultB[1]==resultR[1]){
                            resultB[0]-=dx[i];
                            resultB[1]-=dy[i];
                        }
                    }else{
                        resultB = move(bnx,bny,i,false);
                        arr[currentB[0]][currentB[1]]='.';
                        resultR = move(rnx,rny,i,true);
                        arr[currentR[0]][currentR[1]]='.';
                        if(bnx+dx[i]==hx&&bny+dy[i]==hy){
                            answer=11;
                            return;
                        }
                        if(rnx+dx[i]==hx&&rny+dy[i]==hy){
                            return;
                        }
                        if(resultB!=null&&resultB[0]==resultR[0]&&resultB[1]==resultR[1]){
                            resultR[0]-=dx[i];
                            resultR[1]-=dy[i];
                        }
                    }
//                    System.out.println(Arrays.toString(resultR));

                    if(resultB==null){
                        bnx=currentB[0];
                        bny=currentB[1];
                    }else {
                        bnx = resultB[0];
                        bny = resultB[1];
                    }
                    rnx = resultR[0];
                    rny = resultR[1];


//                    System.out.println("B"+bnx+"/"+bny);

                    blueQueue.offer(new int[]{bnx,bny});

//                    System.out.println("R"+rnx+"/"+rny);

                    list.add(new int[]{rnx,rny});
                }
                for(char[] a: arr)System.out.println(Arrays.toString(a));
            }
//            for(int i[]:list)System.out.println(Arrays.toString(i));
            if(list.isEmpty()){
                answer=11;
                return;
            }
            redQueue.addAll(list);
            list.clear();
        }
    }
    static int[] move(int nx, int ny, int i,boolean flag){
//        System.out.println(flag+"     "+nx+" "+ny);
        if(nx < 0 || ny < 0 || nx >= N || ny >= M||arr[nx][ny]!='.'){
            return null;
        }
        //파란 구슬을 벽이나 구멍, 빨간구슬까지 이동시킨다, 만약 길이없으면 현재위치를 다시 큐에 넣는다
        else while(arr[nx+dx[i]][ny+dy[i]]=='.'&&nx >= 0 && ny >= 0 && nx < N && ny < M){
            nx+=dx[i];
            ny+=dy[i];
            if(flag)visited[nx][ny]=true;
        }
        return  new int[]{nx,ny};
    }

}
