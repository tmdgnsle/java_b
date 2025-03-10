import java.io.*;
import java.util.*;

public class Main {
	static boolean[] v;
	static ArrayList<Integer> arr;
	static String max_result;
	static String min_result;
	static double max;
	static double min;
	static String[] oper;
	static int k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		oper = new String[k];
		v = new boolean[10];
		arr = new ArrayList<>();
		max = Double.MIN_VALUE;
		min = Double.MAX_VALUE;

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < k; i++) {
			oper[i] = st.nextToken();
		}

		for (int i = 0; i < 10; i++) {
			v[i] = true;
			arr.add(i);
			bt(0, i);
			v[i] = false;
			arr.remove(arr.size() - 1);
		}

		System.out.println(max_result);
		System.out.println(min_result);

	}

	static void bt(int idx, double current) {
		if (arr.size() == k + 1) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < k + 1; i++) {
				sb.append(arr.get(i));
			}

			double temp = Double.parseDouble(sb.toString());
			if (max < temp) {
				max = temp;
				max_result = sb.toString();
			}
			if (min > temp) {
				min = temp;
				min_result = sb.toString();
			}

			return;
		}

		for (int i = 0; i < 10; i++) {
			if (!v[i]) {
				if (oper[idx].equals("<")) {
					if (current < i) {
						v[i] = true;
						arr.add(i);
						bt(idx + 1, i);
						v[i] = false;
						arr.remove(arr.size() - 1);
					}
				} else {
					if (current > i) {
						v[i] = true;
						arr.add(i);
						bt(idx + 1, i);
						v[i] = false;
						arr.remove(arr.size() - 1);
					}
				}
			}
		}

	}
}