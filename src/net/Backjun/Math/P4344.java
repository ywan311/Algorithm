package net.Backjun.Math;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P4344 {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int repeatCount = sc.nextInt();
        DecimalFormat df = new DecimalFormat("###0.000");
        double result[] = new double[repeatCount];
        for (int i = 0; i < repeatCount; i++) {
            int studentCount = sc.nextInt();
            int studentGrade[] = new int[studentCount];
            int gradeAvg = 0;
            int successCount = 0;
            double avg = 0.0;
            for (int j = 0; j < studentCount; j++) {
                studentGrade[j] = sc.nextInt();
                gradeAvg = gradeAvg + studentGrade[j];
            }
            gradeAvg = gradeAvg / studentCount;
            for (int j = 0; j < studentCount; j++) {
                if (studentGrade[j] > gradeAvg) {
                    successCount++;
                }
            }
            avg = Math.round((successCount / Double.parseDouble(String.valueOf(studentCount))) * 100000);
            result[i] = avg / 1000;
//            System.out.println(result[i]);
        }
        for (int i = 0; i < repeatCount; i++) {
            System.out.println(df.format(result[i]) + "%");
        }
    }
}
