package net.Programmers.practice.String;

public class Dart {
    public int solution(String dartResult) {
        char[] arr = dartResult.toCharArray();
        int result[] = new int[3];
        int i = -1;
        for (int j=0;j<arr.length;j++) {
            char c = arr[j];
            switch (c) {
                case 'S':
                    break;
                case 'D':
                    result[i] = result[i] * result[i];
                    break;
                case 'T':
                    result[i] = result[i] * result[i] * result[i];
                    break;
                case '*':
                    if (i > 0) result[i - 1] *= 2;
                    result[i] *= 2;
                    break;
                case '#':
                    result[i] *= -1;
                    break;
                case '1':
                    if(arr[j+1]=='0'){
                        result[++i] = 10;
                        j++;
                        break;
                    }
                default:
                    result[++i] = c - '0';
            }
        }
        return result[0]+result[1]+result[2];
    }

    public static void main(String[] args) {
        System.out.println(new Dart().solution("1D2S#10S"));
    }
}
