package net.Programmers;

import java.util.*;

public class Distance {
    char[][] charArr = new char[5][5];
    Set<int[]> persons = new HashSet<>();

    final int[] dx = new int[]{0,1,0,-1};
    final int[] dy = new int[]{1,0,-1,-1};

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int answerIndex =0;
        for (String[] s :places){
            for(int i =0;i<5;i++){
                char[] arr = s[i].toCharArray();
                for(int j =0;j<5;j++){
                    charArr[i][j] = arr[j];
                    if(arr[j]=='P'){
                        persons.add(new int[]{i,j});
                    }
                }
            }

            answer[answerIndex] = isValid();
            persons.clear();
        }
        return answer;
    }

    private int isValid() {
        Queue<int[]> queue = new LinkedList<>();
        for(int[] start : persons){
            queue.offer(start);
            for(int i =0;i<3;i++){
                while(!queue.isEmpty()){

                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(new Distance().solution(input)));
    }
}
