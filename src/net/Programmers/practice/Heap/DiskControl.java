package net.Programmers.practice.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskControl {
    public int solution(int[][] jobs) {
        int answer = 0;
        int current = 0;
        Arrays.sort(jobs,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) { // jobs 배열을 오름 차순으로 정렬(같은 시점일때도 오름차순)
                if(o1[0]>o2[0]) return 1;
                else if(o1[0]==o2[0]){
                    if(o1[1]>o2[1])return 1;
                    else return -1;
                }
                else return  -1;
            }
        });
        for(int[] a:jobs)System.out.println(Arrays.toString(a));

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() { // 도착시간은 무시하고 수행시간 오름차순으로 queue에 넣음
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) return 1;
                else return -1;
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            if (jobs[i][0] < current) queue.offer(jobs[i]);//disk 가 수행중일때 queue에 넣음
            else if (queue.isEmpty()) { // 큐가 비어있다면 현재 작업 수행
                current = jobs[i][0] + jobs[i][1];
                answer += current-jobs[i][0];
                continue;
            }
            else { //jobs 배열을 모두 탐색하기전에 수행이 끝나면 queue 에서 꺼내 작업 수행
                int[] schedule = queue.poll();
                current += schedule[1];
                answer += (current - schedule[0]);
                i--;
            }
        }
        System.out.println("------------------------");
        while(!queue.isEmpty()){ // jobs를 모두 탐색하고 queue에 작업이 남아있다면 모두 수행
            int[] schedule = queue.poll();
            System.out.println(Arrays.toString(schedule));
            current += schedule[1];
            answer += (current - schedule[0]);
        }
        return answer/jobs.length;
    }


    public static void main(String[] args) {
        System.out.println(new DiskControl().solution(new int[][]{{0,9},{0,4},{0,5},{0,7},{0,3}}));
    }
}
