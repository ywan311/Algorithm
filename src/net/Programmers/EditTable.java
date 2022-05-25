package net.Programmers;

import java.util.Stack;

/**
* 프로그래머스 표편집
https://programmers.co.kr/learn/courses/30/lessons/81303
list 로 실행시 시간초과(list 안쓰는것이 핵심)
인덱스만 가지고 있다가 마지막에 string 만들때 사용
* */

public class EditTable {
    static Stack<Integer> stack = new Stack<>();
    public String solution(int n, int k, String[] cmd) {
        int current = k;
        int tableSize = n;

        for(String command : cmd){
            if(command.startsWith("D")){
                current+=Integer.parseInt(command.split(" ")[1]);
            }else if(command.startsWith("U")){
                current-=Integer.parseInt(command.split(" ")[1]);
            }else if(command.equals("C")){
                stack.add(current);
                tableSize--;
                if(current==tableSize){
                    current--;
                }
            }else{
                int index = stack.pop();
                tableSize++;
                if(index<=current)current++;
            }
        }
        StringBuilder builder = new StringBuilder();

        builder.append("O".repeat(Math.max(0, tableSize)));
        while(!stack.isEmpty()){
            builder.insert(stack.pop(),"X");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = new String[]{"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        System.out.println(new EditTable().solution(n,k,cmd));
    }
}
