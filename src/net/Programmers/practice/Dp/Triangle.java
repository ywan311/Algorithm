package net.Programmers.practice.Dp;


public class Triangle {
    static int N;
    static int arr[];
    public int solution(int[][] triangle) {
        N = triangle.length;
        arr = new int[N*(N+1)/2];
        int answer[] = new int[N*(N+1)/2];
        int index=0;
        for(int[] a:triangle){
            for(int value: a){
                arr[index++]= value;
            }
        }
        answer[0] = arr[0];
        index =0;
        for(int i=1;i<N;i++){
            for(int j=0;j<i;j++){
                answer[index+i]= Math.max(answer[index+i],answer[index]+arr[index+i]);
                answer[index+i+1]= Math.max(answer[index+i+1],answer[index]+arr[index+i+1]);
                index++;
            }
        }
        int max = 0;
        for(int i: answer)max = Math.max(max, i);
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new Triangle().solution(new int[][]{{7},{3,8},{8,1,0},{2,7,4,4},{4,5,2,6,5}}));
    }
}
