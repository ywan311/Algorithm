package net.Programmers;


//8주차_최소직사각형
public class MinimalSquare {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;
        for (int[] a : sizes){
            max1 = Math.max(max1,Math.min(a[0],a[1]));
            max2 = Math.max(max2,Math.max(a[0],a[1]));
        }
        return max1*max2;
    }

    public static void main(String[] args) {
        System.out.println(new MinimalSquare().solution(new int[][]{
                {10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}
        }));
    }
}
