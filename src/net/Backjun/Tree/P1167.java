package net.Backjun.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P1167 {
    static List<List<Integer>> tree;
    static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        tree = new ArrayList<>();
        for(int i=0;i<=size;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<=size;i++){

        }
    }
}
