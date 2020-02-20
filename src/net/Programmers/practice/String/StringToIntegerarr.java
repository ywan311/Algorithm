package net.Programmers.practice.String;

public class StringToIntegerarr {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);
        for (int i =1;i<arr.length;i++){
            min = Math.min(min,Integer.parseInt(arr[i]));
            max = Math.max(max,Integer.parseInt(arr[i]));
        }
        answer +=min+" "+max;
        return answer;
    }

}
