package net.Programmers.practice.BFSDFS;

public class Network {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[computers.length];
        for(int i=0;i<computers.length;i++){
            answer+=DFS(computers,i);
        }
        return answer;
    }
    public static int DFS(int[][] computers,int index){
        if(visited[index])return 0;
        visited[index]=true;
        for(int i=0;i<visited.length;i++){
            if(index!=i&&computers[index][i]==1){
                DFS(computers, i);
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Network().solution(4,new int[][]{{1,1,0,0},{1,1,1,0},{0,1,1,1},{0,0,1,1}}));
    }
}
