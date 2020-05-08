package net.Backjun.BFSandDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//왜안되는지 모르겠네
public class BeadGame {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
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

            }
        }
        BFS(r,b);
        answer = answer>10?-1:answer;
        System.out.println(answer);
    }

    static void BFS(int[] r, int[] b) {
        //시작점을 queue에 넣고 visited는 red 만 체크
        Queue<Bead> redQueue = new LinkedList<>();
        Queue<Bead> blueQueue = new LinkedList<>();
        redQueue.offer(new Bead(r[0], r[1],true));
        blueQueue.offer(new Bead(b[0], b[1],false));
        visited[r[0]][r[1]] = true;

        ArrayList<Bead> list = new ArrayList<>();
        Bead currentR;
        Bead currentB;
        //배열의 내용이 . 일때는 기준으로 하기때문에 .으로 바꿔준다
        arr[r[0]][r[1]]='.';
        arr[b[0]][b[1]]='.';
        while (++answer <= 10) {
            while (!redQueue.isEmpty()) {
                currentR = redQueue.poll();
                currentB = blueQueue.poll();

                for (int i = 0; i < 4; i++) {
                    Bead nRed = move(currentR,i);

                    if (nRed==null||nRed.x < 0 || nRed.y < 0 || nRed.x >= N || nRed.y >= M) continue;
                    visited[nRed.x][ nRed.y ] = true;

                    Bead nBlue = move(currentB,i);
                    if(nBlue==null)nBlue= currentB;
                    if (arr[nRed.x][ nRed.y ]=='O'){
                        if(nRed.x==nBlue.x&&nRed.y==nBlue.y)answer =11;
                        return;
                    }

                    if(nRed.x==nBlue.x&&nRed.y==nBlue.y){
                        boolean flag;
                        if(i<2)flag = (currentR.x-currentB.x)*dx[i]>0;
                        else flag = (currentR.y-currentB.y)*dy[i]>0;

                        if(flag){
                            nRed.x-=dx[i];
                            nRed.y-=dy[i];
                        }else{
                            nBlue.x-=dx[i];
                            nBlue.y-=dy[i];
                        }
                    }
                    System.out.println(nRed);
                    System.out.println(nBlue);

                    blueQueue.offer(new Bead(nBlue.x, nBlue.y ,false));

                    list.add(new Bead(nRed.x, nRed.y ,true));
                }
            }
            if(list.isEmpty()){
                answer=11;
                return;
            }
            redQueue.addAll(list);
            list.clear();
        }
    }
    static Bead move(Bead bead,int i){
        int nx = bead.x;
        int ny = bead.y;
        if(nx < 0 || ny < 0 || nx >= N || ny >= M||arr[nx+dx[i]][ny+dy[i]]=='#'||(visited[nx+dx[i]][ny+dy[i]]&&bead.color)){
            return null;
        }
        //파란 구슬을 벽이나 구멍, 빨간구슬까지 이동시킨다, 만약 길이없으면 현재위치를 다시 큐에 넣는다
        while(arr[nx+dx[i]][ny+dy[i]]!='#'&&nx >= 0 && ny >= 0 && nx < N && ny < M){
            nx+=dx[i];
            ny+=dy[i];
            if(bead.color)visited[nx][ny]=true;
            if(arr[nx][ny]=='O') return new Bead(nx,ny,bead.color);
        }
        return  new Bead(nx,ny,bead.color);
    }

    static class Bead{
        int x;
        int y;
        boolean color;//true =red, false=blue

        public Bead(int x, int y, boolean color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        @Override
        public String toString() {
            String colorStr="";
            if(this.color)colorStr="red";
            else colorStr="blue";
            return "Bead{" +
                    "x=" + x +
                    ", y=" + y +
                    ", color=" + colorStr +
                    '}';
        }
    }

}
/* 정답
*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class net.Programmers.practice.test.HDNGB.Main1 {

    public static final int RED = 0, BLUE = 1;
    public static int N, M;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static int[] dirX = new int[] { 0, 0, 1, -1 }; // 동서남북
    public static int[] dirY = new int[] { 1, -1, 0, 0 };
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[10][10][10][10];

        Node node = new Node();
        node.cnt = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'R') {
                    node.rRow = i;
                    node.rCol = j;
                } else if (map[i][j] == 'B') {
                    node.bRow = i;
                    node.bCol = j;
                }
            }
        }
        bfs(node);
    }

    public static void bfs(Node ball) {

        Queue<Node> q = new LinkedList<Node>();
        q.offer(ball);

        while (!q.isEmpty()) {

            Node node = q.poll();
            visited[node.rRow][node.rCol][node.bRow][node.bCol] = true;

            //11번 이상 굴렸을 경우 -1을 출력한다.
            if (node.cnt >= 10) {
                System.out.println(-1);
                return;
            }

            //현재 두 구슬의 위치를 기준으로 동,서,남,북 으로 굴려본다.
            for (int dir = 0; dir < 4; dir++) {

                //파란색 구슬을 먼저 굴린다.
                int bnRow = node.bRow;
                int bnCol = node.bCol;
                while (map[bnRow + dirX[dir]][bnCol + dirY[dir]] != '#') {
                    bnRow += dirX[dir];
                    bnCol += dirY[dir];
                    if (map[bnRow][bnCol] == 'O') {
                        break;
                    }
                }

                //그 다음, 빨간색 구슬을 굴린다.
                int rnRow = node.rRow;
                int rnCol = node.rCol;
                while (map[rnRow + dirX[dir]][rnCol + dirY[dir]] != '#') {
                    rnRow += dirX[dir];
                    rnCol += dirY[dir];
                    if (map[rnRow][rnCol] == 'O') {
                        break;
                    }
                }

                //파란색 구슬이 'O'에 빠졌다면, 탐색을 멈춘다.
                if (map[bnRow][bnCol] == 'O')
                    continue;

                //빨간색 구슬만 'O'에 빠졌다면, 정답을 출력한다.
                if (map[rnRow][rnCol] == 'O') {
                    System.out.println(node.cnt + 1);
                    return;
                }

                //두 구슬의 위치가 같다면, 위치를 조정한다.
                if (rnRow == bnRow && rnCol == bnCol) {

                    switch (dir) {

                    case 0: // 동
                        if (node.rCol > node.bCol)
                            bnCol -= 1;
                        else
                            rnCol -= 1;
                        break;
                    case 1: // 서
                        if (node.rCol > node.bCol)
                            rnCol += 1;
                        else
                            bnCol += 1;
                        break;
                    case 2: // 남
                        if (node.rRow > node.bRow)
                            bnRow -= 1;
                        else
                            rnRow -= 1;
                        break;
                    case 3: // 북
                        if (node.rRow > node.bRow)
                            rnRow += 1;
                        else
                            bnRow += 1;
                        break;
                    }
                }
                //두 구슬을 굴린 후의 각각의 위치가 처음 탐색하는 것이라면 큐에 넣는다.
                if (!visited[rnRow][rnCol][bnRow][bnCol]) {
                    q.offer(new Node(rnRow, rnCol, bnRow, bnCol, node.cnt + 1));
                }
            }
        }
        System.out.println(-1);

    }

    public static void showMap(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Node {

    int rRow;
    int rCol;
    int bRow;
    int bCol;
    int cnt;

    public Node(int rRow, int rCol, int bRow, int bCol, int cnt) {
        this.rRow = rRow;
        this.rCol = rCol;
        this.bRow = bRow;
        this.bCol = bCol;
        this.cnt = cnt;
    }

    public Node() {
    }

}
* */