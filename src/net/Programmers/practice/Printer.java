package net.Programmers.practice;

import java.util.LinkedList;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<Node> list = new LinkedList<>();
        for(int i=0;i<priorities.length;i++){
            list.addLast(new Node(i,priorities[i]));
        }
        LinkedList<Node> result = new LinkedList<>();
        while(!list.isEmpty()){
            if(result.isEmpty())result.add(list.pollFirst());
            else{
                if(list.peekFirst().pri>result.peekLast().pri){
                    while(!result.isEmpty())list.add(result.pollFirst());
                }
                else result.add(list.pollFirst());
            }
        }
        for(int i=0;!result.isEmpty();i++){
            int tmp = result.poll().idx;
            if(tmp==location)answer = i+1;
        }
        return answer;
    }
    public class Node{
        int idx;
        int pri;
        public Node(int idx, int pri) {
            this.idx = idx;
            this.pri = pri;
        }
    }
    public static void main(String[] args){
        System.out.println(new Printer().solution(new int[] {1, 1, 9, 1, 1, 1},0));
    }
}
