package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;

public class P1213 {
    static TreeMap<Character,Integer> map = new TreeMap<>((o1, o2) -> o2-o1);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for(char c : input.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder answer = new StringBuilder();
        Character odd = getOddCharacter();
        if(odd=='1'){
            System.out.println("I'm Sorry Hansoo");
        }else{
            if(odd!='0'){
                answer.append(odd);
                map.put(odd,map.get(odd)-1);
            }
            for(Character c : map.keySet()){
                for(int i =0;i<map.get(c);i+=2){
                    answer.insert(0,c);
                    answer.append(c);
                }
            }
        }
        System.out.println(answer.toString());

    }
    //홀수개수가 두개이상이면 펠린드롬 불가
    static Character getOddCharacter(){
        Character existOdd = '0';
        for(Character c : map.keySet()){
            if(map.get(c)%2==1){
                if(existOdd=='0'){
                    existOdd=c;
                }else{
                    return '1';
                }
            }
        }
        return existOdd;
    }
}
