package net.Backjun.String;

import java.util.PriorityQueue;
import java.util.Scanner;

public class TailArr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        PriorityQueue<String> queue = new PriorityQueue<>((o1, o2) -> o1.charAt(0)-o2.charAt(0));
        for(int i=0;i<str.length()-1;i++){
            queue.add(str.substring(i));
        }
        while(!queue.isEmpty())System.out.println(queue.poll());
    }
}
