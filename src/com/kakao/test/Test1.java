package com.kakao.test;

public class Test1 {
    static String str;
    static int answer;
    public int solution(String s) {
        answer = s.length();
        str=s;
        for(int i=1;i<=s.length()/2;i++){
            if(i<answer)Compression(s,i);
        }
        return answer;
    }
    public static void Compression(String s, int length){

        String tmp = s.substring(0,length);
        String subAnswer = tmp;
//        if(!tmp.equals(s.substring(length,length*2)))return;
        int n=1;
        int last=length;
        for(int i=length;i+length<=s.length();i+=length){
            String sub = s.substring(i,i+length);
            if(tmp.equals(sub))n++;
            else{
                if(n>1)subAnswer+=n;
                subAnswer+=sub;
                n=1;
            }
            tmp = sub;
            last =i;
        }
        subAnswer += s.substring(last+length );
        if(n>1)subAnswer+=n;
        System.out.println(length+":"+subAnswer);
        answer  = Math.min(subAnswer.length(),answer);
    }

    public static void main(String args[]) {
        Test1 test1 = new Test1();
        String s ="abcabcabcabcdededededededededededede";
        while(s.length()<1000)s+=s;
        System.out.println(s.length());
        System.out.println(test1.solution(s));
    }
}