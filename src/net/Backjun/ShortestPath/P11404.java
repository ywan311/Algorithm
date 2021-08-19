package net.Backjun.ShortestPath;
import java.io.*;

public class P11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int size = Integer.parseInt(br.readLine());
        int[][] arr = new int[size][size];
        final int INF = 100000*100+1;
        for(int i=0;i<size;i++){
            for(int j =0;j<size;j++){
                if(i==j)arr[i][j]=0;
                else arr[i][j] =100000*100+1;
            }
        }
        int n =Integer.parseInt( br.readLine());

        while (n-->0){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0])-1;
            int y = Integer.parseInt(input[1])-1;
            int z = Integer.parseInt(input[2]);

            arr[x][y]= Math.min(arr[x][y],z);
        }
        for(int k=0;k<size;k++){
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    if(arr[i][k]+arr[k][j]<arr[i][j]) arr[i][j] = arr[i][k]+arr[k][j];
                }
            }
        }

        for(int[] a: arr){
            for (int b: a){
                bw.write(b>=INF?"0 ":b+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
