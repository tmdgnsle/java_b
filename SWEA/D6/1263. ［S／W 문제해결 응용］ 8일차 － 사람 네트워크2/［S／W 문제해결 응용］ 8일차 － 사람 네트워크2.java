import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());

			// 인접 행렬 초기화
			int[][] graph = new int[N][N];

			// 그래프 정보 입력
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
					// 연결되어 있지 않은 경우(0) 무한대 값으로 설정
					if (i != j && graph[i][j] == 0) {
						graph[i][j] = 1000000; // 충분히 큰 값
					}
				}
			}

			// 플로이드-워셜 알고리즘 수행
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
					}
				}
			}

			// 각 사람의la CC 계산 및 최소값 찾기
			int minCC = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				int cc = 0;
				for (int j = 0; j < N; j++) {
					if (i != j) {
						cc += graph[i][j];
					}
				}
				minCC = Math.min(minCC, cc);
			}

			// 결과 출력
			System.out.println("#" + tc + " " + minCC);
		}
	}
}