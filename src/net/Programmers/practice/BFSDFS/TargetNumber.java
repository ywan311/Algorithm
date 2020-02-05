package net.Programmers.practice.BFSDFS;

public class TargetNumber {
    static int K;
    static int[] NUM;
    public int solution(int[] numbers, int target) {
        K=target;
        NUM = numbers;
        return DFS(0, 0);
    }
    public static int DFS(int index, int sum){
        if(index==NUM.length-1){
            return sum+NUM[index]==K||sum-NUM[index]==K?1:0;
        }else return DFS(index+1, sum+NUM[index])+DFS(index+1, sum-NUM[index]);
    }
    public static void main(String[] args) {
        System.out.println(new TargetNumber().solution(new int[]{1,1,1,1,1}, 3));
    }
}
