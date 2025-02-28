

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * SWEA 2115 - 벌꿀채취 문제 해결 클래스 이 코드는 NxN 크기의 벌통에서 두 명의 일꾼이 각각 M개의 벌통을 선택하여 최대
 * C만큼의 꿀을 채취할 때 얻을 수 있는 최대 수익을 계산합니다.
 */
public class Solution {
//public class swea_2115 {

	// 전역 변수 선언
	public static int N, M, C; // N: 벌통 배열의 크기, M: 선택할 수 있는 연속된 벌통의 개수, C: 채취할 수 있는 최대 꿀의 양
	public static int beehiveNN[][] = new int[10][10]; // 벌통 정보를 저장하는 2차원 배열 (각 칸에는 꿀의 양이 저장됨)
	public static int valuearray[] = new int[100]; // 각 위치에서 얻을 수 있는 최대 수익을 저장하는 배열
	public static int ans; // 최종 정답(최대 수익)을 저장할 변수

	/**
	 * 특정 위치(r, c)에서 시작하는 M개의 벌통에서 얻을 수 있는 최대 수익을 계산하는 함수 비트마스킹을 사용하여 모든 부분집합을
	 * 고려합니다.
	 * 
	 * @param r 시작 행 위치
	 * @param c 시작 열 위치
	 * @return 해당 위치에서 얻을 수 있는 최대 수익
	 */
	public static int cal(int r, int c) {
		int ret = 0; // 반환할 최대 수익 값

		// 비트마스킹을 사용하여 M개의 벌통 중 선택할 모든 조합을 고려 (1부터 2^M-1까지)
		for (int i = 1; i < (1 << M); i++) {
			int tsum = 0, ttsum = 0; // tsum: 선택한 꿀의 총량, ttsum: 선택한 꿀의 제곱합(수익)

			// 각 비트(벌통)를 확인
			for (int j = 0; j < M; j++) {
				// i의 j번째 비트가 1이면 해당 벌통 선택
				if ((i & (1 << j)) > 0) {
					tsum += beehiveNN[r][c + j]; // 선택한 벌통의 꿀의 양을 더함
					ttsum += (beehiveNN[r][c + j] * beehiveNN[r][c + j]); // 꿀의 제곱값을 더함 (수익 계산)
				}
			}
			// 선택한 꿀의 총량이 C 이하이고, 현재까지의 최대 수익보다 크면 갱신
			if (tsum <= C && ret < ttsum)
				ret = ttsum;
		}
		return ret; // 최대 수익 반환
	}

	public static void main(String[] args) throws FileNotFoundException {

		// 실행 시간 측정용 코드 (현재는 주석 처리됨)
		// long start = System.currentTimeMillis();

		// 파일에서 입력 받기 위한 코드 (현재는 주석 처리됨)
		// System.setIn(new FileInputStream("벌꿀채취2115input.txt"));
		Scanner sc = new Scanner(System.in); // 표준 입력을 위한 Scanner 객체 생성

		int TC = sc.nextInt(); // 테스트 케이스의 수 입력

		// 각 테스트 케이스 처리
		for (int tc = 1; tc <= TC; tc++) {

			// 기본 정보 입력
			N = sc.nextInt(); // 벌통 배열의 크기
			M = sc.nextInt(); // 선택할 수 있는 연속된 벌통의 개수
			C = sc.nextInt(); // 채취할 수 있는 최대 꿀의 양

			// 벌통 정보 입력
			for (int i = 0; i < N; i++)
				for (int j = 0; j < N; j++)
					beehiveNN[i][j] = sc.nextInt();

			// 각 위치에서 얻을 수 있는 최대 수익 계산 및 저장
			int v_idx = 0; // valuearray의 인덱스
			for (int i = 0; i < N; i++) { // 모든 행에 대해
				int j;
				// 각 행에서 연속된 M개의 벌통을 선택할 수 있는 위치에 대해 최대 수익 계산
				for (j = 0; j < N - M + 1; j++)
					valuearray[v_idx++] = cal(i, j);
				// 선택할 수 없는 위치(배열 끝부분)는 0으로 채움
				for (; j < N; j++)
					valuearray[v_idx++] = 0;
			}

			ans = 0; // 최종 답변 초기화

			// 두 명의 일꾼이 서로 겹치지 않게 벌통을 선택하는 모든 경우 고려
			for (int i = 0; i < v_idx - M; i++) // 첫 번째 일꾼의 위치
				for (int j = i + M; j < v_idx; j++) // 두 번째 일꾼의 위치 (첫 번째 일꾼과 겹치지 않도록)
					if (ans < (valuearray[i] + valuearray[j])) // 더 높은 수익을 찾으면 갱신
						ans = valuearray[i] + valuearray[j];

			// 결과 출력
			System.out.printf("#%d %d\n", tc, ans);
		}
		// 실행 시간 출력 (현재는 주석 처리됨)
		// System.out.println(( System.currentTimeMillis() - start )/1000.0 );
		sc.close(); // Scanner 객체 닫기
	}
}