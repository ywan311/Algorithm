package net.Programmers;


public class GoBridge {
    public int solution(int[] stones, int k) {
        int left = Integer.MAX_VALUE;
        int right = 0;
        int answer=0;
        for(int i:stones){
            right = Math.max(right,i);
            left = Math.min(left,i);
        }
        while(left<=right){
            int mid = (left+right)/2;
            int tmp=0;
            System.out.println(left+":"+right+":"+mid);
            boolean flag = false;
            for(int i=0;i<stones.length;i++){
                if(stones[i]<mid)tmp++;
                else tmp=0;
                if(tmp>=k){
                    flag=true;
                    break;
                }
            }
            if (flag){
                right=mid-1;
            }else{
                answer = Math.max(answer,mid);
                left=mid+1;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        int input[] = new int[200000];
        for(int i=0;i<input.length;i++){
            input[i] = i<=100000?100000-i:100000+i;
        }
        System.out.println(new GoBridge().solution(input,200000));
    }
}
