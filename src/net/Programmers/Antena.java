package net.Programmers;

import java.util.ArrayList;
import java.util.List;

//기지국 설치
//https://programmers.co.kr/learn/courses/30/lessons/12979
public class Antena {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        if(stations.length==1){
            answer+=((stations[0]-w-1)+2*w)/(2*w+1);
            answer+=((n-stations[0]-w)+2*w)/(2*w+1);
        }else{
            for(int i=0;i<stations.length-1;i++){
                if(i==0 && stations[i]!=1 && (stations[i]-w-1)>0){
                    answer+=((stations[i]-w-1)+2*w)/(2*w+1);
                }else if(i==stations.length-2&&n!=stations[i+1] && (n-stations[i+1]-w)>0){
                    answer+=((n-stations[i+1]-w)+2*w)/(2*w+1);
                }
                if(stations[i+1]-stations[i]>2*w+1){
                    answer+=((stations[i+1]-stations[i]-2*w-1)+2*w)/(2*w+1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Antena().solution(10,new int[]{3,8},2));
    }
}
