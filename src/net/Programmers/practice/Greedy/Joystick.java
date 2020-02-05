package net.Programmers.practice;

public class Joystick {
    public int solution(String name) {
        boolean flag = true;
        int start = -1;
        int end1 = 0;
        int end2 = 0;
        char[] array = name.toCharArray();
        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            answer += array[i] - 'A' > 'Z' - array[i] + 1 ? 'Z' - array[i] + 1 : array[i] - 'A';
            if (array[i] - 'A' != 0) {
                if (flag && start == -1)
                    start = i;
                else if (flag){
                    end1 = i;
                    flag=false;
                }
                else end2 = i;
            }
        }
        end1 = end1==0?start:end1;
        end2 = end2==0?end1:end2;
        if(start==-1)return 0;
        else{
            answer += Math.min(Math.min(end2,2*start+array.length-end1),array.length-start);
        }
        return answer;
    }
    /*class Solution {
        public int solution(String name) {
            int answer = 0;
            int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
            for(char c:name.toCharArray())
                answer+=diff[c-'A'];

            int length=name.length();
            int min=length-1;

            for(int i=0;i<length;i++){
                int next=i+1;
                while(next<length && name.charAt(next)=='A'){
                    next++;
                }
                min=Math.min(min,i+length-next+Math.min(i,length-next));
            }

            return answer+min;
        }
    }*/
    public static void main(String[] args){
        System.out.println(new Joystick().solution("AZAAAAZ"));
    }
}
