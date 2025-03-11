import java.io.*;
import java.util.*;

public class Solution {
	static int max;
	static String number;
	static int change_count;
	static HashSet<String>[] v;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1244.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			number = st.nextToken();
			change_count = Integer.parseInt(st.nextToken());

			v = new HashSet[change_count + 1];
			for (int i = 0; i <= change_count; i++) {
				v[i] = new HashSet<>();
			}

			max = 0;

			dfs(number.toCharArray(), 0);

			System.out.println("#" + t + " " + max);

		}
	}

	static void dfs(char[] numbers, int count) {
		String current = new String(numbers);

		if (v[count].contains(current))
			return;

		v[count].add(current);

		if (count == change_count) {
			int value = Integer.parseInt(current);
			max = Math.max(value, max);
			return;
		}

		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				swap(numbers, i, j);
				dfs(numbers, count + 1);
				swap(numbers, i, j);
			}
		}

	}

	static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}