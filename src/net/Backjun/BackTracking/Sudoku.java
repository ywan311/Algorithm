package net.Backjun.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//미완성
public class Sudoku {
    static boolean flag=false;
    static int[][] matrix = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<9;i++){
            String[] str = br.readLine().split(" ");
            for (int j=0;j<9;j++){
                matrix[i][j] = Integer.parseInt(str[j]);
                if(matrix[i][j]==0)list.add(new int[]{i,j});
            }
        }
        DFS(0);
    }
    static void DFS(int index){
        if(flag)return;
        int[] current = list.get(index);
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<9;i++){
            set.add(i+1);
        }
        System.out.println(set);
        print(matrix);
        System.out.println("-------------");
        int x = current[0]/3*3;
        int y = current[1]/3*3;

        for(int i=0;i<9;i++){
            if(set.contains(matrix[current[0]][i]))set.remove(matrix[current[0]][i]);
            if(set.contains(matrix[i][current[1]]))set.remove(matrix[i][current[1]]);
            if(set.contains(matrix[x+i/3][y+i%3]))set.remove(matrix[x+i/3][y+i%3]);
        }
        if(set.isEmpty())return;
        for(int i:set){
            matrix[current[0]][current[1]]=i;
            if(list.size()-1==index){
                print(matrix);
                flag=true;
                return;
            }else
                DFS(index+1);
            matrix[current[0]][current[1]]=0;
        }
    }

    static void print(int[][] matrix){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
