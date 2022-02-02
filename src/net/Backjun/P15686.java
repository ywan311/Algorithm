package net.Backjun;

import java.io.*;
import java.util.*;

//치킨 배달
public class P15686 {
    static int size;
    static int M;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputSize = br.readLine().split(" ");
        size = Integer.parseInt(inputSize[0]);
        M = Integer.parseInt(inputSize[1]);


        //집 , 치킨집 포지션 저장
        for (int i = 0; i < size; i++) {
            String[] inputArr = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                if (Integer.parseInt(inputArr[j]) == 1) {
                    house.add(new int[]{i, j});
                }
                if (Integer.parseInt(inputArr[j]) == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        }

        for(int i =0;i< chickens.size();i++){
            solution(i,new HashSet<>(),new boolean[chickens.size()]);
        }

        System.out.println(answer);
    }

    static void solution(int start,Set<Integer> set,boolean[] visited) {
        //치킨집 개수가 차면 거리구하기
        if(set.size()==M){
            int sum =0;
            for(int[] element : house){
                int min = Integer.MAX_VALUE;
                for(int i : set){
                    min = Math.min(min,Math.abs(element[0]-chickens.get(i)[0])+Math.abs(element[1]-chickens.get(i)[1]));
                }
                sum +=min;
            }
            answer = Math.min(answer,sum);
        }

        //조합 구하기
        for(int i =start;i< chickens.size();i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            Set<Integer> input = new HashSet<>(set);
            input.add(i);
            solution(i,input,visited);
            visited[i] = false;
        }
    }
}
