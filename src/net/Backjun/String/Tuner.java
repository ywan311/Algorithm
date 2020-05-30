package net.Backjun.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tuner {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<String> input = new LinkedList<>();
        Queue<String> output = new LinkedList<>();
        for(int i=0;i<n;i++)input.add(br.readLine());
        for(int i=0;i<n;i++)output.add(br.readLine());


        int answer=0;
        while(!output.isEmpty()){
            String current = output.poll();

            if(!input.peekFirst().equals(current))answer++;
            input.remove(current);
        }
        System.out.println(answer);
    }
}
