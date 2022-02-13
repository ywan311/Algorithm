package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1043 {

    static int N;
    static int M;
    static boolean[] truePeople ;
    static int trueCount;
    static List<List<Integer>> partyList = new ArrayList<>();
    static int answer;
    static Set<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);
        answer = M;
        graph=(Set<Integer>[])new HashSet[N+1];
        truePeople = new boolean[N+1];

        for(int i =1;i<N+1;i++){
            graph[i] = new HashSet<>();
        }

        String[] trueList = br.readLine().split(" ");

        trueCount = Integer.parseInt(trueList[0]);

        for(int i =0;i<trueCount;i++){
            truePeople[Integer.parseInt(trueList[i+1])]=true;
        }


        for(int i =0;i<M;i++){
            String[] partyStr = br.readLine().split(" ");
            List<Integer> party = new ArrayList<>();
            for (int j =0;j<Integer.parseInt(partyStr[0]);j++){
                party.add(Integer.parseInt(partyStr[j+1]));
            }
            System.out.println(party);
            partyList.add(party);
        }

        //그래프로 연결할 수 있으면 연결
        for (List<Integer> integers : partyList) {
            if (integers.size() > 1) {
                makeGraph(integers);
            }
        }

        if(trueCount==0){
            System.out.println(M);
            return;
        }
        //진실을 알고있는 사람 전체 DFS 로 추가
        for (int i = 0; i < truePeople.length; i++) {
            if(truePeople[i]){
                getTruePeople(i,i,new boolean[N+1]);
            }
        }

        //진실을 알고있는 사람이 포함된 파티면 거짓말 못함
        for(List<Integer> party: partyList){
            if(party.stream().anyMatch(o -> truePeople[o])){
                answer--;
            }
        }
        System.out.println(answer);
    }
    //그래프 그리기
    static void makeGraph(List<Integer> list){
        for(int i =0;i<list.size()-1;i++){
            for(int j =i+1;j<list.size();j++){
                graph[list.get(i)].add(list.get(j));
                graph[list.get(j)].add(list.get(i));
            }
        }
    }
    //DFS
    static void getTruePeople(int index,int current,boolean[] visited){
        visited[index]=true;
        visited[current]=true;

        for(int i : graph[current]){
            if(visited[i] || i==index){
                continue;
            }
            visited[i]=true;
            truePeople[i]=true;
            getTruePeople(index,i,visited);
        }
    }
}
