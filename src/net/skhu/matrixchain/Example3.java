package net.skhu.matrixchain;

public class Example3 {//minTemp 변수에  최솟값을 구했을 경우에 저장하여 호출수를 줄인다 O(n)

    static class Matrix {
        int row, col;

        public Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int[][] minTemp;//최솟값을 구했을때 잠시 가지고 있을 최솟값

    static int findMin(Matrix[] a, int start, int end) throws Exception {//최솟값을 구하는 함수
        if (minTemp == null) minTemp = new int[a.length][a.length];
        if (minTemp[start][end] != 0) return minTemp[start][end];//이미 최솟값이 있으면 그값으로 출력
        if (start == end) return 0;
        System.out.printf("(%d, %d) ", start, end);//15번 출력
        int min = Integer.MAX_VALUE;
        for (int middle = start; middle < end; ++middle) {
            int value = findMin(a, start, middle);
            value += findMin(a, middle + 1, end);
            value += a[start].row * a[middle].col * a[end].col;
            if (value < min) min = value;
        }
        return minTemp[start][end] = min;
    }

    public static void main(String[] args) throws Exception {
        Matrix[] a = new Matrix[] { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
                                    new Matrix(50, 3), new Matrix(3, 8), new Matrix(8, 30) };
        System.out.println(findMin(a, 0, a.length-1));
    }
}
