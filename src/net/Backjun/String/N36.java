package net.Backjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;

public class N36 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer>[] queue = (PriorityQueue<Integer>[]) new PriorityQueue[51];
        for(int i=0;i< queue.length;i++)queue[i]=new PriorityQueue<>((o1, o2) -> o1-o2);

        int n = Integer.parseInt(br.readLine());
        int bigIndex=0;
        for(int i=0;i<n;i++){
            char[] input = br.readLine().toCharArray();
            for(int j =input.length-1;j>=0;j--){
                queue[input.length-j-1].offer(getInt(input[j]));
                bigIndex = Math.max(bigIndex,j);
            }
        }
        int k = Integer.parseInt(br.readLine());
        int sum=0;
        for(int i=bigIndex;i>=0;i--){
            while(!queue[i].isEmpty()){
                int tmp;
                if(k>0&&queue[i].peek()<35){
                    k--;
                    tmp=35;
                    queue[i].poll();
                }
                else tmp=queue[i].poll();
                sum+=tmp*(int)Math.pow(36,i);
            }
        }
        System.out.println(getString(sum));
    }
    static int getInt(char s){
            if(s>='0'&&s<='9')return s-'0';
            else return s-'A'+10;
    }
    static String getString(int value){
        String answer="";
        while(value>0){
            int tmp = value%36;
            System.out.println(tmp);
            System.out.println(value/36);
            if(tmp<10)answer = tmp+answer;
            else answer = (char)(tmp-10+'A')+answer;
            System.out.println("answer"+answer);
            value/=36;
        }
        return answer;
    }
}
