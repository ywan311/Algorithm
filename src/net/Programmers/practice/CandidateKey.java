package net.Programmers.practice;

import java.util.*;

//미완성 (18,19,20,25,28)
public class CandidateKey {
    static int answer = 0;
    static boolean check[];
    static Queue<String> queue = new LinkedList<>();
    static String[][] arr;
    public int solution(String[][] relation) {
        check = new boolean[relation[0].length];
        arr = relation;
        for(int i=1;i<=check.length;i++){
            if(answer+i>check.length)break;
                checkKey(i);
        }
        return answer;
    }
    static void checkKey(int length){
        for(int i=0;i<check.length;i++){
            if(!check[i])getList(length,"",i);
        }
        Set<String> set = new HashSet<>();
        System.out.println("queue"+queue);
        while(!queue.isEmpty()){
            String s = queue.poll();

            for(int j=0;j<arr.length;j++){
                String element="";
                for(int i=0;i<s.length();i++){
                    element+="/"+arr[j][s.charAt(i)-'0'];
                }
                set.add(element);
            }
            System.out.println(s+"set:"+set);
            if(set.size()==arr.length){
                answer++;
                for(int i=0;i<s.length();i++){
                    check[s.charAt(i)-'0']=true;
                }
            }
            set.clear();
        }
    }
    static void getList(int length,String s,int n){

        s+=n;
        if(length==s.length()){
            queue.offer(s);
            return;
        }
        for(int i=n+1;i<check.length;i++){
            if(!check[i])getList(length,s,i);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CandidateKey().solution(new String[][]{{"a","b","c","d"}
                ,{"b","b","d","a"}
                ,{"c","c","c","a"}
                ,{"d","d","b","a"}
                ,{"e","b","b","f"}
                ,{"f","c","e","z"}}));
    }
}
