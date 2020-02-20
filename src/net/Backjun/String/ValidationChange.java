package net.Backjun.String;

import java.util.Scanner;

public class ValidationChange {
    static String E = "Error!";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        StringBuilder builder = new StringBuilder();
        int status=0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if((c>='a'&&c<='z')) builder.append(c);
            else {
                if(c>='A'&&c<='Z'&&(status==1||status==0)&&i>0){//java to c++
                    status=1;//java status
                    builder.append('_');
                    builder.append(Character.toLowerCase(c));
                }else if(c=='_'&&(status==2||status==0)&&i<str.length()-1&&i>0){//c++ to java
                    if(str.charAt(i+1)>='A'&&str.charAt(i+1)<='Z'||str.charAt(i+1)=='_'){ //_다음 _ 나 대문자가 나온경우 에러
                        System.out.println(E);
                        return;
                    }
                    status=2;//c++ status
                    builder.append(Character.toUpperCase(str.charAt(++i)));
                }
                else{
                    System.out.println(E);
                    return;
                }
            }
        }
        System.out.println(builder.toString());

    }
}
