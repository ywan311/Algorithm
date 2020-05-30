package net.Backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Wedding {
    static ArrayList<Integer>[] list;
    static boolean check[];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        list = (ArrayList<Integer>[]) new ArrayList[n+1];
        check = new boolean[n+1];
        for(int i=1;i<list.length;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            String str[] = br.readLine().split(" ");
            list[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
            list[Integer.parseInt(str[1])].add(Integer.parseInt(str[0]));
        }
        checkFriends(1);
        for(int i:list[1])checkFriends(i);
        int answer=0;
        for(int i=2;i<check.length;i++)answer += check[i]?1:0;
        System.out.println(answer);

    }
    static void checkFriends(int index){
        for(int a: list[index]){
            check[a]=true;
        }
    }
}
