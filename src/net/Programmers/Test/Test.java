package net.Programmers.Test;

import java.util.Arrays;

public class Test {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean cntReserve[] = new boolean[n];
        boolean cntLost[] = new boolean[n];
        Arrays.fill(cntReserve, false);
        Arrays.fill(cntLost, false);

        answer = n - lost.length;
        for (int i = 0; i < reserve.length; i++) {
            cntReserve[reserve[i]-1] = true;
            System.out.println(i+"     "+reserve[i]);
        }
        for (int i = 0; i < lost.length; i++) {
            if (!cntReserve[i])
                cntLost[lost[i]-1] = true;
        }
        for(int i =0; i<cntLost.length;i++){
            if(cntLost[i]){
                System.out.println(i);
                if(i==0&&cntReserve[i+1]){
                    cntReserve[i+1]=false;
                    answer++;
                    System.out.println("if(i<=0){"+i);
                }else if(i==n&&cntReserve[i-1]){
                    cntReserve[i-1]=false;
                    answer++;
                    System.out.println("if(i<=29){"+i);
                }else{
                    if(cntReserve[i-1]){
                        cntReserve[i-1]=false;
                        answer++;

                        System.out.println("i if(cntReserve[i-1]){"+i);
                    }else if(cntReserve[i+1]){
                        cntReserve[i-1]=false;
                        answer++;
                        System.out.println("i if(cntReserve[i+1]){"+i);
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Test t = new Test();
        int[] l = {2,4};
        int[] r = {1,3,5};
        System.out.println(t.solution(5, l, r));

    }
}

