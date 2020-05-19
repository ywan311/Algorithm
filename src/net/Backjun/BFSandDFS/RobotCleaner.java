package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RobotCleaner {
    static int N;
    static int M;
    static int[][] arr;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int answer = 0;
/*
* 로봇 청소기는 다음과 같이 작동한다.

1현재 위치를 청소한다.
2-a현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
2-b왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
2-c왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
2-d네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
* */

    static void BFS(int x, int y,int direct){
        Robot r = new Robot(x,y,direct);
        Queue<Robot> queue = new LinkedList<>();
        queue.add(r);
        arr[r.x][r.y]=2;
        while(!queue.isEmpty()){
            Robot current = queue.poll();
            for(int i[]: arr)System.out.println(Arrays.toString(i));
            int tmpD=current.direct;

            for(int i=0;i<4;i++){
                //방향을 따라 청소할 곳이 있는지 체크
                tmpD =(tmpD+3)%4;
                int nx = current.x+dx[tmpD];
                int ny = current.y+dy[tmpD];
                if(nx<0||ny<0||nx>=N||ny>=M)continue;

                if(arr[nx][ny]==0){
                    queue.add(new Robot(nx,ny,tmpD));
                    arr[nx][ny]=2;

                    break;
                }

                //청소할곳이 없이 마지막까지 왔다면검사
                if(i==3){
                    nx = current.x-dx[current.direct];
                    ny = current.y-dy[current.direct];

                    if(nx<0||ny<0||nx>=N||ny>=M||arr[nx][ny]==1)return;
                    queue.add(new Robot(nx,ny,(current.direct)%4));
                }
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().split(" ");
        N =Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        String start[] = br.readLine().split(" ");
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            String input[] = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                arr[i][j]=Integer.parseInt(input[j]);
            }
        }

        BFS(Integer.parseInt(start[0]),Integer.parseInt(start[1]),Integer.parseInt(start[2]));
        for(int i[]: arr)for(int a:i)if(a==2)answer++;
        System.out.println(answer);


    }
}

class Robot {
    int x;
    int y;
    int direct;

    public Robot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direct=" + direct +
                '}';
    }
}
