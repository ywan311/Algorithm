package net.Backjun.Bruteforce;

public class NextNumber {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        int sum=0;
        for(char c: s.toCharArray()){
            if(c=='1')sum++;
        }
        while(true){
            n++;
            int tmp =0;
            s =Integer.toBinaryString(n);
            for(char c: s.toCharArray()){
                if(c=='1')tmp++;
            }
            if(tmp==sum)break;
        }
        answer = Integer.parseInt(s,2);
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new NextNumber().solution(78));
    }
}
