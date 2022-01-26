package net.Programmers;

import java.util.*;

public class Distance {
    char[][] charArr = new char[5][5];
    boolean[][] checkArr = new boolean[5][5];
    List<int[]> persons = new ArrayList<>();

    final int[] dx = new int[]{0,1,0,-1};
    final int[] dy = new int[]{1,0,-1,0};

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
            answer[answerIndex++] = isValid();
            persons.clear();
        }
        return answer;
    }

    //BFS
    private int isValid() {
        Queue<int[]> queue = new LinkedList<>();

        for(int[] start : persons){
            queue.offer(start);
            checkArr = new boolean[5][5];
            List<int[]> tmpList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                while(!queue.isEmpty()){
                    int[] current = queue.poll();
                    for(int j=0;j<4;j++){

                        checkArr[current[0]][current[1]] = true;

                        int nx = current[0]+dx[j];
                        int ny = current[1]+dy[j];

                        if(nx <0 || nx >= 5 || ny < 0 || ny >= 5){
                            continue;
                        }

                        if(checkArr[nx][ny]){
                            continue;
                        }

                        if(charArr[nx][ny]=='X'){
                            continue;
                        }

                        if(charArr[nx][ny]=='P'){
                            return 0;
                        }
                        tmpList.add(new int[]{nx,ny});
                    }
                }
                queue.addAll(tmpList);
                tmpList.clear();
            }
            queue.clear();
        }
        return 1;
    }

    public static void main(String[] args) {
        String[][] input = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(new Distance().solution(input)));
    }
}
