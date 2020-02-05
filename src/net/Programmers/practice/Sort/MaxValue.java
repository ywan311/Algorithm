package net.Programmers.practice.Sort;


import java.util.Stack;

public class MaxValue {
    public String solution(String number, int k) {
        /*StringBuilder answer = new StringBuilder();
        int len=k;
        if(number.length()==k)return "0";
        boolean flag =true;
        for(int i=0;i<number.length()&&k>0;i++){
            //i는 탐색하는 인덱스
            int tmp = number.charAt(i)-'0';
            for(int j=1;j<=k&&j+i<number.length();j++){
                if(tmp<number.charAt(i+j)-'0'){
                    flag=false;
                    k--;
                    break;
                }
            }
            if(flag){
                answer.append(number.charAt(i));
            }
            else flag=true;
            if(k==0)answer.append(number.substring(i+1));
        }
        if(number.length()-len<answer.toString().length())return answer.toString().substring(0,number.length()-len);
        else return answer.toString();*/
         char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
    public static void main(String args[]){
        MaxValue m = new MaxValue();
        System.out.println(m.solution("1924",2));
    }
}
