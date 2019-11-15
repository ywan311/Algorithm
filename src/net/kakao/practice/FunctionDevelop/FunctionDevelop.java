package net.kakao.practice.FunctionDevelop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class FunctionDevelop {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> arrayList = new ArrayList<>();
        int tmp;
        int a =0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<progresses.length;i++){
            tmp=(100-progresses[i])/speeds[i];
            System.out.println(tmp);
            if(a==0){
                a =tmp;
                if(!stack.isEmpty()){
                    arrayList.add(stack.size());
                    while(!stack.isEmpty())stack.pop();
                }
                stack.push(tmp);
            }else if(a<tmp){
                a=tmp;
                arrayList.add(stack.size());
                while(!stack.isEmpty())stack.pop();
                stack.push(tmp);
            }else{
                stack.push(tmp);
            }
        }
        if(!stack.isEmpty()) arrayList.add(stack.size());
        answer = new int[arrayList.size()];
        for (int i=0;i<arrayList.size();i++){
            answer[i] = arrayList.get(i);
        }
        return answer;
     /*   int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }*/
    }
    public static void main (String[] args){
        int[] a = {93,30,55};
        int[] b = {1,6,5};

        FunctionDevelop f = new FunctionDevelop();
        System.out.println(Arrays.toString(f.solution(a,b)));
    }
}
