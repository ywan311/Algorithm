package net.Programmers;

import java.util.ArrayList;
import java.util.List;

public class Key {
    static List<int[]> keyList = new ArrayList<>();

    final int[] dx = new int[]{1, 1, -1, -1};
    final int[] dy = new int[]{1, -1, 1, -1};

    public boolean solution(int[][] key, int[][] lock) {
        int blank = 0;

        //key의 돌기 체크
        for (int i = 0; i < key.length; i++) {
            for (int j = 0; j < key[0].length; j++) {
                if (key[i][j] == 1) {
                    keyList.add(new int[]{i, j});
                }
            }
        }
        //lock의 홈 체크
        for (int[] ints : lock) {
            for (int j = 0; j < lock[0].length; j++) {
                if (ints[j] == 0) blank++;
            }
        }

        //lock의 홈개수보다 key의 돌기가 더 적으면 절대 풀리지 않음
        if (blank > keyList.size()) return false;


        //key 회전 4번
        for (int i = 0; i < 4; i++) {
            if (i > 0) {
                ArrayList<int[]> tmpList = new ArrayList<>();
                for (int[] a : keyList) {
                    tmpList.add(new int[]{a[1], key.length - a[0]});
                }
                keyList.clear();
                keyList.addAll(tmpList);
            }
            //key의 이동방향 동,서,남,북
            for (int direction = 0; direction < 4; direction++) {
                for (int k = 0; k <= lock.length; k++) {//가로
                    for (int k2 = 0; k2 <= lock.length; k2++) {//세로
                        int sum = 0;
                        //방향별로 탐색
                        int nx = k * dx[direction];
                        int ny = k2 * dy[direction];
                        for (int[] a : keyList) {
                            //배열 크기보다 크면 다음으로
                            if (a[0] + nx < 0 || a[1] + ny < 0 || a[0] + nx > lock.length - 1 || a[1] + ny > lock.length - 1)
                                continue;
                            //걸리는 부분이 있으면 실패
                            if (lock[a[0] + nx][a[1] + ny] == 1) {
                                break;
                            }
                            //홈과 돌기가 맞으면 체크
                            if (lock[a[0] + nx][a[1] + ny] == 0) {
                                sum++;
                            }
                        }
                        //lock의 모든 홈에 돌기가 맞으면 true
                        if (sum == blank) return true;
                    }
                }
            }
        }

        //모든 방향에서 실패하면 false
        return false;
    }

    public static void main(String[] args) {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 1, 1}};

        System.out.println(new Key().solution(key, lock));
    }
}
