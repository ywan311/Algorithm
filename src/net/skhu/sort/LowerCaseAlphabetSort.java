package net.skhu.sort;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LowerCaseAlphabetSort {
//	static char[] sort(char[] a) {//알파벳 소문자용 범위가 넘어가면 error
//		int[] cnt = new int[26];
//		for(int i=0;i<=a.length-1;i++) {
//			int v =a[i]-'a';
//			cnt[v]++;
//			}
//		int j=0;
//		for(int i=0;i<=cnt.length-1;i++) {
//			if(cnt[i]!=0) {
//				for(int k=cnt[i];k>0;k--)
//					a[j++]=(char)(i+'a');
//			}
//		}
//		return a;
//	}
	public static void countingSort(char[] a) {
		Map<Character,Integer> counts = new TreeMap<>();
		for(char c:a) {
			Integer i = counts.get(c);
			if(i==null) i=0;
			counts.put(c,i+1);
		}
		int index=0;
		for(char c: counts.keySet()) {
			for(int i=0;i<counts.get(c);++i) {
				a[index++]=c;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] a = "hi im kim nice to meet you!!".toCharArray();
		System.out.println(Arrays.toString(a));
		countingSort(a);
		System.out.println(Arrays.toString(a));
	}

}
