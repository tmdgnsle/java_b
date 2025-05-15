import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String words = br.readLine();

			Deque<Integer> deque = new ArrayDeque<>();

			// 입력 처리
			if (N > 0) {
				String[] nums = words.substring(1, words.length() - 1).split(",");
				for (String num : nums) {
					deque.add(Integer.parseInt(num));
				}
			}

			boolean isReversed = false;
			boolean isError = false;
			for (int i = 0; i < command.length(); i++) {
				String c = command.substring(i, i + 1);

				if (c.equals("R")) {
					isReversed = !isReversed;
				} else {
					if (deque.isEmpty()) {
						isError = true;
						break;
					}
					if (isReversed) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}

			}
			if (!isError) {
				System.out.print("[");
				while (!deque.isEmpty()) {
					if (isReversed) {
						if (deque.size() == 1) {
							System.out.print(deque.pollLast());
						} else {
							System.out.print(deque.pollLast() + ",");
						}
					} else {
						if (deque.size() == 1) {
							System.out.print(deque.pollFirst());
						} else {
							System.out.print(deque.pollFirst() + ",");
						}
					}
				}
				System.out.println("]");
			} else {
				System.out.println("error");
			}

		}
	}
}