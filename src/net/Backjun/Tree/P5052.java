package net.Backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class P5052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Trie trie;
        while (n-- > 0) {
            trie = new Trie();
            int m = Integer.parseInt(br.readLine());
            String[] input = new String[m];
            for (int i = 0; i < m; i++) input[i] = br.readLine();

            Arrays.sort(input, (o1, o2) -> o1.length() - o2.length());
            boolean flag = true;
            for(String s : input){
                if (!trie.insert(s)){
                    flag=false;
                    break;
                }
            }
            System.out.println(flag ? "YES" : "NO");

        }
    }

    static class Trie {
        TrieNode root;

        class TrieNode {
            boolean isLast;
            Map<Character, TrieNode> children = new HashMap<>();

            @Override
            public String toString() {
                return "\nTrieNode{" +
                        "isLast=" + isLast +
                        ", children=" + children +
                        '}';
            }
        }

        boolean insert(String s) {
            TrieNode current = this.root;

            for (int i = 0; i < s.length(); i++) {
                current = current.children.computeIfAbsent(s.charAt(i), character -> new TrieNode());
                if(current.isLast)return false;
            }
            current.isLast = true;
            return true;
        }

        public Trie() {
            root = new TrieNode();
        }

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }
    }
}



