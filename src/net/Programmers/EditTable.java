package net.Programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//프로그래머스 표편집
public class EditTable {
    static List<String> list = new ArrayList<>();
    static Stack<String> stack = new Stack<>();
    static Stack<Integer> indexStack = new Stack<>();
    public String solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        for(int i =0;i<n;i++){
            list.add(String.valueOf(i));
        }
        int current = k;

        for(String command : cmd){
            if(command.startsWith("D")){
                current+=Integer.parseInt(command.split(" ")[1]);
            }else if(command.startsWith("U")){
                current-=Integer.parseInt(command.split(" ")[1]);
            }else if(command.equals("C")){
                String s = list.get(current);
                stack.add(s);
                indexStack.add(current);
                list.remove(s);
                if(current>=list.size()){
                    current--;
                }
            }else{
                String s = stack.pop();
                int index = indexStack.pop();
                list.add(index,s);
                if(index<current)current++;
            }
        }
        int index=0;
        for(int i =0;i<n;i++){
            if(Integer.parseInt(list.get(index))==i){
                answer.append("O");
                index++;
            }else{
                answer.append("X");
            }
        }

        return answer.toString();
    }
}
