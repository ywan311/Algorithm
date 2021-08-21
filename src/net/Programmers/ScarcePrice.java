package net.Programmers;

public class ScarcePrice {
    public long solution(int price, int money, int count) {
        long sum;
        if(count==1)return Math.min(0,money-price);

        sum = 3L*price;

        for (int i=3;i<=count;i++){
            sum += i*price;
        }

        return Math.abs(Math.min(0,money-sum));
    }

    public static void main(String[] args) {
        System.out.println(new ScarcePrice().solution(3,20,4));
    }
}
