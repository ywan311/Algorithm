package net.Backjun.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class SurprisingWord {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        Set<String > set = new HashSet<>();
        while(!((input = br.readLine()).equals("*"))){
            set.clear();
            if(input.length()<2){
                continue;
            }else{
                boolean flag =true;
                for(int i=1;i<(input.length()-1)&&flag;i++){
                    set.clear();
                    for(int j=0;j+i<input.length();j++){
                        StringBuilder s = new StringBuilder();
                        s.append(input.charAt(j));
                        s.append(input.charAt(i+j));
                        if(set.isEmpty()||!set.contains(s.toString()))set.add(s.toString());
                        else{
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag)
                    System.out.println(input+" is surprising.");
                else
                    System.out.println(input+" NOT is surprising.");
            }
        }
    }
}
