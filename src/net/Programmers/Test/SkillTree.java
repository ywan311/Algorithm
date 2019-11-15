package net.Programmers.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SkillTree {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> arrayList = new ArrayList<>();
        for(char c : skill.toCharArray()){
            arrayList.add(c);
        }
        for (String s: skill_trees){
            char[] tmp = s.toCharArray();
            answer++;
            ArrayList<Character> tmpList = new ArrayList<>();
            tmpList.addAll(arrayList);
            for(char c : tmp){
                if(tmpList.contains(c)){
                    if(tmpList.get(0)!=c){
                        answer--;
                        break;
                    }
                    else tmpList.remove(0);
                }
            }
        }
        return answer;
      /*
        replaceAll("a","b")-> a를 모두 b로 바꿈(a는 정규식)
        "[^"+skill+"]" -> skill에 포함된 문자를 제외한 모든 문자
        indexOf -> 문자의 인덱스 출력
        결과가 조건에 맞을 경우 (스킬을 순서대로 배운경우) -> 0


        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;*/
    }
    public static void main(String[] args){
        System.out.println(
                new SkillTree().solution("CBD",new String[] {"BACDE","CBADF","AECB","BDA"}));
    }
}
