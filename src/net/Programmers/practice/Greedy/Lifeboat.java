package net.Programmers.practice.Greedy;


import java.util.Arrays;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j=0;
        for(int i=people.length-1;i>=0;i--){
            int a;
            if(people[i]==-1)break;
            a = people[i];
            people[i]=-1;
            answer++;
            while(j<i){
                if(people[j]==-1)continue;
                if(a+people[j]<=limit){
                    a+=people[j];
                    people[j]= -1;
                    j++;
                }else break;
            }
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new Lifeboat().solution(new int[]{70,80,50}, 100));
    }
}
