import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4]; // dp[i][j] -> i를 j 이하의 수로 표현한 갯수
        dp[0][1] = dp[0][2] = dp[0][3] = 1;

        for (int i = 1; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];

            dp[i][2] = dp[i][1];
            if (i >= 2) {
                dp[i][2] += dp[i - 2][2];
            }

            dp[i][3] = dp[i][2];
            if (i >= 3) {
                dp[i][3] += dp[i - 3][3];
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            bw.write(dp[n][3] + "\n");
        }

        bw.flush();
        bw.close();
    }

}