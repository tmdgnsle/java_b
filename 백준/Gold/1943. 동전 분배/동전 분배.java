import java.io.*;
import java.util.*;

public class Main {
    static boolean[] dp;
    static ArrayList<int[]> moneys;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            moneys = new ArrayList<>();
            int totalMoney = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int money = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                totalMoney += money * count;
                moneys.add(new int[]{money, count});
            }

            // 합이 홀수면 반반 불가능
            if (totalMoney % 2 == 1) {
                System.out.println(0);
                continue;
            }

            int target = totalMoney / 2;
            dp = new boolean[target + 1];
            dp[0] = true;

            for (int i = 0; i < N; i++) {
                int money = moneys.get(i)[0];
                int count = moneys.get(i)[1];

                boolean[] next = dp.clone();

                for (int j = 0; j <= target; j++) {
                    if (!dp[j]) continue;

                    for (int k = 1; k <= count; k++) {
                        int ns = j + money * k;
                        if (ns > target) break;
                        next[ns] = true;
                    }
                }

                dp = next;

                // 이미 목표 만들 수 있으면 더 볼 필요 없음(선택 최적화)
                if (dp[target]) break;
            }

            System.out.println(dp[target] ? 1 : 0);
        }
    }
}
