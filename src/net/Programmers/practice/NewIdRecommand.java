package net.Programmers.practice;

public class NewIdRecommand {
    public String solution(String new_id) {
        return level7(level6(level5(level4(level3(level2(level1(new_id)))))));
    }

    String level1(String input){
        return input.toLowerCase();
    }
    String level2(String input){
        return input.replaceAll("[^a-z0-9\\-_.]","");
    }
    String level3(String input){
        StringBuilder result = new StringBuilder();
        char pre = '!';
        for (char c : input.toCharArray()){
            if(pre=='.'&&c=='.')
                continue;
            result.append(c);
            pre=c;
        }
        return result.toString();
    }
    String level4(String input){
        if(input.length()==0)return "";
        StringBuilder result = new StringBuilder();
        for(int i =0;i<input.length();i++){
            if((i==0||i==input.length()-1)&&input.charAt(i)=='.')continue;
            result.append(input.charAt(i));
        }
        return result.toString();
    }
    String level5(String input){
        return input.length()==0?"a":input;
    }
    String level6(String input){
        String result = input.length()>15?input.substring(0,15):input;
        return result.charAt(result.length()-1)=='.'?result.substring(0,result.length()-1):result;
    }
    String level7(String input){
        StringBuilder inputBuilder = new StringBuilder(input);
        while(inputBuilder.length()<3){
            inputBuilder.append(inputBuilder.charAt(inputBuilder.length() - 1));
        }
        input = inputBuilder.toString();
        return input;
    }

    public static void main(String[] args) {
        System.out.println(new NewIdRecommand().solution("z-+.^."));
    }
}
