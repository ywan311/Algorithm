package net.kakao.practice.OpenKatalk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

class OpenKakaotalk {


	public static String[] solution(String[] record) {
        HashMap<String, String> userList = new HashMap<>();
        ArrayList<String> room = new ArrayList<>();
        ArrayList<Boolean> flag = new ArrayList<>();

        String[] answer = {};
        for(int i=0;i<record.length;i++){
            String[] tmp = record[i].split("\\s");
            if(tmp[0].equals("Enter")||tmp[0].equals("Change")){
                userList.put(tmp[1],tmp[2]);
                if(tmp[0].equals("Enter")){
                    room.add(tmp[1]);
                    flag.add(true);
                }
            }else{
                room.add(tmp[1]);
                flag.add(false);
            }
        }
        answer = new String[room.size()];
        int index=0;
        while(!room.isEmpty()){
            StringBuilder builder = new StringBuilder();
            builder.append(userList.get(room.remove(0)));
            if(flag.remove(0))builder.append("님이 들어왔습니다.");
            else builder.append("님이 나갔습니다.");
            answer[index++]= builder.toString();
        }

	    return answer;
	}

	public static void main(String[] args) {
		String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] answer = solution(input);
		System.out.println(Arrays.toString(answer));
		System.out.println(answer.length);
	}

}
