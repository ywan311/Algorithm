package net.Backjun.String;

import java.util.Scanner;

public class SearchWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String doc = input.nextLine();
        String s = input.nextLine();
        int answer=0;
        for(int i=0;i+s.length()<=doc.length();i++){
            System.out.println(doc.substring(i,i+s.length()));
            if(doc.substring(i,i+s.length()).equals(s)){
                answer++;
                i+=s.length()-1;
            }
        }
        System.out.println(answer);
    }
}
