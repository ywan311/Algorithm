package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");

        Long N = Long.parseLong(size[0]);
        Long M = Long.parseLong(size[1]);

        Long[] arr = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).toArray(Long[]::new);


    }
}
