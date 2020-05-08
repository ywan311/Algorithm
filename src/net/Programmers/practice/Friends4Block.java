package net.Programmers.practice;


import java.util.Arrays;

//미완성
public class Friends4Block {
    int answer = 0;
    public int solution(int m, int n, String[] board) {
        boolean checkBreak[][] = new boolean[board.length][board[0].length()];
        boolean flag=false;
        char charBoard[][] = new char[board.length][board[0].length()];
        for(int i=0;i<m;i++){
            charBoard[i] = board[i].toCharArray();
        }
        for(int i=0;i<m-1;i++){
            for (int j=0;j<n-1;j++){
                if(charBoard[i][j]!='.'&&charBoard[i][j]==charBoard[i+1][j]&&charBoard[i][j]==charBoard[i][j+1]&&charBoard[i][j]==charBoard[i+1][j+1]){
                    flag=true;
                    checkBreak[i][j]=true;
                    checkBreak[i+1][j]=true;
                    checkBreak[i][j+1]=true;
                    checkBreak[i+1][j+1]=true;
                }
            }
        }
        if(flag)return solution(m,n,resort(removeBlock(charBoard,checkBreak)));
        else return answer;
    }
    public char[][] removeBlock(char[][] board,boolean[][] check){
        for(int i=0;i<check.length;i++){
            for (int j=0;j<check[0].length;j++){
                if(check[i][j]){
                    board[i][j]='.';
                    answer++;
                    check[i][j] =false;
                }
            }
        }
        return board;
    }
    public String[] resort(char[][] board){//수정

        for(char[] a:board)System.out.println(Arrays.toString(a));
        System.out.println("-----------------------");
        String[] result = new String[board.length];
        boolean flag=false;
        for(int i=0;i<board.length-1;i++){
            for (int j=0;j<board[0].length;j++){
                if(board[i+1][j]=='.'&&board[i][j]!='.'){
                    board[i+1][j]=board[i][j];
                    board[i][j]='.';
                    flag=true;
                }
            }
        }
        if(flag)return resort(board);
        else{
            for(int i=0;i<board.length;i++){
                StringBuffer buffer = new StringBuffer();
                for(char c:board[i])buffer.append(c);
                result[i] = buffer.toString();
            }
            return result;
        }
    }
    public static void main(String[] arg){
        String[]  s = new String[30];
        for(int i=0;i<30;i++){
            s[i] = "ABCDEFGNMABCDEFGNMABCDEFGNMHJK";
        }
        System.out.println(new Friends4Block().solution(30,30,s));
    }
}
