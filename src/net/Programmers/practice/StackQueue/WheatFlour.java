package net.Programmers.practice.StackQueue;

public class WheatFlour {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        while(stock<k){
            int max=0;
            int index=0;
            for(int i=0;i<dates.length;i++){
                if(dates[i]<=stock&&max<supplies[i]&&dates[i]!=0){
                    max = supplies[i];
                    index=i;
                }
            }
            stock+=max;
            dates[index]=0;
            answer++;
        }
        return answer;
        //힙을 쓰는밤법
        //재가동 날짜 만큼 반복, stock-- , 날짜에 해당하는 날 date 배열에 값 존재시에 힙에 pulies의 해당 값을 넣음
        //stock 이 0이 될때 힙에서 stock 추가(최대값)
    }
    public static void main(String[] args){
        System.out.println(new WheatFlour().solution(4,new int[]{4,10,15},new int[]{20,5,10},30));
    }
}
