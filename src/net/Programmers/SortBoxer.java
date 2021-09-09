package net.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortBoxer {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = {};
        List<Boxer> list = new ArrayList<>();

        for(int i =0;i<weights.length;i++){
            Boxer boxer = new Boxer(i+1,weights[i]);
            int[] count = new int[3];//0 대전횟수, 1 이긴횟수, 2 무거운사람 이긴 횟수

            for(int j=0;j<head2head[i].length();j++){
                char c = head2head[i].charAt(j);
                if(c=='N')continue;
                count[0]++;
                if(c=='W'){
                    count[1]++;
                    if(weights[i]<weights[j])count[2]++;
                }
            }
            boxer.winRate = count[0]==0?0:(double)count[1]/(double)count[0];;
            boxer.winBigger = count[2];
            list.add(boxer);
        }
        list.sort((o1, o2) -> {
            if (o1.winRate != o2.winRate)
                return o2.winRate - o1.winRate >= 0?1:-1;
            else if (o1.winBigger != o2.winBigger)
                return o2.winBigger - o1.winBigger;
            else if (o1.weight != o2.weight)
                return o2.weight - o1.weight;
            else return o1.index - o2.index;
        });
        System.out.println(list);
        answer= new int[list.size()];
        for(int i =0; i< list.size();i++)answer[i]= list.get(i).index;
        return answer;
    }

    class Boxer {
        int index;
        int weight;
        double winRate;
        int winBigger;

        public Boxer(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Boxer{" +
                    "index=" + index +
                    ", weight=" + weight +
                    ", winRate=" + winRate +
                    ", winBigger=" + winBigger +
                    '}';
        }
    }

    public static void main(String[] args) {
        int[] weights = new int[]{60,70,60};
        String[] head2head = new String[] {"NNN","NNN","NNN"};


        System.out.println(Arrays.toString(new SortBoxer().solution(weights,head2head)));
    }
}
