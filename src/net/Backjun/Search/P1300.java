package net.Backjun;

import java.util.*;
import java.util.stream.Collectors;

public class P1300 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long k = sc.nextLong();
        if (N == 1) {
            if (k > 1) {
                System.out.println(0);
            } else System.out.println(1);
            return;
        } else if (N >= k) {
            System.out.println(k);
            return;
        }
        long left = 0;
        long right = N * N;
        long mid = 0;
        while (left <= right) {
            long cnt1 = 0;
            long cnt2 = 0;
            mid = (left + right) / 2;
            for (int i = 1; i <= N; i++) {
                cnt1 += Math.min(N, mid / i);
                cnt2 += Math.min(N, (mid - 1) / i);
            }
            System.out.println(mid);
            System.out.println("cnt1:"+cnt1+" / cnt2:"+cnt2);
            if (cnt1 >= k && cnt2 < k)
                break;
            else if (cnt2 >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(mid);
    }
}
