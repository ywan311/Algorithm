package net.Programmers;

public class EatLand {
    int solution(int[][] land) {

        int answer=0;
        int[][] dp= new int[land.length][2];
        int max = 0;
        int index=0;
        for(int i=0;i<land[0].length;i++){
            if(max<land[0][i]){
                max = land[0][i];
                index=i;
            }
        }
        dp[0][0] = max;
        dp[0][1]= index;
        for(int i=1;i<dp.length;i++){
            max=0;
            index=0;
            for(int j=0;j<land[i].length;j++){
                if(max<land[i][j]&&dp[i-1][1]!=j){
                    System.out.println(i+":"+j);
                    max = land[i][j];
                    index=j;
                }
            }
            dp[i][0]= dp[i-1][0]+max;
            dp[i][1] = index;
        }
        answer = dp[land.length-1][0];

        return answer;
    }
    public static void main(String[] args) {
        System.out.println(new EatLand().solution(new int[][]{
                {1,2,3,5}
                ,{5,6,7,8}
                ,{4,3,2,1}
        }));
    }

}
