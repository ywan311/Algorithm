package net.Programmers.practice.Math;

public class NGame {
    public String solution(int n, int t, int m, int p) {
        /**
         * class Solution {
         *   static char[] numeralSystem = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
         *   public String solution(int n, int t, int m, int p) {
         *       String answer = "";
         *       char[] sequence = new char[t * m];
         *       Stack<Character> stack = new Stack<>();
         *       int count = 0;
         *         int number = 0, temp = number;
         *         int limit = m * t;
         *
         *         while(count < limit) {
         *             if(temp < n) {
         *                 sequence[count++] = numeralSystem[temp];
         *                 while(!stack.isEmpty() && count < limit) {
         *                     sequence[count++] = stack.pop();
         *                 }
         *                 temp = ++number;
         *             }else {
         *                 stack.push(numeralSystem[temp % n]);
         *                 temp /= n;
         *             }
         *         }
         *         StringBuilder sb = new StringBuilder();
         *         for(int i = p - 1; i < sequence.length; i+=m) {
         *             sb.append(sequence[i]);
         *         }
         *       return answer = sb.toString();
         *   }
         */

        StringBuffer answer = new StringBuffer();
        int i=1;
        answer.append(0);
        while(answer.length()<t*m){
            int tmp=i;
            StringBuffer buffer = new StringBuffer();
            while(tmp>0){
                if(tmp%n>=10){
                    switch (tmp%n){
                        case 10:
                            buffer.insert(0,'A');
                            break;
                        case 11:
                            buffer.insert(0,'B');
                            break;
                        case 12:
                            buffer.insert(0,'C');
                            break;
                        case 13:
                            buffer.insert(0,'D');
                            break;
                        case 14:
                            buffer.insert(0,'E');
                            break;
                        case 15:
                            buffer.insert(0,'F');
                            break;
                    }
                }else buffer.insert(0,tmp%n);
                tmp/=n;
            }
            answer.append(buffer);
            i++;
        }
        StringBuffer result = new StringBuffer();
        char[] arr = answer.toString().toCharArray();
        for(int j=p-1;result.length()<t;j+=m){
            result.append(arr[j]);
        }
        return result.toString();
    }
    public static void main(String[] args){
        System.out.println(new NGame().solution(16,30,2,1));
    }
}
