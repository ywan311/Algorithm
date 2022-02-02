package net.Programmers;

import java.util.*;

//불량사용자
public class BanUser {
    Set<String> banUsers = new HashSet<>();
    boolean[] visited ;
    String[] wordArr, queryArr;
    public int solution(String[] words, String[] queries) {
        visited = new boolean[words.length];
        wordArr = Arrays.copyOf(words,words.length);
        queryArr = Arrays.copyOf(queries,queries.length);

        getSet(0,"");

        return banUsers.size();
    }

    //쿼리에 대해 일치하는 유저인지 검사
    boolean confirm(String word,String query){
        for(int i =0;i<word.length();i++){
            if(query.charAt(i)=='*'){
                continue;
            }
            if(query.charAt(i)!=word.charAt(i)){
                return false;
            }
        }
        return true;
    }
    /*
    * 쿼리에 대해 경우의 수 만들기
    * */
    void getSet(int index ,String s){
        if(index==queryArr.length){
            //유저가 겹칠 경우를 위해 배열 정렬 후 set에 넣음
            String[] sArr = s.split("/");
            Arrays.sort(sArr);
            banUsers.add(Arrays.toString(sArr));
            return;
        }
        for(int i =0;i< wordArr.length;i++){
            if(visited[i])continue;
            if(wordArr[i].length()==queryArr[index].length()&&confirm(wordArr[i],queryArr[index])){
                visited[i] = true;
                String input = s +"/"+ wordArr[i];
                //쿼리에 맞으면 다음 쿼리 체크
                getSet(index+1,input);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        BanUser test3 = new BanUser();
        String[] input1 = {"12345", "12453", "aaaaa"};
        String[] input2 = {"*****", "*****"};

        System.out.println(test3.solution(input1,input2));
    }
}
