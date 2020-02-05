package net.Programmers.practice.Hash;

import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phone_book) {//효율성 테스트 통과 x
        int tmp=0;
        Arrays.sort(phone_book,(o1, o2) -> {
            if(o1.length()>=o2.length())return 1;
            else return -1;
        });
        for(int i=1;i<phone_book.length;i++){
            tmp = phone_book[i].length();
            if(tmp < phone_book[0].length()) {
                continue;
            }

            if(phone_book[0].equals(phone_book[i].substring(0,phone_book[0].length()))) {
                return false;
            }
        }

        return true;
        /*
        *Arrays.sort로 String 정렬시에는 가장 앞 자리부터 오름차순으로 정렬
        * 따라서 다음 인덱스의 값만 비교하면 효율성 상승
        * boolean answer =true;
        Arrays.sort(phone_book);
        for(int i=0; i<phone_book.length-1; i++ ){
            if(phone_book[i+1].startsWith(phone_book[i]))
            {answer= false; break;}
        }
        return answer;
        * */
    }
    public static void main(String[] args){
        System.out.println(new PhoneBook().solution(new String[]{"12","123","1235","567","88"}));
    }
}
