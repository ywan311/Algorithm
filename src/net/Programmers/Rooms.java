package net.Programmers;

import java.util.*;

public class Rooms {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
       Set<Long> set = new TreeSet<>();
       for(long i=1;i<k;i++)set.add(i);
       for (int i = 0; i < room_number.length; i++) {
            long value = room_number[i];
            if(!set.contains(value)){
                Iterator<Long> iterator = set.iterator();
               while(iterator.hasNext()){
                   long tmp = iterator.next();
                   if(tmp>value){
                       value = tmp;
                       break;
                   }
               }
            }
            set.remove(value);
            answer[i] = value;
        }

        return answer;
    }

    public static void main(String[] args) {
        long[] input = new long[200000];
        long max=0;
        for(int i=0;i< 200000;i++){
            input[i] = i>100000?i-100000:i;
        }
        System.out.println(Arrays.toString(new Rooms().solution(max,input)));
    }
}
