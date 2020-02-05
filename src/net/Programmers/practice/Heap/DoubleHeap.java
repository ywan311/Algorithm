package net.Programmers.practice.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoubleHeap {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) return -1;
                else return 1;
            }
        });
        for (String s : operations) {
            System.out.println(s);
            String str[] = s.split(" ");
            int value = Integer.parseInt(str[1]);
            if (str[0].equals("I")) {
                minHeap.offer(value);
                maxHeap.offer(value);
            } else if (str[0].equals("D") && !minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (value == 1) {
                    int tmp = maxHeap.poll();
                    minHeap.remove(tmp);
                } else if (value == -1) {
                    int tmp = minHeap.poll();
                    maxHeap.remove(tmp);

                }
            }
        }

        if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
            answer[0] = maxHeap.peek();
            answer[1] = minHeap.peek();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DoubleHeap().solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));
    }
}
