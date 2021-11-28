package net.Programmers;

import java.util.*;

//이분탐색 필요 !!!!!
//효율성 통과 못함
public class ScoreSearch {
    static Map<String, ArrayList<Integer>> map = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for(String s : info){
            String[] arr = s.split(" ");
            getCombination(0,"", arr);
        }

        for(int i =0;i<query.length;i++){
            String key = query[i].replaceAll(" and ", "");
            String[] arr = key.split(" ");
            if(!map.containsKey(arr[0])){
                answer[i] = 0;
            }else{
                Collections.sort(map.get(arr[0]));
                answer[i]=search(arr[0],Integer.parseInt(arr[1]));
            }


        }

        return answer;
    }

    void getCombination(int depth,String input ,String[] arr){

        if(depth==4){
            if (!map.containsKey(input)) {
                map.put(input, new ArrayList<>());
            }
            map.get(input).add(Integer.parseInt(arr[4]));
            return ;
        }
        getCombination(depth+1,input+"-",arr);
        getCombination(depth+1,input + arr[depth],arr);
    }
    static int search(String key, int score){
        if(!map.containsKey(key))return 0;
        ArrayList<Integer> list = map.get(key);

        int start = 0;
        int end = list.size()-1;
        while(start <= end){

            int mid = (start + end)/2;

            if(score > list.get(mid)) start = mid + 1;
            else end = mid - 1;
        }
        return list.size() - start;

    }

    public static void main(String[] args) {
        String[] a = new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] b = new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};


    }
}
