package net.Programmers.practice.Tree;

import java.util.Arrays;
import java.util.HashMap;

public class SearchLyrics {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        Trie[] trie = new Trie[100001];
        return answer;
    }

    public static void main(String[] args) {
        SearchLyrics test3 = new SearchLyrics();
        String[] input1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] input2 = {"fro??", "????o", "fr???", "fro???", "pro?"};

        System.out.println(Arrays.toString(test3.solution(input1, input2)));
    }

    class Trie {
        Node front;
        Node back;

        public Trie(Node front, Node back) {
            this.front = front;
            this.back = back;
        }

        void insert(String input) {
            insertFront(input);
            insertBack(input);
        }

        void insertFront(String input) {
            Node current = front;
            for(int i=0;i<input.length();i++){
                current.cnt++;
                if(!current.children.containsKey(input.charAt(i))){
                    current.children.put(input.charAt(i),new Node());
                }
                current = current.children.get(input.charAt(i));
            }
        }

        void insertBack(String input) {
            Node current = back;
            for(int i=input.length()-1;i>=0;i--){
                current.cnt++;
                if(!current.children.containsKey(input.charAt(i))){
                    current.children.put(input.charAt(i),new Node());
                }
                current = current.children.get(input.charAt(i));
            }
        }
        int getCount(String s){
            if(s.charAt(0)=='?')return getBack(s);
            else return getFront(s);
        }
        int getBack(String s){
//            Node current = back;
//            for(int i=s.length();)
            return 0;
        }
        int getFront(String s){
return 0;
        }

        class Node {
            HashMap<Character, Node> children;
            int cnt;

            public Node() {
                this.children = new HashMap<>();
                this.cnt = 0;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "children=\n" + children +
                        ", cnt=" + cnt +
                        "}";
            }
        }
        public Trie() {
            this.front = new Node();
            this.back = new Node();
        }
    }


}