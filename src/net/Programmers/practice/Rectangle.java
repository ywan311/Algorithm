package net.Programmers.practice;

public class Rectangle {
    public long solution(int w, int h) {
        long answer = 1;
        int tmp = 1;
        for(int i = w>h?h:w;i>0;i--){
            if(w%i==0&&h%i==0){
                tmp=i;
                break;
            }
        }
        answer =(long)w*(long)h;
        return answer-tmp*(w/tmp + h/tmp-1);
    }

    public static void main(String[] args){
       System.out.println( new Rectangle().solution(8,12));
    }
}
