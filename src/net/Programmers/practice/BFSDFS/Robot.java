package net.Programmers.practice.BFSDFS;

import java.util.*;

//미완성
public class Robot {
    static int[][] arr;
    static boolean[][] visited;
    static boolean[][] visitedS;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    static int answer=0;


    public int solution(int[][] board) {
        arr =board;
        visited = new boolean[board.length][board[0].length];
        visitedS = new boolean[board.length][board[0].length];
        Position start = new Position(0,0,0,1);
        BFS(start);
        return answer;
    }
    public void BFS(Position start){
        Queue<Position> queue= new LinkedList<>();
        List<Position> next = new ArrayList<>();


        queue.offer(start);
        visited[start.x1][start.y1]=visited[start.x2][start.y2]=true;
        visitedS[start.x1][start.y1]=visitedS[start.x2][start.y2]=true;
        Position current;
        while(true){
            while(!queue.isEmpty()){
                current = queue.poll();

                //이동
                for(int i=0;i<4;i++){
                    int nx1 = current.x1+dx[i];
                    int nx2 = current.x2+dx[i];
                    int ny1 = current.y1+dy[i];
                    int ny2 = current.y2+dy[i];

                    if(nx2==arr.length&&ny2==arr.length){
                        answer++;
                        return;
                    }
                    if(nx1<0||nx2<0||ny1<0||ny2<0||nx1>=arr.length||nx2>=arr.length||ny1>=arr[0].length||ny2>=arr[0].length)continue;//범위밖으로 이동
                    if(arr[nx1][ny1]==1||arr[nx2][ny2]==1)continue;//벽으로이동
                    if(visited[nx1][ny1]&&visited[nx2][ny2])continue;//갔던곳 이동

                    visited[nx1][ny1]=visited[nx2][ny2]=true;
                    next.add(new Position(nx1,ny1,nx2,ny2));
                }
                //회전
                next.addAll(Spin(current));
                System.out.println(current+" current");
            }
            System.out.println(next);
            if(next.isEmpty())break;
            answer++;
            queue.addAll(next);
            next.clear();

        }
    }
    public List<Position> Spin(Position start){
        List<Position> next = new ArrayList<>();
        next.clear();
        int[] tmpx = new int[]{1,-1};
        int[] tmpy = new int[]{1,-1};
        System.out.println("spin"+start);
        if(start.x1==start.x2){//가로
            for(int i=0;i<2;i++){
                int nx1 = start.x1+tmpx[i];
                int ny1 = start.y1+tmpy[0];

                int nx2 = start.x2+tmpx[i];
                int ny2 = start.y2+tmpy[1];

                System.out.println(nx1+"/"+ny1+"    ,"+nx2+"/"+ny2);

                if(nx1<0||nx2<0||ny1<0||ny2<0||nx1>=arr.length||nx2>=arr.length||ny1>=arr[0].length||ny2>=arr[0].length)continue;//범위밖으로 이동
                if(arr[nx1][ny1]==1||arr[nx2][ny2]==1)continue;
                if(visitedS[nx1][ny1]||visitedS[nx2][ny2])continue;//갔던곳 이동

                next.add(new Position(nx1,ny1,start.x2,start.y2));
                next.add(new Position(start.x1,start.y1,nx2,ny2));
                visitedS[nx1][ny1]=visitedS[nx2][ny2]=true;
            }
            System.out.println("가로"+next);
            return next;
        }else{//세로
            for(int i=0;i<2;i++){
                int nx1 = start.x1+tmpx[0];
                int ny1 = start.y1+tmpy[i];

                int nx2 = start.x2+tmpx[1];
                int ny2 = start.y2+tmpy[i];

                if(nx1<0||nx2<0||ny1<0||ny2<0||nx1>=arr.length||nx2>=arr.length||ny1>=arr[0].length||ny2>=arr[0].length)continue;//범위밖으로 이동
                if(arr[nx1][ny1]==1||arr[nx2][ny2]==1)continue;
                if(visitedS[nx1][ny1]||visitedS[nx2][ny2])continue;//갔던곳 이동

                next.add(new Position(nx1,ny1,start.x2,start.y2));
                next.add(new Position(start.x1,start.y1,nx2,ny2));
                visitedS[nx1][ny1]=visitedS[nx2][ny2]=true;
            }
            System.out.println("세로"+next);
            return next;

        }
    }

    private class Position{
        int x1;
        int y1;
        int x2;
        int y2;
        public Position(int x1, int y1, int x2, int y2) {
            this.x1 = Math.min(x1,x2);
            this.y1 = Math.min(y1,y2);
            this.x2 = Math.max(x1,x2);
            this.y2 = Math.max(y1,y2);
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }
    }


    public static void main(String[] args) {
        System.out.println(new Robot().solution(new int[][]{{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}));
    }
}
