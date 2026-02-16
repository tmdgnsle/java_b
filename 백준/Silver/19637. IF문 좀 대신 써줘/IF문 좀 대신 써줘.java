import java.io.*;
import java.util.*;

public class Main {

    static String[] title;
    static int[] power;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        title = new String[N];
        power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            int idx = lowerBound(x);
            sb.append(title[idx]).append("\n");
        }

        System.out.print(sb);
    }

    // 첫 번째로 power[mid] >= target 인 인덱스 반환
    static int lowerBound(int target) {
        int lo = 0;
        int hi = power.length - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (power[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}