package net.Programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sonf {
    //곡별로 음계 전체 만들기
    static String[][] pattern = new String[][]{{"C#","c"},{"D#","d"},{"F#","f"},{"G#","g"},{"A#","a"}};
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        PriorityQueue<Song> queue = new PriorityQueue<>(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                if(o1.time==o2.time)return o1.start-o2.start;
                else return o2.time-o1.time;
            }
        });
        for(String s: musicinfos){
            String str[] = s.split(",");
            int time = getTime(str[0],str[1]);
            queue.offer(new Song(Integer.parseInt(str[0].replaceAll(":","")),time,str[2],getFull(time,str[3])));
        }
        System.out.println(queue);
        while(!queue.isEmpty()){
            Song current = queue.poll();
            if(check(m,current))return current.name;
        }
        return answer;
    }
    //전체음계 구하기
    static String getFull(int time,String scale){
        StringBuilder total=new StringBuilder();
        scale = removeSharp(scale);
        System.out.println(time+scale);
        for(int i=0;i<time;i++){
            total.append(scale.charAt(i%scale.length()));
        }
        return total.toString();
    }
    //시간변환
    static int getTime(String start, String end){
        String startA[] = start.split(":");
        String endA[] = end.split(":");
        int hour = 0;
        int minute= 0;
        int sh = Integer.parseInt(startA[0]);
        int eh = Integer.parseInt(endA[0]);
        int sm =Integer.parseInt(startA[1]);
        int em = Integer.parseInt(endA[1]);
        if(em<sm){//분이 넘어가는 경우
            minute = 60-sm+em;
            eh--;
        }else minute =em-sm;
        if(eh<sh){//시가 넘어가는 경우, 00:00이상일 경우
            hour = 23-sh;
            minute = sm==0?0:60-sm;
        }else hour = eh-sh;
        System.out.println(hour+":"+minute);
        return hour*60+minute;
    }
    static boolean check(String input, Song song){
        input = removeSharp(input);
        for(int i=0;i+input.length()<=song.scale.length();i++){
            if(song.scale.substring(i,i+input.length()).equals(input))return true;
        }
        return false;
    }
    static String removeSharp(String input){
        for(int i=0;i<pattern.length;i++){
            input = input.replaceAll(pattern[i][0],pattern[i][1]);
        }
        return input;
    }
    class Song{
        int start;
        int time;
        String name;
        String scale;
        public Song(int start,int time, String name, String scale) {
            this.start = start;
            this.time = time;
            this.name = name;
            this.scale = scale;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "start=" + start +
                    ", name='" + name + '\'' +
                    ", scale='" + scale + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        System.out.println(new Sonf().solution("ABC", new String[]{"13:40,13:40,HELLO,C#DEFGAB", "20:00,14:01,WORLD,ABCDEF"}));
    }
}
