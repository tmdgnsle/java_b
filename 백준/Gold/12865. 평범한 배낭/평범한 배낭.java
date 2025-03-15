import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 물품의 수
        int K = Integer.parseInt(st.nextToken());    // 버틸 수 있는 무게

        int[] weights = new int[N + 1];   // 각 물건의 무게
        int[] values = new int[N + 1];    // 각 물건의 가치

        // 물건 정보 입력 받기
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블: dp[i][j] = i번째 물건까지 고려했을 때, 무게 j의 가방에 넣을 수 있는 최대 가치
        int[][] dp = new int[N + 1][K + 1];

        // DP 계산
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                // 현재 물건(i)의 무게가 가방 용량(j)보다 크면 넣을 수 없음
                if (weights[i] > j) {
                    dp[i][j] = dp[i - 1][j];  // 이전 물건까지 고려한 최대 가치를 그대로 사용
                }
                // 현재 물건을 넣을 수 있는 경우
                else {
                    // 두 가지 경우 중 최대값 선택
                    // 1. 현재 물건을 넣지 않는 경우 (이전 물건까지의 최대 가치)
                    // 2. 현재 물건을 넣는 경우 (이전 물건까지 고려하여 [현재 무게 - 현재 물건 무게]의 최대 가치 + 현재 물건의 가치)
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
                }
            }
        }

        // 최종 결과 출력 (모든 물건을 고려하고 최대 무게 K일 때의 최대 가치)
        System.out.println(dp[N][K]);
    }
}