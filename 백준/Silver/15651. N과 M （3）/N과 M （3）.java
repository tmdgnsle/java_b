
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Integer> result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		result = new ArrayList<Integer>();

		bt();
        System.out.println(sb);
	}

	static void bt() {
		if (result.size() == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result.get(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= N; i++) {
			result.add(i);
			bt();
			result.remove(result.size() - 1);
		}
	}
}
