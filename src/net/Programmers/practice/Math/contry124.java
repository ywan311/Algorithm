package net.Programmers.practice.Math;

public class contry124 {
    public String solution(int n) {
        String answer = "";
        while(n>=1) {
            String tmp =(n%3==0)?String.valueOf(4): String.valueOf(n % 3);
            answer = tmp.concat(answer);
            if(tmp.equals("4"))n-=3;
            n /= 3;
        }
        Long tmp = Long.valueOf(answer);
        answer = String.valueOf(tmp);
        return answer;
        /*String[] num = {"4","1","2"};
      String answer = "";

      while(n > 0){
          answer = num[n % 3] + answer;
          n = (n - 1) / 3;
      }
      return answer;*/
    }
    public static void main(String[] args){
        contry124 t = new contry124();
        System.out.println(t.solution(11));
    }
}
