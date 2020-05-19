package net.Backjun.Dp;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PasswordCode {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long dp[] = new long[input.length()+1];
        int mod = 1000000;
        if(input.charAt(0)=='0'){
            System.out.println(0);
            return;
        }
        char check = input.charAt(input.length()-2);
        if(input.charAt(input.length()-1)=='0'&&!(check=='1'||check=='2')){
            System.out.println(0);
            return;
        }
        dp[0]=dp[1]=1;
        for(int i=2;i<=input.length();i++){
            int tmp = input.charAt(i-1)-'0';
            dp[i] = tmp>0?dp[i-1]%mod:0;
             tmp += (input.charAt(i-2)-'0')*10;
            if(tmp>=10&&tmp<=26)dp[i]+=dp[i-2]%mod;
            dp[i]%=mod;
        }

        System.out.println(dp[input.length()]%mod);
    }
}
