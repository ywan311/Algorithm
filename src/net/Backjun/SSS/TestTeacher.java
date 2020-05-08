package net.Backjun.SSS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TestTeacher {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int room = Integer.parseInt(br.readLine());
        String[] people = br.readLine().split(" ");
        int[] peopleInt = new int[people.length];

        String[] values = br.readLine().split(" ");
        int main = Integer.parseInt(values[0]);
        int sub = Integer.parseInt(values[1]);
        int answer = room;
        for(int i=0;i<people.length;i++){
            peopleInt[i] = Integer.parseInt(people[i])-main;
        }
        System.out.println(Arrays.toString(peopleInt));
        for(int a: peopleInt){
            if(a>0)answer+=(a-1)/sub+1;
        }
        System.out.println(answer);

    }
}
