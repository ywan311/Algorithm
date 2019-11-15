package net.Programmers.practice;


public class ModAndSum {
        public boolean test(int x) {
            boolean answer =false;
            String number = String.valueOf(x);
            int sum=0;

            for(int i =0;i<number.length();i++){
                sum = sum + number.charAt(i)-'0';
            }
            if(x%sum==0)answer=true;

            return answer;
        }
        public static void main(String[] args){
            ModAndSum t = new ModAndSum();
            System.out.println(t.test(19));
        }
    }