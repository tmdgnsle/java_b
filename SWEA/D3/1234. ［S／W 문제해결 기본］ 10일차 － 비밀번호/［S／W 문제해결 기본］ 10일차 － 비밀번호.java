

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			String pass = sc.nextLine();

			Stack<String> stack = new Stack<>();
			
			for (int i = 1; i <= N; i++) {
				String s = pass.substring(i, i + 1);
//				System.out.print(s + " ");
				if (stack.isEmpty()) {
					stack.push(s);
				} else {
					if (stack.peek().equals(s)) {
						stack.pop();
					} else {
						stack.push(s);
					}
				}

			}
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.reverse();
			System.out.println("#" + t + " " + sb);
		}
	}
}
