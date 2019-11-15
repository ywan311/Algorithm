package net.Programmers.practice;

import java.util.Arrays;

public class GiveUpMath {
    public int[] solution(int[] answers) {
        int[] cnt = new int[3];

        for(int i =0; i<answers.length;i++){
            if(answers[i]==i%5 +1)cnt[0]++;

            if(i%2==0&&answers[i]==2)cnt[1]++;
            else if(i%2!=0&&answers[i]==(i/2)%5+1)cnt[1]++;

            if((i/2)%5==0&&answers[i]==3)cnt[2]++;
            else if((i/2)%5==1&&answers[i]==1)cnt[2]++;
            else if((i/2)%5==2&&answers[i]==2)cnt[2]++;
            else if((i/2)%5==3&&answers[i]==4)cnt[2]++;
            else if((i/2)%5==4&&answers[i]==5)cnt[2]++;
        }
        if(cnt[0]>cnt[1]){
            if(cnt[0]>cnt[2]){
                return new int[] {1};
            }else if(cnt[0]==cnt[2]){
                return new int [] {1,3};
            }else{
                return new int[] {3};
            }
        }else if(cnt[0]==cnt[1]){
            if(cnt[0]>cnt[2]){
                return new int[] {1,2};
            }else if(cnt[0]==cnt[2]){
                return new int [] {1,2,3};
            }else{
                return new int[] {3};
            }
        }else{
            if(cnt[1]>cnt[2]){
                return new int[] {2};
            }else if(cnt[1]==cnt[2]){
                return new int [] {2,3};
            }else{
                return new int[] {3};
            }
        }
    }
    public static void main(String[] args){
        GiveUpMath g = new GiveUpMath();
        System.out.println(Arrays.toString(g.solution(new int[]{4,4,4,5,1})));
    }
}
