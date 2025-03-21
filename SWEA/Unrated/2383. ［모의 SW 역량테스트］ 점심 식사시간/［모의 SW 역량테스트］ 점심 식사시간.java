import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static ArrayList<int[]> person;
	static int[] stair1, stair2;
	static boolean[] first;
	static int personCount;
	static int result;

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input_2383.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			person = new ArrayList<>();

			personCount = 0;
			result = Integer.MAX_VALUE;
			stair1 = null;
			stair2 = null;
			N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int p = Integer.parseInt(st.nextToken());

					if (p == 1) {
						person.add(new int[] { i, j });
						personCount++;
					}
					if (p > 1) {
						if (stair1 == null) {
							stair1 = new int[] { i, j, p };
						} else {
							stair2 = new int[] { i, j, p };
						}
					}
				}

			}
			first = new boolean[personCount];
			subset(0);

			System.out.println("#" + t + " " + result);
		}

	}

	static void subset(int idx) {
		if (idx >= personCount) {

			simulate();

			return;
		}
		first[idx] = true;
		subset(idx + 1);
		first[idx] = false;
		subset(idx + 1);
	}

	static void simulate() {
		// 각 계단에 대한 대기열 생성
		PriorityQueue<Integer> waitQueue1 = new PriorityQueue<>(); // 계단1을 기다리는 사람들
		PriorityQueue<Integer> waitQueue2 = new PriorityQueue<>(); // 계단2를 기다리는 사람들
		Queue<Integer> stairQueue1 = new LinkedList<>(); // 현재 계단1에 있는 사람들
		Queue<Integer> stairQueue2 = new LinkedList<>(); // 현재 계단2에 있는 사람들

		// 각 사람이 지정된 계단까지 도착하는 시간 계산
		for (int i = 0; i < personCount; i++) {
			int[] p = person.get(i);
			if (first[i]) {
				// 계단1까지의 거리 (맨해튼 거리)
				int dist = Math.abs(p[0] - stair1[0]) + Math.abs(p[1] - stair1[1]);
				waitQueue1.add(dist);
			} else {
				// 계단2까지의 거리 (맨해튼 거리)
				int dist = Math.abs(p[0] - stair2[0]) + Math.abs(p[1] - stair2[1]);
				waitQueue2.add(dist);
			}
		}

		int currentTime = 0;
		// 모든 사람이 계단을 내려갈 때까지 시뮬레이션
		while (!waitQueue1.isEmpty() || !waitQueue2.isEmpty() || !stairQueue1.isEmpty() || !stairQueue2.isEmpty()) {

			// 계단에서 사람들 이동
			int size1 = stairQueue1.size();
			for (int i = 0; i < size1; i++) {
				int remainingTime = stairQueue1.poll();
				if (remainingTime - 1 > 0) {
					stairQueue1.add(remainingTime - 1);
				}
			}

			int size2 = stairQueue2.size();
			for (int i = 0; i < size2; i++) {
				int remainingTime = stairQueue2.poll();
				if (remainingTime - 1 > 0) {
					stairQueue2.add(remainingTime - 1);
				}
			}

			// 대기열에서 계단으로 사람 이동 (계단당 최대 3명)
			while (!waitQueue1.isEmpty() && stairQueue1.size() < 3) {
				int arrivalTime = waitQueue1.peek();
				if (arrivalTime <= currentTime) {
					waitQueue1.poll();
					stairQueue1.add(stair1[2]); // 계단1의 길이를 남은 시간으로 추가
				} else {
					break;
				}
			}

			while (!waitQueue2.isEmpty() && stairQueue2.size() < 3) {
				int arrivalTime = waitQueue2.peek();
				if (arrivalTime <= currentTime) {
					waitQueue2.poll();
					stairQueue2.add(stair2[2]); // 계단2의 길이를 남은 시간으로 추가
				} else {
					break;
				}
			}

			currentTime++;
		}

		// currentTime - 1은 모든 사람이 계단을 내려간 시간
		result = Math.min(result, currentTime);
	}
}