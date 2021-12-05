package net.Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ToothBrush {
    static String[] referralArr;
    static int[] answer;
    static Map<String, Integer> map = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        referralArr = referral;
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            int index = map.get(seller[i]);
            answer[index] += amount[i] * 90;

            if (referral[index].equals("-")) {
                continue;
            }
            getPrice(index, amount[i] * 10);

        }

        return answer;
    }

    private void getPrice(int index, int money) {
        int refIndex = map.get(referralArr[index]);
        int next = (int) (money * 0.1);
        answer[refIndex] += money - next;

        if (referralArr[refIndex].equals("-")) {
            return;
        }
        if(next>0){
            getPrice(refIndex, next);
        }
    }

    public static void main(String[] args) {
        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"sam", "emily", "jaimie", "edward"};
//        String[] seller = new String[]{"young"};
        int[] amount = new int[]{2, 3, 5, 4};
//        int[] amount = new int[]{12};
        System.out.println(Arrays.toString(new ToothBrush().solution(enroll, referral, seller, amount)));
    }
}
