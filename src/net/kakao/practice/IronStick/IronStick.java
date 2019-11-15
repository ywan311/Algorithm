package net.kakao.practice.IronStick;


import java.util.Scanner;
import java.util.Stack;

class IronStick {
    public int solution(String a) {
    	if(a.length()>100000) {System.out.println("입력값이 너무 많습니다.");
    		return 0;
    	}int answer = 0;
    	char array[] = a.toCharArray();//입력문을 char배열로 변환
        Stack<Boolean> stack = new Stack<>();//괄호를 계산할 스택
        for(int i=0;i<array.length;i++) {//괄호가 stick인지 raiser인지 구분
        	if(array[i]=='(') {
        		if(array[i+1]==')') {//()가 연속으로 오면 raiser
        			answer += stack.size();
        			i++;
        		}
        		else {//아니면 stick
        			stack.push(true);
        			answer++;
        		}
        	}
        	else stack.pop();//쇠막대기의 길이가 끝나는 표시가 있으면 stack에서 탈출
        }
        if(!stack.isEmpty())System.out.println("입력이 잘못되었습니다.(괄호의 쌍이 맞지않음)");
        return answer;
    }
    public static void main(String[] arg){
        IronStick sol = new IronStick();
    	Scanner scan = new Scanner(System.in);
    	String input = scan.nextLine();
    	System.out.println(sol.solution(input));
    	scan.close();

    }
}