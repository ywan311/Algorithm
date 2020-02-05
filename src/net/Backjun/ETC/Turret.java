package net.Backjun;

import java.util.ArrayList;
import java.util.Scanner;

public class Turret {

    public static int Solution(int x1, int y1, int r1,int x2, int y2, int r2){
        double result;//(x1,y1)과 (x2,y2)간의 거리측정

        result = Math.sqrt(Math.pow((x1 - x2), 2)+  Math.pow((y1 - y2), 2));//피타고라스


        if ((x1 == x2 && y1 == y2)) {  //두좌표가 같은지 확인
            if(r1==r2)					//거리가 같으면 같은원
                return -1;
            else
                return 0;
        } else if (result <  (r1 + r2)) { //두좌표간 거리가 r1+r2보다 작으면 두곳에 위치가능
            return 2;
        } else if (result ==  (r1 + r2)) { 	//두좌표간 거리가 r1+r2와 같으면 한곳에 위치가능
            return 1;
        } else if (result >  (r1 + r2)) {  //두좌표간 거리가 r1+r2보다 크면 불가능
            return 0;
        }
        return 2;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub


        ArrayList<Integer> answer = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();//반복횟수 입력
        for (int i = 0; i < n; i++) { int x1;//x좌표
            int x2;
            int y1;//y좌표
            int y2;
            int r1;//거리
            int r2;
            x1 = scan.nextInt();

            y1 = scan.nextInt();

            r1 = scan.nextInt();

            x2 = scan.nextInt();

            y2 = scan.nextInt();

            r2 = scan.nextInt();

            answer.add(Solution(x1,y1,r1,x2,y2,r2));
        }
        for(int i: answer){
            System.out.println(i);
        }
    }

}
