package net.Backjun;
import java.io.*;
import java.util.*;

public class P1005 {
    static int[] time;
    static int[] inDegree;
    static int destination;
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int K = Integer.parseInt(input[1]);
            time = new int[N + 1];
            inDegree = new int[N + 1];
            String[] elements = br.readLine().split(" ");
            graph.add(new ArrayList<>());
            for (int j = 1; j < time.length; j++) {
                time[j] = Integer.parseInt(elements[j-1]);
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < K; j++) {
                String[] edges = br.readLine().split(" ");
                int from = Integer.parseInt(edges[0]);
                int to = Integer.parseInt(edges[1]);

                graph.get(from).add(to);
                inDegree[to]++;
            }
            destination = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(solve()));
            bw.write("\n");
            graph.clear();
        }
        bw.flush();
    }

    static int solve(){
        List<Integer> startList = new ArrayList<>();
        int sum = 0;
        for(int i =1;i<inDegree.length;i++){
            if(inDegree[i]==0){
                startList.add(i);
                if(destination==i)return time[i];
            }
        }

        for(int start: startList){
            Queue<Integer> queue = new LinkedList<>(graph.get(start));
            graph.get(start).forEach(o -> inDegree[o]--);
            sum+=time[start];
            while(true){
                Queue<Integer> tmp = new LinkedList<>();
                boolean isComplete=false;
                int max = 0;
                while(!queue.isEmpty()){
                    int current = queue.poll();
                    if(inDegree[current]>0){
                        continue;
                    }
                    max = Math.max(max,time[current]);
                    if(current==destination){
                        isComplete=true;
                        continue;
                    }
                    List<Integer> children = graph.get(current);
                    children.forEach(o -> inDegree[o]--);
                    tmp.addAll(children);
                }
                sum+=max;
                if(isComplete || tmp.isEmpty()){
                    if(isComplete && max>time[destination]){
                        sum-=max;
                        sum+=time[destination];
                    }
                    return sum;
                }else {
                    queue.addAll(tmp);
                }
            }
        }
        return -1;
    }
}
