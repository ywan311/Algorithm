package net.Programmers.practice.BinarySearch;

public class ImmigrationExamination {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long left=1;
        long right =0;
        long mid;

        for(int time:times){
            if(time>right)right=time;
        }
        right*=n;


        while(left<=right){
            mid =(left+right)/2;
            long done=0;
            for(int time:times)
                done+=mid/time;
            if(done<n)
                left = mid+1;
            else {
                if (mid < answer)answer=mid;
                right= mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new ImmigrationExamination().solution(10,new int[]{1,5}));

    }

}
