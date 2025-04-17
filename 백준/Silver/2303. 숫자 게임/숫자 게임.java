import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static ArrayList<int[]> arr;
	static int[] result;

	static ArrayList<boolean[]> v;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		result = new int[N];
		v = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int[] a = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			v.add(new boolean[5]);
			arr.add(a);
		}

		for (int i = 0; i < N; i++) {
			bt(i, new ArrayList<>(), 0, 0);
		}

		int resultNum = 0;
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			if (max <= result[i]) {
				max = result[i];
				resultNum = i;
			}
		}

		System.out.println(resultNum + 1);

	}

	static void bt(int idx, ArrayList<Integer> a, int count, int start) {
		if (result[idx] == 9)
			return;

		if (count == 3) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				sum += a.get(i);
			}
			int r = sum % 10;
			if (r > result[idx]) {
				result[idx] = r;
			}
			return;
		}

		for (int i = start; i < 5; i++) {
			if (!v.get(idx)[i]) {
				v.get(idx)[i] = true;
				a.add(arr.get(idx)[i]);
				bt(idx, a, count + 1, i);
				a.remove(a.size() - 1);
				v.get(idx)[i] = false;
			}
		}

	}

}