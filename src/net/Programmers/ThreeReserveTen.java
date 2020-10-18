package net.Programmers;

public class ThreeReserveTen {
    public int solution(int n) {
        return (int)to10(reverse(to3(n)));
    }
    public long to3(int n){
        StringBuilder result = new StringBuilder();
        while(n>0){
            result.insert(0, n % 3);
            n/=3;
        }
        return Long.parseLong(result.toString());
    }
    public long reverse(long n){
        StringBuilder builder = new StringBuilder();
        String input = String.valueOf(n);

        for( int i=0;i<input.length();i++){
            builder.append(input.charAt(input.length()-1-i));
        }
        return Long.parseLong(builder.toString());
    }
    public long to10(long n){
        char[] input = String.valueOf(n).toCharArray();
        long result=0;
        for(int i=input.length-1,j=1;i>=0;i--,j*=3){
            result += (input[i]-'0')*j;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(new ThreeReserveTen().solution(45));
    }
}
