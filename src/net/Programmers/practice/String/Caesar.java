package net.Programmers.practice;


public class Caesar {
    public String solution(String s, int n) {
        StringBuffer answer = new StringBuffer();
        char[] input = s.toCharArray();
        for (int i =0; i<input.length;i++){
            if(input[i]-' '==0)answer.append(input[i]);
            else{
                if(input[i]>='a'&&input[i]<='z'){
                    input[i]+=n;
                    if(input[i]>'z')answer.append((char)(input[i]-'z'+'a'-1));
                    else answer.append(input[i]);
                }else if(input[i]>='A'&&input[i]<='Z'){
                    input[i]+=n;
                    if(input[i]>'Z')answer.append((char)(input[i]-'Z'+'A'));
                    else answer.append(input[i]);
                }
            }
        }
        return answer.toString();
    }
    public static void main(String[] args){
        System.out.println(new Caesar().solution("a B z",4));
    }
}
