

import java.io.*;
import java.util.*;

public class Solution {
	static int N;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1224.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			String exam = br.readLine();
			exam = change(exam);
			long result = oper(exam);

			System.out.println("#" + t + " " + result);
		}
	}

	static int getPriority(char op) {
		switch (op) {
		case '(':
			return 0;
		case '+':
			return 1;
		case '*':
			return 2;
		default:
			return -1;
		}
	}

	static String change(String infix) {
		StringBuilder postfix = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (char c : infix.toCharArray()) {
			if (Character.isDigit(c)) {
				postfix.append(c);
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (stack.peek() != '(') {
					postfix.append(stack.pop());
				}

				stack.pop(); // '(' 제거
			} else { // 연산자
				while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)) {
					postfix.append(stack.pop());
				}
				stack.push(c);
			}
		}

		while (!stack.isEmpty()) {
			postfix.append(stack.pop());
		}

		return postfix.toString();
	}

	static long oper(String str) {
		long result = 0;
		Stack<Long> stack = new Stack<>();
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				stack.push(Long.parseLong("" + c));
			} else if (c == '+') {
				long b = stack.pop();
				long a = stack.pop();
				result = a + b;
				stack.push(result);
			} else if (c == '*') {
				long b = stack.pop();
				long a = stack.pop();
				result = a * b;
				stack.push(result);
			}
		}

		return stack.pop();
	}

}
