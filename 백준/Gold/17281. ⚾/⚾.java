import java.io.*;
import java.util.*;

public class Main {

	// 승훈아 혼자 병원 가니까 좋아 ?
	// 혼자 농땡이 치니까 좋아 ?
	// 야구나 풀어-

	static ArrayList<Integer>[] hit;
	static int N;
	static boolean[] v;
	static ArrayList<Integer> arr;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		hit = new ArrayList[9];

		for (int i = 0; i < 9; i++) {
			hit[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				hit[j].add(Integer.parseInt(st.nextToken()));
			}
		}

		v = new boolean[9];
		v[0] = true;
		result = Integer.MIN_VALUE;

		arr = new ArrayList<>();

		bt(0);

		System.out.println(result);

	}

	static void bt(int cnt) {
		if (cnt == 8) {
			int idx = 0;
			int[] hitter = new int[9];
			for (int i = 0; i < 8; i++) {
				if (idx == 3) {
					hitter[idx++] = 0;
					i--;
				} else {
					hitter[idx++] = arr.get(i);
				}
			}

			calculate(hitter);

			return;
		}

		for (int i = 1; i < 9; i++) {
			if (!v[i]) {
				v[i] = true;
				arr.add(i);
				bt(cnt + 1);
				v[i] = false;
				arr.remove(arr.size() - 1);
			}
		}
	}

	static void calculate(int[] hitter) {
		int score = 0;
		int y = 1;
		int out;
		boolean[] ru;
		int next = 0;

		while (y <= N) {
			out = 0;
			ru = new boolean[3];
			while (out < 3) {
				int h = hit[hitter[next]].get(y-1);

				if (h == 0) {
					out++;
				} else if (h == 1) {
					if (ru[2]) {
						score++;
						ru[2] = false;
					}

					if (ru[1]) {
						ru[1] = false;
						ru[2] = true;
					}

					if (ru[0]) {
						ru[0] = false;
						ru[1] = true;
					}

					ru[0] = true;

				} else if (h == 2) {
					if (ru[2]) {
						score++;
						ru[2] = false;
					}

					if (ru[1]) {
						score++;
						ru[1] = false;
					}

					if (ru[0]) {
						ru[0] = false;
						ru[2] = true;
					}

					ru[1] = true;

				} else if (h == 3) {

					if (ru[2]) {
						score++;
						ru[2] = false;
					}

					if (ru[1]) {
						score++;
						ru[1] = false;
					}

					if (ru[0]) {
						score++;
						ru[0] = false;
					}

					ru[2] = true;

				} else if (h == 4) {
					if (ru[2]) {
						score++;
						ru[2] = false;
					}

					if (ru[1]) {
						score++;
						ru[1] = false;
					}

					if (ru[0]) {
						score++;
						ru[0] = false;
					}

					score++;
				}

				next += 1;

				if (next == 9)
					next = 0;

			}
			y++;
		}

		result = Math.max(result, score);

	}

}