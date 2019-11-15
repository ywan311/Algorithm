package net.Programmers.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DayOfWeek {
    public String solution(int a, int b){
        String answer = "";
        String inputDate = "2016-";
        inputDate+=a+"-";
        inputDate+=b;
        SimpleDateFormat form = new SimpleDateFormat("yyyy-M-d");
        try {
            Date date = form.parse(inputDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            switch (cal.get(Calendar.DAY_OF_WEEK)){
                case 1:
                    answer ="SUN";
                    break;
                case 2:
                    answer ="MON";
                    break;
                case 3:
                    answer ="TUE";
                    break;
                case 4:
                    answer ="WED";
                    break;
                case 5:
                    answer ="THU";
                    break;
                case 6:
                    answer ="FRI";
                    break;
                case 7:
                    answer ="SAT";
                    break;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*
        ***** 캘린더 사용 우수답변
        * Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
        *        .setDate(2016, month - 1, day).build();
        *return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
        *
        * ***** 캘린더 미사용 우수답변
        * String answer = "";
        *String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        *int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        *int allDate = 0;
        *for (int i = 0; i < a - 1; i++) {
        *    allDate += date[i];
        *}
        *allDate += (b - 1);
        *answer = day[allDate % 7];
        *
        *return answer;
        * */
        return answer;
    }
    public static void main(String[] args){
        DayOfWeek d = new DayOfWeek();
        System.out.println(d.solution(5,25));
    }
}
