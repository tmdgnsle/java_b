import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static long[] arr;
    static long[] gain;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        gain = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        long basic = 0;

        for (int i = 0; i < n - 1; i++) {
            basic += Math.abs(arr[i] - arr[i + 1]);
        }

        // i번째 하나만 2배 했을 때 점수 증가량 계산
        for (int i = 0; i < n; i++) {
            long before = 0;
            long after = 0;

            if (i > 0) {
                before += Math.abs(arr[i - 1] - arr[i]);
                after += Math.abs(arr[i - 1] - arr[i] * 2);
            }

            if (i < n - 1) {
                before += Math.abs(arr[i] - arr[i + 1]);
                after += Math.abs(arr[i] * 2 - arr[i + 1]);
            }

            gain[i] = after - before;
        }

        long answer = Long.MIN_VALUE;

        // 인접하지 않은 두 개 선택
        long maxGain = gain[0];

        for (int i = 2; i < n; i++) {
            answer = Math.max(answer, basic + maxGain + gain[i]);
            maxGain = Math.max(maxGain, gain[i - 1]);
        }

        // 인접한 두 개 선택
        for (int i = 0; i < n - 1; i++) {
            long before = 0;
            long after = 0;

            if (i > 0) {
                before += Math.abs(arr[i - 1] - arr[i]);
                after += Math.abs(arr[i - 1] - arr[i] * 2);
            }

            before += Math.abs(arr[i] - arr[i + 1]);
            after += Math.abs(arr[i] * 2 - arr[i + 1] * 2);

            if (i + 1 < n - 1) {
                before += Math.abs(arr[i + 1] - arr[i + 2]);
                after += Math.abs(arr[i + 1] * 2 - arr[i + 2]);
            }

            answer = Math.max(answer, basic + after - before);
        }

        System.out.println(answer);
    }
}