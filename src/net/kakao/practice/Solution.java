package net.kakao.practice;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

	static HashMap<String, String> userList = new HashMap<>();
	public static String[] solution(String[] record) {
		if (record.length > 10000) {
			System.out.println("record scope over!");
			return null;
		}
		String[] answer = new String[record.length];
		for (int i = 0; i < record.length; i++) {
			answer[i] = split(record[i]);
		}
		return answer;
	}

	static String split(String s) {
		String[] tmp = s.split("\\s");// 0=commad 1=id 2=nickname
		System.out.println(userList);
		System.out.println(Arrays.toString(tmp));

		if (tmp[0].equals("Enter")) {
			if (userList.isEmpty() || !(userList.containsKey(tmp[1]))) {
				userList.put(tmp[1], tmp[2]);
				return tmp[2] + "님이 입장하였습니다.";
			} else
				return tmp[2] + "enter err";
		} else if (tmp[0].equals("Leave")) {
			if (userList.isEmpty() || !(userList.containsKey(tmp[1])))
				return "leave err";
			else {
				String nick = userList.get(tmp[1]);
				userList.remove(tmp[1]);
				return nick + "님이 나갔습니다.";
			}
		} else if (tmp[0].equals("Change")) {
			if(userList.isEmpty() || !(userList.containsKey(tmp[1])))
				return tmp[2]+"change err";
			else {
				userList.replace(tmp[1], tmp[2]);
				return tmp[2]+"로 닉네임이 변경되었습니다.";
			}
		}else
			return "unknown err";

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] answer = solution(input);
		System.out.println(Arrays.toString(answer));
	}

}
