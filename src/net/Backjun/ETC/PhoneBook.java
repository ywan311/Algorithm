package net.Backjun.ETC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PhoneBook {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-->0){

        }

    }
    public boolean solution(String[] phone_book) {
        boolean answer =true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++ ){
            if(phone_book[i+1].startsWith(phone_book[i]))
            {answer= false; break;}
        }
        return answer;
    }
}