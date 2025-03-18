import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // n 입력 받기
        int n = Integer.parseInt(br.readLine());
        
        // dp 배열 초기화
        int[] dp = new int[1001]; // 문제 제약: 1 ≤ n ≤ 1,000
        
        // 초기값 설정
        dp[1] = 1;
        dp[2] = 3;
        
        // 점화식: dp[i] = dp[i-1] + 2 * dp[i-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }
        
        // 결과 출력
        System.out.println(dp[n]);
    }
}