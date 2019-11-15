package net.kakao.practice.OpenKatalk;

import java.util.Arrays;
import java.util.HashMap;

class OpenKakaotalk {

	static HashMap<String, String> userList = new HashMap<>();
	public static String[] solution(String[] record) {
		if (record.length > 10000) {
			System.out.println("record scope over!");
			return null;
		}
		int cnt=0;//배열의 크기
		for(int i =0;i<record.length;i++) {
			if(record[i].startsWith("Enter")||record[i].startsWith("Leave"))
				cnt++;
		}
		String[] answer = new String[cnt];
		for (int i = 0; i < record.length; i++) {
			String[] tmp = record[i].split("\\s");// 0=command 1=id 2=nickname


			if (tmp[0].equals("Enter")) {
				if (userList.isEmpty() || !(userList.containsKey(tmp[1]))) {
					userList.put(tmp[1], tmp[2]);
					answer[i]= tmp[2] + "님이 입장하였습니다.";
				} else
					answer[i]= tmp[2] + "enter err";
			} else if (tmp[0].equals("Leave")) {
				if (userList.isEmpty() || !(userList.containsKey(tmp[1])))
					answer[i]= "leave err";
				else {
					String nick = userList.get(tmp[1]);
					userList.remove(tmp[1]);
					answer[i]= nick + "님이 나갔습니다.";
				}
			} else if (tmp[0].equals("Change")) {
				if(userList.isEmpty() || !(userList.containsKey(tmp[1])))
					answer[i]= tmp[2]+"change err";
				else {
					userList.replace(tmp[1], tmp[2]);
				}
			}else
				answer[i]= "unknown err";
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
