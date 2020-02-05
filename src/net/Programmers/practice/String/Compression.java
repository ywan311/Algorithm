package net.Programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class Compression {
    public int[] solution(String msg) {
        ArrayList<Integer> answerList = new ArrayList<>();
        HashMap<String,Integer> dictionary = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        for (int i=0;i<msg.length();i++){
            builder.append(msg.charAt(i));
            for(int j=i+1;j<msg.length();j++){
                System.out.println(builder.toString()+"??????????????????"+j+"        "+i);
                if(dictionary.containsKey(builder.toString()+msg.charAt(j))){// 단어가 사전에 존재하는 경우
                    builder.append(msg.charAt(j));
                    if(j==msg.length()-1){//마지막까지 탐색했을경우 종료
                        int num =  getNumber(builder,dictionary);
                        answerList.add(num);
                        builder.delete(0,builder.length());
                        i=j;
                    }else continue;//아니면 계속
                }else{//단어가 사전에 없는경우
                    int num = getNumber(builder,dictionary);answerList.add(num);
                    dictionary.put(builder.toString()+msg.charAt(j),dictionary.size()+27);
                    builder.delete(0,builder.length());
                    i=j-1;
                    break;
                }
            }
            System.out.println(dictionary);
            System.out.println(builder.toString());
            System.out.println(answerList);
        }
        if(builder.length()>0){
            int num = getNumber(builder,dictionary);
            answerList.add(num);
        }
        int[] answer = new int[answerList.size()];
        for(int i=0;i<answerList.size();i++){
            answer[i] = answerList.get(i);
        }
        return answer;
    }
    int getNumber(StringBuilder builder,HashMap<String,Integer> dictionary){
        return builder.length()==1?builder.charAt(0)-'A'+1:dictionary.containsKey(builder.toString())?dictionary.get(builder.toString()):dictionary.size()+27;
    }
    public static void main (String[] args){
        System.out.println(Arrays.toString(new Compression().solution("ABABABABABABABAB")));
    }

}
