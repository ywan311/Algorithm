package net.Backjun;

import java.util.HashMap;
import java.util.Map;

public class YutGame {
    static int[][] arr = new int[][]{
            {2,4,6,8,10},
            {13,16,19,25},
            {12,14,16,18,20},
            {22,24,25},
            {22,24,26,28,30},
            {28,27,26,25},
            {30,35,40},
            {32,34,36,38,40}
    };
    public static void main(String[] args) {

    }
    class Position{
        int x;
        int y;
        int sum;

        public Position(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
}
