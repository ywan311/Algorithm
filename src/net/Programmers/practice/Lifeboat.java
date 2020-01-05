package net.Programmers.practice;


import java.util.Arrays;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int tmp =0;
        for(int i=0;i<people.length;i++){
            if(tmp+people[i]>=limit){
                answer++;
                continue;
            }else{
            }
        }
        return answer;
    }
    public static void main(String[] args){

    }
}
