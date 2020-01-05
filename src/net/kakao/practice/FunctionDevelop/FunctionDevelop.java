package net.kakao.practice.FunctionDevelop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList();
        int tmp = 0;
        int cnt =0;
        for(int i=0;i<progresses.length;i++){
            int day =(int)Math.ceil((double) (100-progresses[i])/(double)speeds[i]);
            if(i==0){
                tmp=day;
                cnt++;
            }else if(tmp>=day){
                cnt++;
            }else{
                list.add(cnt);
                cnt=1;
                tmp=day;
            }
            if(progresses.length-1==i)list.add(cnt);
        }
        answer = new int[list.size()];
        for(int i=0;i< list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main (String[] args){
        int[] a = {93,30,55,30,30,55};
        int[] b = {1,30,5,30,30,5};

        FunctionDevelop f = new FunctionDevelop();
        System.out.println(Arrays.toString(f.solution(a,b)));
    }
}
