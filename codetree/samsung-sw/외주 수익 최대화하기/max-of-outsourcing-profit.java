import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] t, p, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int day = 1; day <= n; day++) {
            // 오늘까지의 최대 수익을 다음 날로 넘김 = 오늘 일을 안 하는 경우
            dp[day + 1] = Math.max(dp[day + 1], dp[day]);

            // 오늘 일을 하는 경우
            int endDay = day + t[day];

            // day에 시작해서 t일 걸리면 endDay 날부터 다음 일 가능
            if (endDay <= n + 1) {
                dp[endDay] = Math.max(dp[endDay], dp[day] + p[day]);
            }
        }

        System.out.println(dp[n + 1]);
    }
}