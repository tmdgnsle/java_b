

import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> result;
	static int[] nums;
	static boolean[] v;
	static LinkedHashSet<String> set;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		v = new boolean[N];
		result = new ArrayList<Integer>();
		set = new LinkedHashSet<String>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		bt(0);

		for (String s : set) {
			System.out.println(s);
		}

	}

	static void bt(int current) {
		if (result.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result.get(i)).append(" ");
			}
			set.add(sb.toString());
			sb = new StringBuilder();
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				if (nums[i] >= current) {
					v[i] = true;
					result.add(nums[i]);

					bt(nums[i]);

					v[i] = false;
					result.remove(result.size() - 1);
				}
			}
		}

	}

}
