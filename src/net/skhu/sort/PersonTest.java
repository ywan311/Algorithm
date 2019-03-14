package net.skhu.sort;

import java.util.Arrays;

public class PersonTest {
	static PersonNameComparator comparator = new PersonNameComparator();

	static void swap(Person[] a, int i, int j) {
		Person tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;

	}

	static int findMin(Person[] a, int start) {

		Person min = a[start];
		int minIndex = start;
		for (int i = start; i <= a.length - 1; i++) {
			if (comparator.compare(min, a[i]) > 0) {
				min = a[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	static void selectionSort(Person[] a) {
		for (int i = 0; i < a.length - 1; ++i) {
			int minIndex = findMin(a, i); // 배열 a의 i 위치부터 끝까지에서 가장 작은 값을 찾아서
			swap(a, i, minIndex); // 그 값을 i 위치로 이동한다
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] people = new Person[10];
		people[0] = new Person("hong", 22);
		people[1] = new Person("kim", 21);
		people[2] = new Person("kim", 23);
		people[3] = new Person("lee", 24);
		people[4] = new Person("choi", 22);
		people[5] = new Person("lee", 21);
		people[6] = new Person("park", 22);
		people[7] = new Person("lee", 24);
		people[8] = new Person("choi", 27);
		people[9] = new Person("lee", 21);
		System.out.println(Arrays.toString(people));
		selectionSort(people);
		System.out.println(Arrays.toString(people));
	}

}
