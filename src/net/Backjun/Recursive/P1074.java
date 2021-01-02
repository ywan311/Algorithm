package net.Backjun.Recursive;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1074 {
    static int N;
    static int r;
    static int c;
    static int size;
    static int answer =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);

        size = (int)Math.pow(2,N);


        solve(0,size-1,0,size-1);


    }
    static void solve(int x1,int x2, int y1, int y2){
        if(x2-x1==1&&y2-y1==1){
            if(r==x1&&c==y1){
                System.out.println(answer);
                return;
            }
            if(r==x1&&c==y2){
                answer+=1;
                System.out.println(answer);
                return;
            }
            if(r==x2&&c==y1){
                answer+=2;
                System.out.println(answer);
                return;
            }
            if(r==x2&&c==y2){
                answer+=3;
                System.out.println(answer);
                return;
            }
            answer+=4;
            return;
        }
        int midx = (x1+x2)/2;
        int midy = (y1+y2)/2;
        solve(x1,midx,y1,midy);
        solve(x1,midx,midy+1,y2);
        solve(midx+1,x2,y1,midy);
        solve(midx+1,x2,midy+1,y2);
    }
}
