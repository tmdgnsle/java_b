import java.io.*;
import java.util.*;

public class Solution {
	static int result;
	static String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_1240.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int end = 0;
			int row = 0;
			int[][] arr = new int[N][M];
			result = 0;
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					String s = str.substring(j, j + 1);
					arr[i][j] = Integer.parseInt(s);
//					System.out.print(arr[i][j]);
				}
//				System.out.println();
			}

			for (int i = 0; i < N; i++) {
				for (int j = M - 1; j >= 0; j--) {
					if (arr[i][j] == 1) {
						row = i;
						end = j;
						break;
					}
				}
			}

//			System.out.println("row: " + row + " end: " + end);

			int start = end - 55;
			int[] hash = new int[56];

			for (int i = 0; i < 56; i++) {
				hash[i] = arr[row][start + i];
				
			}
			
			

			solveHash(hash);
			System.out.println("#" + t + " " + result);

		}
	}

	static void solveHash(int[] hash) {
		int[] num = new int[8];
		int idx = 0;
		StringBuilder sb;
		for (int i = 0; i < 56; i += 7) {
			sb = new StringBuilder();
			for (int j = i; j < i + 7; j++) {
				sb.append(hash[j]);
			}

			for (int j = 0; j < 10; j++) {
				if (code[j].equals(sb.toString()))
					num[idx++] = j;
			}

		}

		int hol = 0;
		int jjak = 0;
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			if (i % 2 == 0) {
				jjak += num[i];
			} else {
				hol += num[i];
			}
			sum += num[i];
		}

		int temp = 3 * jjak + hol;

		if (temp % 10 == 0) {
			result = sum;
		}

	}

}