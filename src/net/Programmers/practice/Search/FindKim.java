package net.Programmers.practice.Search;

public class FindKim {
    public String solution(String[] seoul) {
        int i=0;
        for(i=0;i<seoul.length;i++){
            if(seoul[i].equals("kim"))break;
        }
        return "김서방은 "+i+"에 있다";
    }
    public static void main(String[] args){
        FindKim f = new FindKim();
        System.out.println(f.solution(new String[]{"Jane","Jane","Jane","Jane","Jane","Jane","Jane","Kim","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane","Jane"}));
    }
}
