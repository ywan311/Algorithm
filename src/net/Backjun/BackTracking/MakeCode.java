package net.Backjun.BackTracking;

        import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.HashSet;
        import java.util.Set;

public class MakeCode {
    static int L;
    static int C;
    static Set<Character> vowel = new HashSet<>();
    static char[] arr;
    static ArrayList<String> answerList = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String size[] = br.readLine().split(" ");
        L = Integer.parseInt(size[0]);
        C = Integer.parseInt(size[1]);
        arr = new char[C];
        vowel.add('a');
        vowel.add('e');
        vowel.add('i');
        vowel.add('o');
        vowel.add('u');

        arr = (br.readLine().replace(" ","")).toCharArray();

        Arrays.sort(arr);
        for(int i=0;L+i<=C;i++){
            DFS("",i,0);
        }
        for(String s:answerList)System.out.println(s);

    }
    static void DFS(String s,int index,int vCnt){
        s+=arr[index];
        if(vowel.contains(arr[index]))vCnt++;
        if(L-vCnt<2)return;
        if(s.length()==L){
            if(vCnt>0&&L-vCnt>=2)answerList.add(s);
            return;
        }

        for(int i=index+1;i<C;i++){
            DFS(s,i,vCnt);
        }
    }
}