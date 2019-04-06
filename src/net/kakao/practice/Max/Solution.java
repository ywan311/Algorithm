package net.kakao.practice.Max;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
	public String solution(int[] numbers) {
		String answer = "";
		String[] num = new String[numbers.length];
        if(numbers.length==0) return answer="0";
		int i = 0;
		for (int a : numbers) {
			num[i++] = String.valueOf(a);
		}
		Arrays.sort(num,new compares());
		for(String a:num) {
			answer+=a;
		}
		BigInteger value = new BigInteger(answer);
		BigInteger zeroTest = new BigInteger("1");
        if(value.compareTo(zeroTest)==-1) return answer ="0";
		return answer;
	}

	public class compares implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			return(o2+o1).compareTo(o1+o2);
		}

	}

	public static void main(String[] arg) {
		int[] nums = {123,78,652,15,506,777,989,98,9};
		String answer =new Solution().solution(nums);
		System.out.println(answer);
	}
}