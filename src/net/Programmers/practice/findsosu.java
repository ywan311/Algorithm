package net.Programmers.practice;

public class findsosu {
    public int solution(String numbers) {
        int answer = 0;
        for(int i= 0; i<numbers.length();i++){
            for(int j=0;j<numbers.length()-1;j++){
                int tmp = Integer.parseInt(numbers);
                for(int k =2;k<Math.sqrt(tmp);i++){
                    if (tmp % k == 0) {
                        answer++;
                        break;
                    }
                }
                String tmp2 = numbers.substring(0,j);
                numbers = tmp2+ numbers.substring(j);
            }
        }
        return answer;
    }
    public static void main (String args[]){
        findsosu t = new findsosu();
        System.out.print(t.solution("017"));
    }
}
