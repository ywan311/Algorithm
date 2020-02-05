
package net.Programmers.practice.Dp;

public class MakeN {
    static int Num;
    static int n;
    static int answer = -1;

    public int solution(int N, int number) {
        n = N;
        Num = number;

        DFS(0, 0);

        return answer;
    }

    static void DFS(int current, int cnt) {
        System.out.println(current + "  " + cnt);
        if (cnt > 8) {
            answer = -1;
            return;
        }
        if (current == Num) {
            if (answer == -1 || answer > cnt){

                answer = cnt;
            }
            return;
        }
        int tmp = n;

        for (int i = 0; i < 8 - cnt; i++) {
            DFS(current + tmp, cnt + i + 1);
            DFS(current - tmp, cnt + i + 1);
            DFS(current * tmp, cnt + i + 1);
            DFS(current / tmp, cnt + i + 1);

            tmp = tmp * 10 + n;

        }


    }

    public static void main(String[] args) {
        System.out.println(new MakeN().solution(5, 12));
    }
}
/*class MakeN {
    static int answer =-1;

    public int solution(int N, int number) {

        dfs(N, number, 0,0);
        return answer;
    }
    static void dfs(int N, int number , int cnt, int prev) {
        //N의 카운트를 늘려가며 dfs 로 수행한다.
        //그 값을 저장하고 그 값이 number와 동일한지 확인한다.
        System.out.println(prev+"    "+cnt);
        int temp_N = N;
        if (cnt > 8) {
            answer = -1;
            return;
        }

        if (number == prev ) {
            if (answer == -1 || answer > cnt)
                answer = cnt;
            return;
        }
        for (int i = 0; i < 8-cnt; i++) {
            dfs(N, number, cnt+i+1, prev-temp_N);
            dfs(N, number, cnt+i+1, prev+temp_N);
            dfs(N, number, cnt+i+1, prev*temp_N);
            dfs(N, number, cnt+i+1, prev/temp_N);

            temp_N =  increaseNumber(temp_N, N);
        }
    }
    static int increaseNumber(int value, int N) {
        return value * 10 + N;
    }
    public static void main(String[] args) {
        System.out.println(new MakeN().solution(5,10));
    }
}*/
