import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 최소로 필요한 건물 개수: a + b - 1
        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        int tallest = Math.max(a, b);      // 가장 높은 건물 높이
        int baseLen = a + b - 1;          // 기본 패턴 길이
        int extra = N - baseLen;          // 추가로 채워야 하는 건물 개수

        int[] ans = new int[N];
        int idx = 0;

        if (a == 1) {
            // 1) 가장 높은 건물 먼저
            ans[idx++] = tallest;

            // 2) 그 뒤에 남는 개수만큼 1 채우기
            for (int i = 0; i < extra; i++) {
                ans[idx++] = 1;
            }

            // 3) 오른쪽 쪽 패턴: b-1 ~ 1
            for (int h = b - 1; h >= 1; h--) {
                ans[idx++] = h;
            }
        } else {
            // a > 1 인 경우

            // 1) 먼저 남는 칸만큼 1을 맨 앞에 채우기
            for (int i = 0; i < extra; i++) {
                ans[idx++] = 1;
            }

            // 2) 왼쪽에서 보이는 건물: 1 ~ a-1
            for (int h = 1; h <= a - 1; h++) {
                ans[idx++] = h;
            }

            // 3) 가장 높은 건물
            ans[idx++] = tallest;

            // 4) 오른쪽에서 보이는 건물: b-1 ~ 1
            for (int h = b - 1; h >= 1; h--) {
                ans[idx++] = h;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}