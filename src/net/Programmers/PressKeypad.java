package net.Programmers;

public class PressKeypad {
    static String myHand;
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int right = 12;
        int left = 10;

        myHand = hand.equals("right")?"R":"L";
        for(int i : numbers){
            int num = i==0?11:i;
            if(num%3==1){
                answer.append("L");
                left = num;
            }else if(num%3==0){
                answer.append("R");
                right=num;
            }else{
                int leftDist = Math.abs((left-1)/3-(num-1)/3) ;
                leftDist +=  (left-num)%3==0?0:1;
                int rightDist = Math.abs((right-1)/3-(num-1)/3) ;
                rightDist += (right-num)%3==0?0:1;
                if(leftDist<rightDist){
                    answer.append("L");
                    left=num;
                }else if(rightDist<leftDist){
                    answer.append("R");
                    right=num;
                }else{
                    answer.append(myHand);
                    if (myHand.equals("R"))right=num;
                    else left = num;
                }
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new PressKeypad().solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5,4,8,2},"right"));
    }
}
