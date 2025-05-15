import java.io.*;
import java.util.*;

public class Solution {

	static class Work {
		int person;
		int work;
		int time;

		Work(int person, int work, int time) {
			this.person = person;
			this.work = work;
			this.time = time;
		}
	}

	static int N, K;
	static ArrayList<Work>[] arr;
	static int[] b;
	static int[] a;
	static ArrayList<Work> ar;

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_13041.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			arr = new ArrayList[K + 1];
			for (int i = 0; i < K + 1; i++) {
				arr[i] = new ArrayList<>();
			}

			b = new int[N + 1];
			a = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
//				arr[i].add(Integer.parseInt(st.nextToken()));
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= N; i++) {
				int person = i;
				int work = a[i];
				int time = b[i];

				arr[work].add(new Work(person, work, time));
			}

			ar = new ArrayList<>();
			int sortCount = 0;
			for (int i = 1; i <= K; i++) {
				if (arr[i].size() > 1) {
					arr[i].sort(new Comparator<Work>() {
						@Override
						public int compare(Work o1, Work o2) {
							return o1.time - o2.time;
						}
					});

					for (int j = 0; j < arr[i].size() - 1; j++) {
						ar.add(arr[i].get(j));
					}
				} else if (arr[i].size() == 0) {
					sortCount++;
				} else
					continue;

			}

			ar.sort(new Comparator<Work>() {
				@Override
				public int compare(Work o1, Work o2) {
					return o1.time - o2.time;
				}
			});

			long result = 0;

			for (int i = 0; i < sortCount; i++) {
				result += ar.get(i).time;
			}

			System.out.println("#" + t + " " + result);

		}
	}
}