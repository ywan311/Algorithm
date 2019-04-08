package net.skhu.stack;

import java.util.Arrays;
import java.util.Scanner;

public class MyStack<T> {
	static final int INITIAL_SIZE = 10;
	static final double GROWTH_RATE = 2.0;
	Object[] data;
	int count;

	public MyStack() {
		data = new Object[INITIAL_SIZE];
		count = 0;
	}

	public boolean isFull() {
		return data.length == count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public int size() {
		return count;
	}

	public void expand() {
		data = Arrays.copyOf(data, (int) (data.length * GROWTH_RATE));
	}

	public void push(T value) {
		if (isFull())
			expand();
		data[count] = value;
		++count;
	}

	@SuppressWarnings("unchecked")
	public T pop() throws Exception {
		if (isEmpty())
			throw new Exception("stack empty");
		--count;
		return (T) data[count];
	}

	@SuppressWarnings("unchecked")
	public T top() throws Exception {
		if (isEmpty())
			throw new Exception("stack empty");
		return (T) data[count - 1];
	}

	

	public void add() {

	}

	public void subtract() {
	}

	public void multiply() {
	}

	public void divide() {
	}

	public static void main(String arg[]) {
		Scanner input = new Scanner(System.in);
		MyStack stack = new MyStack();

		System.out.println("input command");
		while (true) {

			String cmd = input.next();

			if (cmd.startsWith("push")) {
				String value = cmd.substring(4);
				System.out.println(value.toString());
				stack.push(Integer.parseInt(value));
				System.out.println("push:" + value);
			} else if (cmd.startsWith("pop")) {

			} else if (cmd.startsWith("size")) {
				System.out.println("size:" + stack.size());
			} else if (cmd.startsWith("empty")) {
				System.out.println("empty:" + stack.isEmpty());
			} else if (cmd.startsWith("top")) {
			} else if (cmd.startsWith("print")) {
				
			} else if (cmd.startsWith("add")) {
				stack.add();
				System.out.print("add:");
				
			} else if (cmd.startsWith("subtrack")) {
				stack.subtract();
				System.out.print("subtrack:");
				
			} else if (cmd.startsWith("multiply")) {
				stack.multiply();
				System.out.print("multiply:");
				
			} else if (cmd.startsWith("divide")) {
				stack.divide();
				System.out.print("divide:");
				
			} else if (cmd.startsWith("quit"))
				break;
			else
				System.out.println("다시입력하시오.");
		}
	}
}
