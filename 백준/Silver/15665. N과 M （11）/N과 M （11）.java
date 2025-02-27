
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] nums;
	static ArrayList<Integer> result;
	static StringBuilder sb = new StringBuilder();
	static LinkedHashSet<String> set;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		nums = new int[N];
		result = new ArrayList<Integer>();
		set = new LinkedHashSet<String>();

		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		Arrays.sort(nums);
		
		bt();

		for (String s : set) {
			sb.append(s).append("\n");
//			System.out.println(s);
		}
		
		System.out.println(sb);

	}

	static void bt() {
		if (result.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result.get(i)).append(" ");
			}
			set.add(sb.toString());
			sb = new StringBuilder();
			return;
		}

		for (int i = 0; i < N; i++) {
			result.add(nums[i]);

			bt();

			result.remove(result.size() - 1);

		}

	}

}
