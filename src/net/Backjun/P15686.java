package net.Backjun;

import java.io.*;
import java.util.*;

public class P15686 {
    static int size;
    static int M;
    static List<int[]> chickens = new ArrayList<>();
    static List<int[]> house = new ArrayList<>();
    static Set<Set<Integer>> combination = new HashSet<>();

    static boolean[] visited ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputSize = br.readLine().split(" ");
        size = Integer.parseInt(inputSize[0]);
        M = Integer.parseInt(inputSize[1]);


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
        visited = new boolean[chickens.size()];

        for (int i = 0; i < chickens.size(); i++) {
            getCombination(i, new HashSet<>());
        }
        System.out.println(combination);
//        int answer = 0;
//        do{
//            int min = Integer.MAX_VALUE;
//            int index = -1;
//            for(int i =0;i<chickens.size();i++){
//                int sum = 0;
//                for(int[] a : house){
//                    int minDistance = Integer.MAX_VALUE;
//                    for(int j =0;j < chickens.size();j++){
//                        if(i==j)continue;
//                        minDistance = Math.min(minDistance,Math.abs(a[0]-chickens.get(j)[0])+Math.abs(a[1]-chickens.get(j)[1]));
//                    }
//                    sum += minDistance;
//                }
//                if(min>sum){
//                    min=sum;
//                    index = i;
//                }
//            }
//            answer = min;
//
//            System.out.println(Arrays.toString(chickens.get(index)));
//            System.out.println(index+"="+answer);
//            chickens.remove(index);
//        }while(M<chickens.size());
//
//        System.out.println(answer);
    }

    static void getCombination(int start, Set<Integer> set) {
        if(visited[start])return ;
        set.add(start);
        System.out.println(set);
        if (set.size() == M) {
            combination.add(set);
            return;
        }
        for (int i = start; i < M; i++) {
            visited[i] = true;
            getCombination(i, set);
            visited[i] = false;
        }
    }
}
