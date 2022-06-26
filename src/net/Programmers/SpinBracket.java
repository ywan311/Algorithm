package net.Programmers;

import java.util.Stack;

public class SpinBracket {
    public int solution(String s) {
        int answer = 0;
        int N = s.length();

        do{
            answer += isValid(s)?1:0;
            s+=s.charAt(0);
            s= s.substring(1);
        }while(N-->1);

        return answer;
    }
    boolean isValid(String input){
        Stack<Character> stack = new Stack<>();
        for(char c : input.toCharArray()){
            if(c=='[' || c=='{' || c=='('){
                stack.push(c);
            }else{
                if(stack.isEmpty())return false;
                else if((c==']' && stack.peek()=='[')||(c=='}' && stack.peek()=='{')||(c==')' && stack.peek()=='(')){
                    stack.pop();
                }else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new SpinBracket().solution("}]()[{"));
    }
}
