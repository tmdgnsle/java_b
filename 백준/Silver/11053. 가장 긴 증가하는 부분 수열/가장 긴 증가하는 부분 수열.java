import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수열의 크기 N 입력
        int N = Integer.parseInt(br.readLine());
        
        // 수열 입력
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        // dp[i] = A[i]를 마지막 원소로 가지는 가장 긴 증가하는 부분 수열의 길이
        int[] dp = new int[N];
        
        // 모든, 부분 수열의 최소 길이는 1 (자기 자신만 포함)
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
        }
        
        // 다이나믹 프로그래밍
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // A[j] < A[i]인 경우, A[i]는 A[j] 뒤에 올 수 있음
                if (A[j] < A[i]) {
                    // 기존 dp[i]와 dp[j] + 1 중 큰 값으로 갱신
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        // 최대 길이 찾기
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        // 결과 출력
        System.out.println(maxLength);
    }
}