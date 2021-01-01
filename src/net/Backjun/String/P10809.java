package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] answer = new int['z'-'a'+1];
        Arrays.fill(answer,-1);
        char[] charArr = br.readLine().toCharArray();
        for(int i =0;i<charArr.length;i++){
            if(answer[charArr[i]-'a']==-1){
                answer[charArr[i]-'a']=i;
            }
        }
        for(int i: answer) System.out.print(i+" ");
    }
}
